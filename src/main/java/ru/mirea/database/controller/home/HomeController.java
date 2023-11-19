package ru.mirea.database.controller.home;

import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController("")
public class HomeController {

    @GetMapping("/public/hello")
    public String publicHello() {
        return "Hello from public endpoint!";
    }

    @Secured("ROLE_USER")
    @GetMapping("/secure/hello")
    public String secureHello() {
        return "Hello from secure endpoint!";
    }

}
