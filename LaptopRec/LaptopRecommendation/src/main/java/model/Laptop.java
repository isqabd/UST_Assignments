package model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "laptops")
public class Laptop {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String brand;
    private String model;
    private double price;
    private String processor;
    private int ram;
    private int storage;
    private double rating;
}
