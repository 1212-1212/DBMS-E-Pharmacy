package mk.finki.ukim.epharmacy.web;

import jakarta.persistence.Column;
import mk.finki.ukim.epharmacy.service.BrandedDrugsViewService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Optional;

@Controller
@RequestMapping("/products")
public class BrandedDrugsViewController {

    private BrandedDrugsViewService brandedDrugsViewService;

    public BrandedDrugsViewController(BrandedDrugsViewService brandedDrugsViewService) {
        this.brandedDrugsViewService = brandedDrugsViewService;
    }

    @GetMapping
    public String getPage(@RequestParam(required = false) String text, Model model)
    {

       text = text == null || text.isEmpty() || text.isBlank() ? "" : text;
       model.addAttribute("brandedDrugs", text.isEmpty() ? brandedDrugsViewService.findAll()
               : brandedDrugsViewService.findBrandedDrugsViewByBrandedDrugNameContainingIgnoreCaseOrGenericContainingIgnoreCase(text, text));
        return "/products";

    }

}
