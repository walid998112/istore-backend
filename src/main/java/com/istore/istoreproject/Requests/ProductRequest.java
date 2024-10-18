package com.istore.istoreproject.Requests;

import java.math.BigDecimal;
import java.util.List;

import com.istore.istoreproject.models.CPU;
import com.istore.istoreproject.models.Camera;
import com.istore.istoreproject.models.Screen;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductRequest {
    private String name;
    private BigDecimal price;
    private String color;
    private int quantity;
    private String reference;
    private String description;
    private int ram;
    private String batteryCapacity;
    private String operatingSystem;
    private String buyLink;
    private long categoryId;
    private long questionId;
    private List<Long> connectivityIds;
    private CPU cpu;
    private Screen screen ;
    private Camera camera;
    
}
