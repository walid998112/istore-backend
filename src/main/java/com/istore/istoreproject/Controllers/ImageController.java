package com.istore.istoreproject.Controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import com.istore.istoreproject.Services.ImageService;
import com.istore.istoreproject.models.Image;

import java.util.List;

@RestController
@RequestMapping("/api/images")
@RequiredArgsConstructor
public class ImageController {

    private final ImageService imageService;

    @PostMapping("/add/{productId}")
    public ResponseEntity<?> addImages(@RequestParam("images") List<MultipartFile> images,
                                       @PathVariable("productId") long productId) {
        try {
            imageService.addImages(images, productId);
            return ResponseEntity.ok(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Failed to add images: " + e.getMessage());
        }
    }

    @PostMapping("/addSingle")
    public ResponseEntity<?> addImage(@RequestParam("image") MultipartFile image,
                                      @RequestParam("productId") long productId) {
        try {
            imageService.addImage(image, productId);
            return ResponseEntity.ok("Image added successfully");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Failed to add image: " + e.getMessage());
        }
    }

    @GetMapping("/{productId}")
    public ResponseEntity<?> getImagesByProductId(@PathVariable long productId) {
        try {
            List<Image> images = imageService.getByProductId(productId);
            return ResponseEntity.ok(images);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Failed to get images by product ID: " + e.getMessage());
        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteImage(@PathVariable long id) {
        try {
            imageService.deleteImage(id);
            return ResponseEntity.ok("Image deleted successfully");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Failed to delete image: " + e.getMessage());
        }
    }
}

