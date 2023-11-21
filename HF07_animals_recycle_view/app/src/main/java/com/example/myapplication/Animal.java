package com.example.myapplication;

import java.util.ArrayList;
import java.util.List;

public class Animal {
    private int imgRes;
    private  String name;
    private  String details;

    public Animal(int imgRes, String name, String details,  String lifeSpan) {
        this.imgRes = imgRes;
        this.name = name;
        this.details = details + ". It usually lives apr. "+ lifeSpan;
    }
    public Animal() {

    }

    public int getImgRes() {
        return imgRes;
    }

    public void setImgRes(int imgRes) {
        this.imgRes = imgRes;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    public static List<Animal> getAnimals(){
        List<Animal> animals = new ArrayList<>();
        animals.add(new Animal(R.drawable.cat, "Cat", "Meows", "12 years"));
        animals.add(new Animal(R.drawable.dog, "Dog", "Barks", "10 years"));
        animals.add(new Animal(R.drawable.giraffe, "Giraffe", "Has a long neck", "20 years"));
        animals.add(new Animal(R.drawable.horse, "Horse", "Neighs", "25 years"));
        animals.add(new Animal(R.drawable.giraffe, "Giraffe", "Has a long neck", "20 years"));
        animals.add(new Animal(R.drawable.lion, "Lion", "Roars", "15 years"));
        animals.add(new Animal(R.drawable.octopus, "Octopus", "Has a lot of arms", "3 years"));
        animals.add(new Animal(R.drawable.pig, "Pig", "Eats everything", "15 years"));
        animals.add(new Animal(R.drawable.rabbit, "Rabbit", "Cute", "5 years"));
        animals.add(new Animal(R.drawable.sheep, "Sheep", "Cute", "12 years"));
        return animals;
    }
}
