package messagingapp.controller;

import messagingapp.model.User;
import messagingapp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.Optional;

@RestController
public class AuthController {
    @Autowired
    private UserService userService;

    public AuthController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/login")
    public String showLoginPage() {
        return "login";
    }

    @PostMapping("/login")
    public String login(@RequestParam String phoneNumber, @RequestParam String password, HttpSession session) {
        Optional<User> user = userService.authenticate(phoneNumber,password);
        if (user != null) {
            session.setAttribute("phoneNumber", phoneNumber);
            return "redirect:/messages";
        } else {
            return "redirect:/login?error";
        }
    }

   @GetMapping("/logout")
    public String logout(HttpSession session) {
        session.invalidate();
        return "redirect:/login";
    }
}
