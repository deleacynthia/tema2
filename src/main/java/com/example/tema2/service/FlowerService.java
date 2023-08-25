package com.example.tema2.service;

import com.example.tema2.model.Flower;
import com.example.tema2.model.Order;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class FlowerService {
    private final OrderService orderService;
    private final List<Flower> flowerList = new ArrayList<>();

    public List<Flower> getFlowerList() {
        return flowerList.stream().filter(flower -> !flower.isDeleted()).collect(Collectors.toList());
    }
    public void saveFlower(Flower flower){
        flower.setId((long) flowerList.size());
        flower.setDeleted(false);
        flowerList.add(flower);
    }

    public void updateFlower(Flower flower){
        Flower selectedFlower = null;
        for(Flower flower1 : flowerList){
            if(flower1.getId().equals(flower.getId())){
                selectedFlower = flower1;
                break;
            }
        }

        if(selectedFlower == null){
            return;
        }

        if(flower.getStock() != null){
            selectedFlower.setStock(flower.getStock());
        }

        if(flower.getPrice()!= null){
            selectedFlower.setPrice(flower.getPrice());
        }

    }

    public void buyFlower(Long flowerToBuyId, Long quantity){
        Flower selectedFlower = null;
        for(Flower flower1 : flowerList){
            if(flower1.getId().equals(flowerToBuyId)){
                selectedFlower = flower1;
                break;
            }
        }

        if(selectedFlower == null){
            return;
        }

        if(selectedFlower.getStock() < quantity){
            return;
        }

        selectedFlower.setStock(selectedFlower.getStock() - quantity);
        orderService.saveOrder(new Order((long) orderService.getOrderList().size(), flowerToBuyId, quantity, quantity * selectedFlower.getPrice()));
    }

    public void deleteFlower(Long id) {
        Flower selectedFlower = null;
        for(Flower flower1 : flowerList){
            if(flower1.getId().equals(id)){
                selectedFlower = flower1;
                break;
            }
        }

        if(selectedFlower == null){
            return;
        }

        selectedFlower.setDeleted(true);
    }
}