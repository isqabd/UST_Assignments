package controller;

import model.Laptop;
import service.LaptopService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/laptops")
public class LaptopController {

    @Autowired
    private LaptopService laptopService;

    @GetMapping("/all")
    public List<Laptop> getAllLaptops() {
        return laptopService.getAllLaptops();
    }

    @GetMapping("/best")
    public Laptop getBestLaptop() {
        return laptopService.recommendBestLaptop();
    }

    @GetMapping("/recommend")
    public List<Laptop> recommendByPreferences(
            @RequestParam Optional<String> brand,
            @RequestParam Optional<String> processor,
            @RequestParam Optional<Integer> ram) {
        return laptopService.recommendByPreferences(brand, processor, ram);
    }
}
