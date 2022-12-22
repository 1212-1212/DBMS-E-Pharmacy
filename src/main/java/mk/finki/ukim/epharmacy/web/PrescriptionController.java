package mk.finki.ukim.epharmacy.web;

import mk.finki.ukim.epharmacy.service.interfaces.tables.GenericDrugService;
import mk.finki.ukim.epharmacy.service.interfaces.views.PrescriptionViewService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/prescriptions")
public class PrescriptionController {

    private final PrescriptionViewService prescriptionViewService;
    private final GenericDrugService genericDrugService;

    public PrescriptionController(PrescriptionViewService prescriptionViewService, GenericDrugService genericDrugService) {
        this.prescriptionViewService = prescriptionViewService;
        this.genericDrugService = genericDrugService;
    }

    @GetMapping
    public String getPage(@RequestParam(required = false) String nameOrSurname,
                          @RequestParam(required = false) String genericName,
                          @RequestParam(required = false)  Boolean markedAsUsed,
                          Model model) {

        model.addAttribute("generics", genericDrugService.findAll());
        System.out.println(markedAsUsed);
        nameOrSurname = nameOrSurname == null || nameOrSurname.isEmpty() || nameOrSurname.isBlank() ? "" : nameOrSurname;
        genericName = genericName == null || genericName.equals("All") ? "" : genericName;
        model.addAttribute("prescriptions", nameOrSurname.isEmpty() && genericName.isEmpty()  && markedAsUsed == null?
                prescriptionViewService.findAll() : prescriptionViewService.findPrescriptionViewsByPatientTextOrGenericNameOrMarkAsUsed(nameOrSurname, genericName, markedAsUsed));
        return "prescriptions";
    }
}
