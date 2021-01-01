package com.abirhossain.nsu.fall2020.cse299.sec03.group03.ShopOnline.ModelClasses;

public class Products {
    private String name,price,img,category,description,id,date,time;
    public Products(){

    }

    public Products(String name, String price, String img, String category, String description, String id, String date, String time) {
        this.name = name;
        this.price = price;
        this.img = img;
        this.category = category;
        this.description = description;
        this.id = id;
        this.date = date;
        this.time = time;
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

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }
}
