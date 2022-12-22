package mk.finki.ukim.epharmacy.web;

import mk.finki.ukim.epharmacy.service.interfaces.tables.BrandedDrugService;
import mk.finki.ukim.epharmacy.service.interfaces.views.BrandedDrugsAvailabilityViewService;
import mk.finki.ukim.epharmacy.service.interfaces.views.BrandedDrugsViewService;
import mk.finki.ukim.epharmacy.service.interfaces.tables.GenericDrugService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/all-products")
public class BrandedDrugsController {

    private final BrandedDrugsViewService brandedDrugsViewService;
    private final BrandedDrugService brandedDrugService;


    private final GenericDrugService genericDrugService;

    private final BrandedDrugsAvailabilityViewService brandedDrugsAvailabilityViewService;

    public BrandedDrugsController(BrandedDrugsViewService brandedDrugsViewService,
                                  BrandedDrugService brandedDrugService,
                                  GenericDrugService genericDrugService,
                                  BrandedDrugsAvailabilityViewService brandedDrugsAvailabilityViewService) {
        this.brandedDrugsViewService = brandedDrugsViewService;
        this.brandedDrugService = brandedDrugService;
        this.genericDrugService = genericDrugService;
        this.brandedDrugsAvailabilityViewService = brandedDrugsAvailabilityViewService;
    }

    @GetMapping
    public String getPage(@RequestParam(required = false) String text, Model model) {

        text = text == null || text.isEmpty() || text.isBlank() ? "" : text;
        model.addAttribute("brandedDrugs", text.isEmpty() ? brandedDrugsViewService.findAll()
                : brandedDrugsViewService.findBrandedDrugsViewByBrandedDrugNameContainingIgnoreCaseOrGenericContainingIgnoreCase(text, text));
        return "all-products";

    }

    @PostMapping("/add-product")
    public String addBrandedDrug(@RequestParam String manufacturerName,
                                 @RequestParam String brandedDrugName,
                                 @RequestParam String genericDrugName) {
        brandedDrugService.save(manufacturerName, brandedDrugName, genericDrugName);
        return "redirect:/all-products";
    }

    @GetMapping("/add-product")
    public String getAddProductPage(Model model) {
        model.addAttribute("generics", genericDrugService.findAll());
        return "add-product";
    }

    @GetMapping("/availability")
    public String getAvailabilityInPharmaciesPage(@RequestParam(required = false) Float priceLow,
                                                  @RequestParam(required = false) Float priceHigh,
                                                  @RequestParam(required = false) Integer quantity,
                                                  @RequestParam(required = false) String searchText,
                                                  @RequestParam(required = false) String genericName, Model model) {

        model.addAttribute("generics", genericDrugService.findAll());
        model.addAttribute("availableBrandedDrugs", brandedDrugsAvailabilityViewService.findAll());
        priceLow = priceLow == null || priceLow.isNaN() ? Float.MIN_VALUE : priceLow;
        priceHigh = priceHigh == null || priceHigh.isNaN() ? Float.MAX_VALUE : priceHigh;

        searchText = searchText == null || searchText.isBlank() ? "" : searchText;
        model.addAttribute("availableBrandedDrugs", brandedDrugsAvailabilityViewService
                .findByPriceRangeQuantityAndText(quantity, priceLow, priceHigh, searchText, genericName));
        return "available-products-by-pharmacy-name";

    }



}

