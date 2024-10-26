package service;

import model.Laptop;
import repository.LaptopRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class LaptopService {

    @Autowired
    private LaptopRepository laptopRepository;

    public List<Laptop> getAllLaptops() {
        return laptopRepository.findAll();
    }

    public Laptop recommendBestLaptop() {
        return laptopRepository.findAll().stream()
                .max(Comparator.comparingDouble(Laptop::getRating))
                .orElse(null);
    }

    public List<Laptop> recommendByPreferences(Optional<String> brand, Optional<String> processor, Optional<Integer> ram) {
        return laptopRepository.findAll().stream()
                .filter(laptop -> brand.map(b -> laptop.getBrand().equalsIgnoreCase(b)).orElse(true))
                .filter(laptop -> processor.map(p -> laptop.getProcessor().equalsIgnoreCase(p)).orElse(true))
                .filter(laptop -> ram.map(r -> laptop.getRam() >= r).orElse(true))
                .sorted(Comparator.comparingDouble(Laptop::getRating).reversed())
                .collect(Collectors.toList());
    }
}

