package com.example.tema2.controller;

import com.example.tema2.model.Flower;
import com.example.tema2.service.FlowerService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("api/v1/flowers")
public class FlowerController {
    private final FlowerService flowerService;

    @GetMapping
    public List<Flower> getAllFlowers() {
        return flowerService.getFlowerList();
    }

    @PostMapping
    public void createFlower(@RequestBody Flower flower) {
        flowerService.saveFlower(flower);
    }

    @PutMapping
    public void updateFlower(@RequestBody Flower flower) {
        flowerService.updateFlower(flower);
    }

    @DeleteMapping("{id}")
    public void deleteFlower(@PathVariable Long id) {
        flowerService.deleteFlower(id);
    }

    @PostMapping("buy")
    public void buyFlower(@RequestParam("flowerId") Long flowerId, @RequestParam("quantity") Long quantity) {
        flowerService.buyFlower(flowerId, quantity);
    }
}