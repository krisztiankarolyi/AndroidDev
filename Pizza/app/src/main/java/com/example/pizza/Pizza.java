package com.example.pizza;

import androidx.annotation.NonNull;

import com.example.pizza.Topping;
import java.util.ArrayList;
import java.util.List;

public class Pizza {
    private String name;
    private double basePrice;
    private boolean selected;
    private List<Topping> toppings;

    public Pizza(String name, double basePrice, boolean selected) {
        this.name = name;
        this.basePrice = basePrice;
        this.selected = selected;
        this.toppings = new ArrayList<>();
    }


    @NonNull
    @Override
    public String toString() {
        return  getName()+" - "+getBasePrice();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getBasePrice() {
        return basePrice;
    }

    public void setBasePrice(double basePrice) {
        this.basePrice = basePrice;
    }

    public boolean isSelected() {
        return selected;
    }

    public void setSelected(boolean selected) {
        this.selected = selected;
    }

    public List<Topping> getToppings() {
        return toppings;
    }

    public void addTopping(Topping topping){
        this.toppings.add(topping);
    }

    public double getFullPrice(){
        double toppingPriceSum = 0;
        for(Topping topping : this.toppings){
            toppingPriceSum += topping.getPrice();
        }
        return toppingPriceSum + this.getBasePrice();
    }

    public  String orderSummary(){
        String summary =  this.getName()+"\n";
        for(Topping topping : this.getToppings()){
            summary += topping.getName() +"\n";
        }
        summary += "Price: "+this.getFullPrice();
        return  summary;
    }

    public void setToppings(List<Topping> toppings) {
        this.toppings = toppings;
    }
}
