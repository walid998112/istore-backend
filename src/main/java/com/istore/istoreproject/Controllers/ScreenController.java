package com.istore.istoreproject.Controllers;

import com.istore.istoreproject.Services.ScreenService;
import com.istore.istoreproject.models.Screen;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/screens")
@RequiredArgsConstructor
public class ScreenController {

    private final ScreenService screenService;

    @PostMapping("/add")
    public ResponseEntity<?> addScreen(@RequestBody Screen screen) {
        try {
            Screen addedScreen = screenService.saveScreen(screen);
            return ResponseEntity.ok(addedScreen);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Failed to add screen: " + e.getMessage());
        }
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<?> updateScreen(@PathVariable long id, @RequestBody Screen screen) {
        try {
            Screen updatedScreen = screenService.updatScreen(id, screen);
            return ResponseEntity.ok(updatedScreen);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Failed to update screen: " + e.getMessage());
        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteScreen(@PathVariable long id) {
        try {
            screenService.deleteScreenById(id);
            return ResponseEntity.ok("Screen deleted successfully");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Failed to delete screen: " + e.getMessage());
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getScreenById(@PathVariable long id) {
        try {
            Screen screen = screenService.findById(id);
            return ResponseEntity.ok(screen);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Failed to get screen: " + e.getMessage());
        }
    }
}

