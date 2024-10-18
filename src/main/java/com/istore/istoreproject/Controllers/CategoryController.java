package com.istore.istoreproject.Controllers;

import com.istore.istoreproject.Services.CategoryService;
import com.istore.istoreproject.models.Category;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/categories")
public class CategoryController {

    private final CategoryService categoryService;

    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @PostMapping("/add")
    public ResponseEntity<String> addCategory(@RequestBody Category category) {
        try {
            categoryService.addCategory(category);
            return ResponseEntity.ok("Category added successfully");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Failed to add category: " + e.getMessage());
        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteCategory(@PathVariable("id") long id) {
        try {
            categoryService.deleteCategory(id);
            return ResponseEntity.ok("Category deleted successfully");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Failed to delete category: " + e.getMessage());
        }
    }

    @GetMapping("/parents")
    public ResponseEntity<?> getParents() {
        try {
            List<Category> parents = categoryService.getParents();
            return ResponseEntity.ok(parents);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Failed to fetch parent categories: " + e.getMessage());
        }
    }

    @GetMapping("/byParent/{id}")
    public ResponseEntity<?> getByParentId(@PathVariable("id") long id) {
        try {
            List<Category> categories = categoryService.getByParentId(id);
            return ResponseEntity.ok(categories);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Failed to fetch categories by parent ID: " + e.getMessage());
        }
    }
}

