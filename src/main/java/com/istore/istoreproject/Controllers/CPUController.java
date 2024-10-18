package com.istore.istoreproject.Controllers;

import com.istore.istoreproject.Services.CPUService;
import com.istore.istoreproject.models.CPU;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/cpu")
@RequiredArgsConstructor
public class CPUController {

    private final CPUService cpuService;

    @PostMapping("/save")
    public ResponseEntity<?> saveCPU(@RequestBody CPU cpu) {
        try {
            CPU savedCPU = cpuService.saveCPU(cpu);
            return ResponseEntity.ok(savedCPU);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Failed to save CPU: " + e.getMessage());
        }
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<?> updateCPU(@PathVariable Long id, @RequestBody CPU cpu) {
        try {
            CPU updatedCPU = cpuService.updateCpu(id, cpu);
            return ResponseEntity.ok(updatedCPU);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Failed to update CPU: " + e.getMessage());
        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteCPU(@PathVariable Long id) {
        try {
            cpuService.deleteCPUById(id);
            return ResponseEntity.ok("CPU deleted successfully");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Failed to delete CPU: " + e.getMessage());
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getCpuById(@PathVariable long id) {
        try {
            CPU cpu = cpuService.findById(id);
            return ResponseEntity.ok(cpu);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Failed to get CPU by ID: " + e.getMessage());
        }
    }
}

