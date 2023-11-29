package ru.mirea.database.controller.login;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.mirea.database.data.dto.user.RegisterDTO;
import ru.mirea.database.data.dto.user.SinginDTO;
import ru.mirea.database.service.auth.AuthenticationService;

@RestController
@RequestMapping("api/auth")
public class AuthController {

    protected final AuthenticationService authenticationService;

    @Autowired
    public AuthController(AuthenticationService authenticationService) {
        this.authenticationService = authenticationService;
    }

    @PostMapping("login")
    public ResponseEntity<String> login(@RequestBody SinginDTO singinDTO){
        authenticationService.loginUser(singinDTO);
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
