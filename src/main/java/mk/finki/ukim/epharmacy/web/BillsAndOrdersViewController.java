package mk.finki.ukim.epharmacy.web;

import mk.finki.ukim.epharmacy.model.enumerations.ORDER_STATUS;
import mk.finki.ukim.epharmacy.service.interfaces.views.BillsAndOrdersViewService;
import mk.finki.ukim.epharmacy.service.interfaces.tables.GenericDrugService;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Controller
@RequestMapping("/bills-and-orders")
public class BillsAndOrdersViewController {

    private final BillsAndOrdersViewService billsAndOrdersViewService;
    private final GenericDrugService genericDrugService;

    public BillsAndOrdersViewController(BillsAndOrdersViewService billsAndOrdersViewService, GenericDrugService genericDrugService) {
        this.billsAndOrdersViewService = billsAndOrdersViewService;
        this.genericDrugService = genericDrugService;
    }


    @GetMapping
    public String getPage(@RequestParam(required = false) Long quantityLow,
            @RequestParam(required = false) Long quantityHigh,
            @RequestParam(required = false) Double priceLow,
            @RequestParam(required = false) Double priceHigh,
            @RequestParam(required = false)  @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime from,
            @RequestParam(required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime to,
            @RequestParam(required = false) List<String> genericName,
            @RequestParam(required = false) String brandedName,
            @RequestParam(required = false) String pharmacyName,
            @RequestParam(required = false) ORDER_STATUS orderStatus,
            @RequestParam(required = false) Boolean paymentStatus,
            Model model)
    {
        model.addAttribute("format", "dd-MM-yyyy HH:mm:ss");
        model.addAttribute("generics", genericDrugService.findAll());
        List<String> statuses = Arrays.stream(ORDER_STATUS.values()).map(Enum::toString).toList();
        model.addAttribute("statuses", statuses);
        model.addAttribute("allBillsAndOrders", billsAndOrdersViewService
                .findBillsAndOrdersByQuantityRangeOrPriceRangeOrTimestampRangeOrGenericDrugNameOrBrandedDrugNameOrPharmacyNameOrOrderStatusOrPaymentStatus
                        (quantityLow, quantityHigh, priceLow, priceHigh, from, to, genericName, brandedName, pharmacyName, orderStatus, paymentStatus));

        return "bills-and-orders";
    }

}
