package com.example.tema2.service;

import com.example.tema2.model.Order;
import lombok.Getter;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@Getter
public class OrderService {
    private final List<Order> orderList = new ArrayList<>();
    public void saveOrder(Order order) {
        orderList.add(order);
    }
}