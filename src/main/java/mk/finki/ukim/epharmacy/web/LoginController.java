package mk.finki.ukim.epharmacy.web;

import jakarta.servlet.http.HttpServletRequest;
import mk.finki.ukim.epharmacy.model.exceptions.InvalidLoginCredentialsException;
import mk.finki.ukim.epharmacy.model.tables.Patient;
import mk.finki.ukim.epharmacy.model.tables.User;
import mk.finki.ukim.epharmacy.service.interfaces.tables.PatientService;
import mk.finki.ukim.epharmacy.service.interfaces.tables.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Optional;

@Controller
@RequestMapping("/login")
public class LoginController {

    private final UserService userService;
    private final PatientService patientService;

    public LoginController(UserService userService, PatientService patientService) {
        this.userService = userService;
        this.patientService = patientService;
    }

    @GetMapping
    public String getPage(Model model, @RequestParam(required = false) String error)
    {
        if(error != null) {
            model.addAttribute("hasError", true);
            model.addAttribute("error", error);
        }
        return "login";
    }

    @PostMapping
    public String login(HttpServletRequest request, Model model) {

       String username = request.getParameter("username");
       String password = request.getParameter("password");
       try
        {
            User user  = userService.checkCredentials(username, password);
            Optional<Patient> patient = patientService.findById(user.getUserId());
            patient.ifPresent(value -> request.getSession().setAttribute("patient", value));
            return "redirect:/all-products";
        } catch (InvalidLoginCredentialsException e) {
            return "redirect:/login?error=" + e.getMessage();
        }
    }
}
