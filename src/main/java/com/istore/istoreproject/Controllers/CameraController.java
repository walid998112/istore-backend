package com.istore.istoreproject.Controllers;

import com.istore.istoreproject.Services.CameraService;
import com.istore.istoreproject.models.Camera;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/cameras")
public class CameraController {

    private final CameraService cameraService;

    public CameraController(CameraService cameraService) {
        this.cameraService = cameraService;
    }

    @PostMapping("/admin/add")
    public ResponseEntity<?> addCamera(@RequestBody Camera camera) {
        try {
            Camera savedCamera = cameraService.addCamera(camera);
            return ResponseEntity.ok(savedCamera);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Failed to add camera: " + e.getMessage());
        }
    }

    @GetMapping("/admin/{id}")
    public ResponseEntity<?> getCameraById(@PathVariable("id") long id) {
        try {
            Camera camera = cameraService.getById(id);
            return ResponseEntity.ok(camera);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Camera not found with ID: " + id);
        }
    }

    @PutMapping("/admin/{id}")
    public ResponseEntity<?> updateCamera(@RequestBody Camera camera, @PathVariable("id") long id) {
        try {
            Camera updatedCamera = cameraService.updateCamera(camera, id);
            return ResponseEntity.ok(updatedCamera);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Failed to update camera with ID: " + id + ", Error: " + e.getMessage());
        }
    }

    @DeleteMapping("/admin/{id}")
    public ResponseEntity<?> deleteCamera(@PathVariable("id") long id) {
        try {
            cameraService.deleteCamera(id);
            return ResponseEntity.noContent().build();
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Failed to delete camera with ID: " + id + ", Error: " + e.getMessage());
        }
    }
}
