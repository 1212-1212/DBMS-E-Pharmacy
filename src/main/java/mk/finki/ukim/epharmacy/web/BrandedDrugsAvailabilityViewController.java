package mk.finki.ukim.epharmacy.web;

import mk.finki.ukim.epharmacy.service.BrandedDrugService;
import mk.finki.ukim.epharmacy.service.BrandedDrugsAvailabilityViewService;
import mk.finki.ukim.epharmacy.service.GenericDrugService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.LocalDateTime;

@Controller
@RequestMapping("/brandedDrugs")
public class BrandedDrugsAvailabilityViewController {

    private final BrandedDrugsAvailabilityViewService brandedDrugsAvailabilityViewService;
    private final GenericDrugService genericDrugService;
    private final BrandedDrugService brandedDrugService;

    public BrandedDrugsAvailabilityViewController(BrandedDrugsAvailabilityViewService brandedDrugsAvailabilityViewService, GenericDrugService genericDrugService, BrandedDrugService brandedDrugService) {
        this.brandedDrugsAvailabilityViewService = brandedDrugsAvailabilityViewService;
        this.genericDrugService = genericDrugService;
        this.brandedDrugService = brandedDrugService;
    }

    @GetMapping
    public String getPage(@RequestParam(required = false) Float priceLow,
                          @RequestParam(required = false) Float priceHigh,
                          @RequestParam(required = false) Integer quantity,
                          @RequestParam(required = false) String searchText,
                          @RequestParam(required = false) String genericName, Model model)
    {

        model.addAttribute("generics", genericDrugService.findAll());
        model.addAttribute("availableBrandedDrugs", brandedDrugsAvailabilityViewService.findAll());
        priceLow = priceLow == null || priceLow.isNaN() ? Float.MIN_VALUE : priceLow;
        priceHigh = priceHigh == null || priceHigh.isNaN() ? Float.MAX_VALUE : priceHigh;
        quantity = quantity == null ? 0 : quantity;
        searchText = searchText == null || searchText.isBlank() ? "" : searchText;
        genericName = genericName == null || genericName.isBlank()? "All" : genericName;
        model.addAttribute("availableBrandedDrugs", brandedDrugsAvailabilityViewService.findByPriceRangeQuantityAndText(quantity, priceLow, priceHigh, searchText, genericName));
        return "brandedDrugs";

    }
    @PostMapping("/add-product")
    public String addBrandedDrug(@RequestParam String manufacturerName,
                                 @RequestParam String brandedDrugName,
                                 @RequestParam String genericDrugName)
    {
        LocalDateTime expirationDate = LocalDateTime.now().plusYears(1);
        brandedDrugService.save(manufacturerName, brandedDrugName, expirationDate, genericDrugName);
        return "redirect:/brandedDrugs";
    }
    @GetMapping("/add-product")
    public String getAddProductPage()
    {
        return "add-product";
    }
}

