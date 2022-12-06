package mk.finki.ukim.epharmacy.web;

import mk.finki.ukim.epharmacy.model.tables.User;
import mk.finki.ukim.epharmacy.service.UserService;
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

    public LoginController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public String getPage() {
        return "login";
    }

    @PostMapping
    public String login(@RequestParam String username, @RequestParam String password, Model model) {
        Optional<User> optional = userService.findByUsername(username);
        if (optional.isPresent() && optional.get().getPassword().equals(password)) {

            model.addAttribute("user", optional.get());
            return "redirect:/brandedDrugs";
        } else
            return "redirect:/register";
    }
}
