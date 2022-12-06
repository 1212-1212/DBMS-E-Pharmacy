package mk.finki.ukim.epharmacy.web;

import mk.finki.ukim.epharmacy.service.GenericDrugService;
import mk.finki.ukim.epharmacy.service.PrescriptionViewService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/prescriptions")
public class PrescriptionViewController {

    private final PrescriptionViewService prescriptionViewService;
    private final GenericDrugService genericDrugService;

    public PrescriptionViewController(PrescriptionViewService prescriptionViewService, GenericDrugService genericDrugService) {
        this.prescriptionViewService = prescriptionViewService;
        this.genericDrugService = genericDrugService;
    }

    @GetMapping
    public String getPage(@RequestParam(required = false) String nameOrSurname,
                          @RequestParam(required = false) String genericName, Model model) {

        model.addAttribute("generics", genericDrugService.findAll());
        model.addAttribute("prescriptions", prescriptionViewService.findAll());

        nameOrSurname = nameOrSurname == null || nameOrSurname.isEmpty() || nameOrSurname.isBlank() ? "" : nameOrSurname;
        genericName = genericName == null || genericName.equals("All") ? "" : genericName;
        model.addAttribute("prescriptions", nameOrSurname.isEmpty() && genericName.isEmpty() ?
                prescriptionViewService.findAll() : prescriptionViewService.findPrescriptionViewsByPatientTextOrGenericName(nameOrSurname, genericName));
        return "prescriptions";
    }
}
