package edu.dosw.parcial.controller;

import edu.dosw.parcial.controller.dtos.request.UserRegisterDTO;
import edu.dosw.parcial.persistence.entities.User;
import edu.dosw.parcial.core.services.AuthService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
public class AuthController {

    private final AuthService authService;

    @PostMapping("/register")
    public ResponseEntity<User> register(@Valid @RequestBody UserRegisterDTO request) {
        User registeredUser = authService.registerUser(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(registeredUser);
    }
}
