package mk.finki.ukim.epharmacy.web;

import jakarta.servlet.http.HttpServletRequest;
import mk.finki.ukim.epharmacy.model.tables.Patient;
import mk.finki.ukim.epharmacy.service.interfaces.tables.PatientService;
import mk.finki.ukim.epharmacy.service.interfaces.tables.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/register")
public class RegisterController {
    private final UserService userService;
    private final PatientService patientService;

    public RegisterController(UserService userService, PatientService patientService) {
        this.userService = userService;
        this.patientService = patientService;
    }

    @GetMapping
    public String getPage()
    {
        return "register";
    }
    @PostMapping
    public String register(@RequestParam String username,
                           @RequestParam String firstName,
                           @RequestParam String lastName,
                           @RequestParam String email,
                           @RequestParam String password,
                           @RequestParam String streetName,
                           @RequestParam Integer flatNumber,
                           HttpServletRequest request)
    {
        Patient patient = new Patient(username, firstName, lastName, email, password, streetName, flatNumber);
        patientService.save(patient);
        request.getSession().setAttribute("patient", patient);
        return "redirect:/login";
    }
}
