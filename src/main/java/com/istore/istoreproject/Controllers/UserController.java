package com.istore.istoreproject.Controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.istore.istoreproject.Requests.JwtToken;
import com.istore.istoreproject.Requests.LoginRequest;
import com.istore.istoreproject.Requests.RegisterRequest;
import com.istore.istoreproject.Requests.ResetPasswordRequest;
import com.istore.istoreproject.Requests.SuccessMessageRequest;
import com.istore.istoreproject.Requests.VerifTokenRequest;
import com.istore.istoreproject.Services.UserService;
import com.istore.istoreproject.models._User;

import java.util.List;

@RestController
@RequestMapping("/api/v1/user")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/auth/register")
    public ResponseEntity<?> register(@RequestBody RegisterRequest registerRequest) {
        try {
            userService.register(registerRequest);
            return ResponseEntity.ok(new SuccessMessageRequest("User registered successfully!"));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }

    @PostMapping("/auth/login")
    public ResponseEntity<?> login(@RequestBody LoginRequest loginRequest) {
        try {
            JwtToken jwtToken = userService.login(loginRequest);
            return ResponseEntity.ok(jwtToken);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(e.getMessage());
        }
    }

    @GetMapping("/all")
    public ResponseEntity<List<_User>> getAllUsers() {
        List<_User> users = userService.getAll();
        return ResponseEntity.ok(users);
    }

    @GetMapping("/{id}")
    public ResponseEntity<_User> getUserById(@PathVariable long id) {
        try {
            _User user = userService.getById(id);
            return ResponseEntity.ok(user);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    @GetMapping("/username/{username}")
    public ResponseEntity<?> getUserByUsername(@PathVariable String username) {
        try {
            _User user = userService.getByUsername(username);
            return ResponseEntity.ok(user);
        } catch (Exception e) {
            return ResponseEntity.status(500).body(e.getMessage());
        }
    }

    @PutMapping("/{username}")
    public ResponseEntity<?> updateUser(@PathVariable String username, @RequestBody _User user) {
        try {
            userService.updateUser(username, user);
            return ResponseEntity.ok(new SuccessMessageRequest("User updated successfully!"));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }

    @PostMapping("/auth/send-token")
    public ResponseEntity<?> sendToken(@RequestParam String email) {
        try {
            userService.sendToken(email);
            return ResponseEntity.ok(new SuccessMessageRequest("Token sent successfully!"));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }

    @PostMapping("/auth/verify-token")
    public ResponseEntity<?> verifyToken(@RequestBody VerifTokenRequest verifTokenRequest) {
        try {
            userService.verifToken(verifTokenRequest);
            return ResponseEntity.ok(new SuccessMessageRequest("Token verified successfully!"));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(e.getMessage());
        }
    }

    @PostMapping("/auth/reset-password")
    public ResponseEntity<?> resetPassword(@RequestBody ResetPasswordRequest resetPasswordRequest) {
        try {
            userService.reset(resetPasswordRequest);
            return ResponseEntity.ok(new SuccessMessageRequest("Password reset successfully!"));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }

    @PostMapping("/enable-disable/{id}")
    public ResponseEntity<?> desableEnableUser(@PathVariable long id) {
        try {
            userService.disableEnableUser(id);
            return ResponseEntity.ok().build();
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

}
