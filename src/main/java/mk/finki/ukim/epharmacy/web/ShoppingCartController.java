package mk.finki.ukim.epharmacy.web;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.transaction.Transactional;
import mk.finki.ukim.epharmacy.model.enumerations.ORDER_STATUS;
import mk.finki.ukim.epharmacy.model.primaryKeys.BrandedDrugKey;
import mk.finki.ukim.epharmacy.model.primaryKeys.BrandedDrugStockKey;
import mk.finki.ukim.epharmacy.model.primaryKeys.OrderShoppingCartKey;
import mk.finki.ukim.epharmacy.model.tables.*;
import mk.finki.ukim.epharmacy.service.interfaces.tables.*;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.*;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/shopping-cart")
public class ShoppingCartController {

    private final BillService billService;
    private final OrderService orderService;
    private final BrandedDrugService brandedDrugService;
    private final GenericDrugService genericDrugService;

    private final PrescriptionService prescriptionService;

    private final OrderShoppingCartService orderShoppingCartService;

    private final BrandedDrugStockService brandedDrugStockService;

    public ShoppingCartController(BillService billService, OrderService orderService, BrandedDrugService brandedDrugService, GenericDrugService genericDrugService, PrescriptionService prescriptionService, OrderShoppingCartService orderShoppingCartService, BrandedDrugStockService brandedDrugStockService) {
        this.billService = billService;
        this.orderService = orderService;
        this.brandedDrugService = brandedDrugService;
        this.genericDrugService = genericDrugService;
        this.prescriptionService = prescriptionService;
        this.orderShoppingCartService = orderShoppingCartService;
        this.brandedDrugStockService = brandedDrugStockService;
    }

    @GetMapping
    public String getPage(HttpServletRequest request, Model model) {
        initializeOrder(request);
        if (request.getSession().getAttribute("map") != null) {
            Map<Long, HashSet<OrderShoppingCart>> map = (Map<Long, HashSet<OrderShoppingCart>>) request.getSession().getAttribute("map");
            Set<OrderShoppingCart> products = map.values().stream().flatMap(Collection::stream).collect(Collectors.toSet());
            Map<Long, String> genericsMap = genericDrugService.findAll()
                    .stream()
                    .collect(Collectors.toMap(
                            GenericDrug::getGenericDrugId,
                            GenericDrug::getGeneric
                    ));
            model.addAttribute("genericsMap", genericsMap);
            model.addAttribute("products", products);
        }
        return "shopping-cart";
    }

    @Transactional
    @PostMapping("/add-to-shopping-cart/{brandedDrugId}/{manufacturerName}/{genericDrugId}/{pharmacyId}")
    public String addToShoppingCart(@PathVariable Long brandedDrugId,
                                    @PathVariable String manufacturerName,
                                    @PathVariable Long genericDrugId,
                                    @PathVariable Long pharmacyId,
                                    @RequestParam Float price,
                                    @RequestParam Integer quantity,
                                    HttpServletRequest request) {

        initializeOrder(request);
        Optional<BrandedDrug> brandedDrug = brandedDrugService.findByKey(new BrandedDrugKey(brandedDrugId, manufacturerName, genericDrugId));
        if (brandedDrug.isPresent()) {
            Order order = (Order) request.getSession().getAttribute("order");
            OrderShoppingCartKey orderShoppingCartKey = new OrderShoppingCartKey(brandedDrug.get().getBrandedDrugKey(), order.getOrderId());
            OrderShoppingCart orderShoppingCart = new OrderShoppingCart(orderShoppingCartKey, brandedDrug.get(), order, price, quantity);
            HashMap<Long, HashSet<OrderShoppingCart>> map = (HashMap<Long, HashSet<OrderShoppingCart>>) request.getSession().getAttribute("map");
            map.putIfAbsent(pharmacyId, new HashSet<>());
            map.get(pharmacyId).add(orderShoppingCart);
            orderShoppingCartService.save(orderShoppingCart);
            request.getSession().setAttribute("map", map);
            double total = brandedDrugStockService.total(map);
            request.getSession().setAttribute("total", String.format("%.2f", total));

        }
        return "redirect:/shopping-cart";


    }

    @PostMapping("/checkout")
    @Transactional
    public String checkout(HttpServletRequest request) {
        Bill bill = (Bill) request.getSession().getAttribute("bill");
        bill.setDateTime(LocalDateTime.now());
        bill.setPaymentStatus(true);
        billService.save(bill);
        Order order = (Order) request.getSession().getAttribute("order");
        order.setDateTime(LocalDateTime.now());
        order.setOrderStatus(ORDER_STATUS.FINISHED);
        orderService.save(order);
        HashMap<Long, HashSet<OrderShoppingCart>> map = (HashMap<Long, HashSet<OrderShoppingCart>>) request.getSession().getAttribute("map");

        map.forEach((key, value) -> value.forEach(element -> {
            BrandedDrugStockKey brandedDrugStockKey = new BrandedDrugStockKey(element.getOrderShoppingCartKey().getBrandedDrugKey(), key);
            Optional<BrandedDrugStock> brandedDrugStock = brandedDrugStockService.findByKey(brandedDrugStockKey);
            brandedDrugStock.ifPresent(drugStock -> brandedDrugStockService.edit(drugStock, element));


            if (brandedDrugService.findAllByPrescriptionRequiredBrandedDrugs().contains(element.getBrandedDrug())) {

                Optional<Prescription> optionalPrescription = prescriptionService
                        .findAllByPatientAndGenericDrugAndMarkedAsUsed((Patient) request.getSession().getAttribute("patient"),
                                element.getBrandedDrug().getGenericDrug(), false).stream().findFirst();
                if (optionalPrescription.isPresent()) {
                    optionalPrescription.get().setMarkedAsUsed(true);
                    prescriptionService.save(optionalPrescription.get());
                } else {
                    throw new RuntimeException();
                }
            }
        }));
        request.getSession().setAttribute("total", 0);
        request.getSession().setAttribute("order", null);
        request.getSession().setAttribute("bill", null);

        return "redirect:/all-products";
    }

    @Transactional
    public void initializeOrder(HttpServletRequest request) {
        if (request.getSession().getAttribute("order") == null && request.getSession().getAttribute("bill") == null) {
            Patient user = (Patient) request.getSession().getAttribute("patient");
            Bill bill = new Bill(LocalDateTime.now(), user, false);
            Order order = new Order(LocalDateTime.now(), user, bill, ORDER_STATUS.CREATED);
            billService.save(bill);
            orderService.save(order);
            request.getSession().setAttribute("bill", bill);
            request.getSession().setAttribute("order", order);
            request.getSession().setAttribute("map", new HashMap<Long, HashSet<OrderShoppingCart>>());
        }
    }


}
