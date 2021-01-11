package com.abirhossain.nsu.fall2020.cse299.sec03.group03.ShopOnline.ModelClasses;

public class cartList {
    private String pid,pName,discount,price,quantity;

    public cartList() {
    }

    public cartList(String pid, String pName, String discount, String price, String quantity) {
        this.pid = pid;
        this.pName = pName;
        this.discount = discount;
        this.price = price;
        this.quantity = quantity;
    }

    public String getPid() {
        return pid;
    }

    public void setPid(String pid) {
        this.pid = pid;
    }

    public String getpName() {
        return pName;
    }

    public void setpName(String pName) {
        this.pName = pName;
    }

    public String getDiscount() {
        return discount;
    }

    public void setDiscount(String discount) {
        this.discount = discount;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getQuantity() {
        return quantity;
    }

    public void setQuantity(String quantity) {
        this.quantity = quantity;
    }
}
