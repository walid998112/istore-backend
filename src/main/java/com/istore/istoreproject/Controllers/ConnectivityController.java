package com.istore.istoreproject.Controllers;

import com.istore.istoreproject.Services.ConnectivityService;
import com.istore.istoreproject.models.Connectivity;
import lombok.RequiredArgsConstructor;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.GetMapping;

@RestController
@RequestMapping("/api/connectivity")
@RequiredArgsConstructor
public class ConnectivityController {

    private final ConnectivityService connectivityService;

    @PostMapping("/add")
    public ResponseEntity<?> addConnectivity(@RequestBody Connectivity connectivity) {
        try {
            Connectivity savedConnectivity = connectivityService.add(connectivity);
            return ResponseEntity.ok(savedConnectivity);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Failed to add connectivity: " + e.getMessage());
        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteConnectivity(@PathVariable long id) {
        try {
            connectivityService.delete(id);
            return ResponseEntity.ok("Connectivity deleted successfully");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Failed to delete connectivity: " + e.getMessage());
        }
    }

    @GetMapping("/all")
    public List<Connectivity> getConnectivities() {
        return connectivityService.getAll();
    }

}
