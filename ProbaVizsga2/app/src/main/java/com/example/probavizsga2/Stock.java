package com.example.probavizsga2;

public class Stock {
    private String name;
    private String ticker;
    private Float price;
    private Float grow;

    public Stock(String name, String ticker, Float price, Float grow) {
        this.name = name;
        this.ticker = ticker;
        this.price = price;
        this.grow = grow;
    }

    public Stock() {

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTicker() {
        return ticker;
    }

    public void setTicker(String ticker) {
        this.ticker = ticker;
    }

    public Float getPrice() {
        return price;
    }

    public void setPrice(Float price) {
        this.price = price;
    }

    public Float getGrow() {
        return grow;
    }

    public void setGrow(Float grow) {
        this.grow = grow;
    }
}
