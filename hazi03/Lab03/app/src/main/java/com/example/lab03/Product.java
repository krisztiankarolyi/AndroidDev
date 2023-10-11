package com.example.lab03;

import androidx.annotation.NonNull;

public class Product {
    String name; String code; String price;
    public Product(String price, String name, String code) {
        this.price = price;
        this.name = name;
        this.code = code;
    }

    @NonNull
    @Override
    public String toString() {
        return "Product name: " + this.name + "\n Product code: " + this.code + "\n Product price: " + this.price;
    }

}
