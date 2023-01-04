package mk.finki.ukim.epharmacy.web;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.transaction.Transactional;
import mk.finki.ukim.epharmacy.model.enumerations.ORDER_STATUS;
import mk.finki.ukim.epharmacy.model.exceptions.NoValidPrescriptionFoundException;
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

        orderService.initializeOrder(request);

        if (request.getSession().getAttribute("map") != null) {
            Map<Long, HashSet<OrderShoppingCart>> map = (Map<Long, HashSet<OrderShoppingCart>>) request.getSession().getAttribute("map");
            Set<OrderShoppingCart> products = orderShoppingCartService.flatMapToSet(map.values().stream());
            Map<Long, String> genericsMap = genericDrugService.toMap();
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



        orderService.initializeOrder(request);
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
    public String checkout(HttpServletRequest request, Model model) {


        orderService.checkoutOrder(request);

        HashMap<Long, HashSet<OrderShoppingCart>> map = (HashMap<Long, HashSet<OrderShoppingCart>>) request.getSession().getAttribute("map");

        map.forEach((key, value) -> value.forEach(element -> {
            Optional<BrandedDrugStock> brandedDrugStock = brandedDrugStockService.findByKey(
                    new BrandedDrugStockKey(element.getOrderShoppingCartKey().getBrandedDrugKey(), key));
            brandedDrugStock.ifPresent(drugStock -> brandedDrugStockService.edit(drugStock, element));


            if (brandedDrugService.findAllByPrescriptionRequiredBrandedDrugs().contains(element.getBrandedDrug())) {

                Optional<Prescription> optionalPrescription = prescriptionService
                        .findAllByPatientAndGenericDrugAndMarkedAsUsed((Patient) request.getSession().getAttribute("patient"),
                                element.getBrandedDrug().getGenericDrug(), false).stream().findFirst();
                if (optionalPrescription.isPresent()) {
                    optionalPrescription.get().setMarkedAsUsed(true);
                    prescriptionService.save(optionalPrescription.get());
                } else {
                    model.addAttribute("hasError", true);
                    model.addAttribute("error", new NoValidPrescriptionFoundException().getMessage());

                }
            }
        }));
        request.getSession().setAttribute("total", 0);
        request.getSession().setAttribute("order", null);
        request.getSession().setAttribute("bill", null);
        if(model.containsAttribute("hasError"))
        {
            return String.format("redirect:/all-products?error=%s", new NoValidPrescriptionFoundException().getMessage());
        }
        return "redirect:/all-products";
    }




}
