package ru.mirea.database.controller.login;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import ru.mirea.database.data.dto.user.SinginDTO;
import ru.mirea.database.service.auth.AuthenticationService;

@Controller
public class LoginController {

    AuthenticationService authenticationService;

    @Autowired
    public LoginController(AuthenticationService authenticationService) {
        this.authenticationService = authenticationService;
    }

    @GetMapping("/singin")
    public String loginPage(Model model) {
        model.addAttribute("singinDTO", new SinginDTO());
        return "singin";
    }

    @PostMapping("/login")
    public String login(@ModelAttribute SinginDTO singinDTO){
        authenticationService.loginUser(singinDTO);
        return "redirect:/search";
    }

}
