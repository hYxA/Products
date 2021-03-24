package ru.netology.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@EqualsAndHashCode(callSuper = true)

public class Smartphone extends Product {

    private String model;
    private String manufacturer;

    public Smartphone(int id, String name, int price, String model, String manufacturer) {
        super(id, name, price);
        this.model = model;
        this.manufacturer = manufacturer;
    }


}
