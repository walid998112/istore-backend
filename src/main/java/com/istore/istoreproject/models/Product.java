package com.istore.istoreproject.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.List;
import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long product_id;

    @Column(name = "product_name")
    private String name;

    private BigDecimal price;

    private String color;

    private int quantity;

    private String reference;

    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;

    @Column(name = "product_description" , columnDefinition = "LONGTEXT")
    private String description;

    @ManyToOne
    @JoinColumn(name = "cpu_id")
    private CPU cpu;

    private int ram;

    private String batteryCapacity;

    private String operatingSystem;

    private String buyLink;

    @ManyToOne
    @JoinColumn(name = "screen_id")
    private Screen screen;

    @ManyToOne
    @JoinColumn(name = "camera_id")
    private Camera camera;

    @ManyToMany
    private List<Connectivity> connectivityOptions;

    @ManyToOne
    @JoinColumn(name = "question_id")
    private Question question;

    @OneToMany(mappedBy = "product" , fetch = FetchType.EAGER)
    private List<Image> images;
}
