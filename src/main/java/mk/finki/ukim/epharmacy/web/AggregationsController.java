package mk.finki.ukim.epharmacy.web;

import mk.finki.ukim.epharmacy.service.interfaces.views.aggregations.AvailabilityInPharmacyByGenericViewService;
import mk.finki.ukim.epharmacy.service.interfaces.views.aggregations.MonthlyProfitViewService;
import mk.finki.ukim.epharmacy.service.interfaces.views.aggregations.MostSoldProductMonthlyViewService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/aggregations")
public class AggregationsController {

    private final AvailabilityInPharmacyByGenericViewService availabilityInPharmacyByGenericViewService;
    private final MonthlyProfitViewService monthlyProfitViewService;

    private final MostSoldProductMonthlyViewService mostSoldProductMonthlyViewService;

    public AggregationsController(AvailabilityInPharmacyByGenericViewService availabilityInPharmacyByGenericViewService, MonthlyProfitViewService monthlyProfitViewService, MostSoldProductMonthlyViewService mostSoldProductMonthlyViewService) {
        this.availabilityInPharmacyByGenericViewService = availabilityInPharmacyByGenericViewService;
        this.monthlyProfitViewService = monthlyProfitViewService;
        this.mostSoldProductMonthlyViewService = mostSoldProductMonthlyViewService;
    }


    @GetMapping("/availability-in-pharmacy-by-generic")
    public String getAvailabilityPage(Model model)
    {
        model.addAttribute("generics", availabilityInPharmacyByGenericViewService.findAll());
        return "availability-in-pharmacy-by-generic";
    }

    @GetMapping("/monthly-profit")
    public String getMonthlyProfitPage(Model model)
    {
        model.addAttribute("entries", monthlyProfitViewService.findAll());
        return "monthly-profit";
    }

    @GetMapping("/most-sold-product-monthly")
    public String getMostSoldProductMonthlyPage(Model model)
    {
        model.addAttribute("entries", mostSoldProductMonthlyViewService.findAll());
        return "most-sold-product-monthly";
    }
}
