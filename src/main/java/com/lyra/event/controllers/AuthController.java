package com.lyra.event.controllers;

import com.lyra.event.dto.usercredential.UserCredentialRequestDto;
import com.lyra.event.service.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/api/v1/auth")
public class AuthController {

    @Autowired
    private UserService service;


    @PostMapping("/register")
    public ResponseEntity<Void> registerUser(@Valid @RequestBody UserCredentialRequestDto dto) {
        service.registerUser(dto);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/verify")
    public ResponseEntity<String> verifyUser(@RequestParam("token") String token) {
        var response = service.verifyUser(token);
        return ResponseEntity.ok().body(response);
    }


}
