package com.example.tema2.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Flower {
    private Long id;
    private String name;
    private Long stock;
    private Double price;
    private boolean isDeleted = false;

}