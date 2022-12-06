package mk.finki.ukim.epharmacy.web;

import mk.finki.ukim.epharmacy.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/register")
public class RegisterController {
    private final UserService userService;

    public RegisterController(UserService userService) {
        this.userService = userService;
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
                           @RequestParam Integer  flatNumber)
    {
        userService.save(username, firstName, lastName, email, password, streetName, flatNumber);
        return "redirect:/login";
    }
}
