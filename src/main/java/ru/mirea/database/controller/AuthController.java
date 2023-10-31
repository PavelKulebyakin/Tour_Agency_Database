package ru.mirea.database.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.mirea.database.data.dto.RegisterDTO;
import ru.mirea.database.data.dto.LoginDTO;
import ru.mirea.database.service.AuthenticationService;
import ru.mirea.database.service.UserService;

@RestController
@RequestMapping("api/auth")
public class AuthController {

    private final AuthenticationService authenticationService;

    @Autowired
    public AuthController(AuthenticationService authenticationService) {
        this.authenticationService = authenticationService;
    }

    @GetMapping("login")
    public String loginPage(){
        return "This is login page";
    }

    @PostMapping("login")
    public ResponseEntity<String> login(@RequestBody LoginDTO loginDTO){
        authenticationService.loginUser(loginDTO);
        return new ResponseEntity<>("User signed successfully.", HttpStatus.OK);
    }

    @PostMapping("register")
    public ResponseEntity<String> register(@RequestBody RegisterDTO registerDTO) {
        if(authenticationService.existByUsername(registerDTO.getUsername())) {
            return new ResponseEntity<>("Username is taken", HttpStatus.BAD_REQUEST);
        }
        authenticationService.registerUser(registerDTO);
        return new ResponseEntity<>("User " + registerDTO.getUsername() + "is registered.", HttpStatus.OK);
    }

}
