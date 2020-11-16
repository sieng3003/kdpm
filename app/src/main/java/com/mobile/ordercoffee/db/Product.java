package com.mobile.ordercoffee.db;

public class Product {

    public Product(int id, String name, String price, String type, int pathImg) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.type = type;
        this.pathImg = pathImg;
    }

    int id;
    String name;
    String price;
//    String amount;
    String type;
    int pathImg;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

//    public String getAmount() {
//        return amount;
//    }
//
//    public void setAmount(String amount) {
//        this.amount = amount;
//    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getPathImg() {
        return pathImg;
    }

    public void setPathImg(int pathImg) {
        this.pathImg = pathImg;
    }
}
