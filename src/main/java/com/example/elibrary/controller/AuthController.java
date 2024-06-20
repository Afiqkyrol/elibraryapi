package com.example.elibrary.controller;

import com.example.elibrary.entity.User;
import com.example.elibrary.model.AuthenticationResponse;
import com.example.elibrary.service.AuthService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = {"http://localhost:8081", "http://localhost:80", "https://mmdis.marine.gov.my"})
public class AuthController {

    private final AuthService authService;

    public AuthController(AuthService authService) {
        this.authService = authService;
    }

//    @CrossOrigin(origins = "http://localhost:3000")
    @PostMapping("/register")
    public ResponseEntity<AuthenticationResponse> register(@RequestBody User request){
        return ResponseEntity.ok(authService.register(request));
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @PostMapping("/login")
    public ResponseEntity<AuthenticationResponse> login(@RequestBody User request){
        return ResponseEntity.ok(authService.authenticate(request));
    }

    @GetMapping("/")
    public String showHome(){
        return "elibrary_api";
    }
}
