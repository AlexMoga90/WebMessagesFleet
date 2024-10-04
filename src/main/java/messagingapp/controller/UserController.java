package messagingapp.controller;

import messagingapp.model.User;
import messagingapp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
public class UserController {

    @Autowired
    private UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/signup")
    public String showSignUpForm(Model model) {
        model.addAttribute("user", new messagingapp.dto.UserDTO());
        return "signup";
        }
    @PostMapping("/signup")
    public String registerUser(@ModelAttribute("user") @Valid messagingapp.dto.UserDTO userDTO, BindingResult result) {
        if (result.hasErrors()) {
            return "signup";
        }
        userService.registerUser(userDTO);
        return "redirect:/login";
    }
}
