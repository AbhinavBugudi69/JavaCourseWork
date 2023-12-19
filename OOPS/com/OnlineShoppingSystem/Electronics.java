package com.OnlineShoppingSystem;

public class Electronics extends Product {
    private String brand;
    private int warrantyPeriod;
    private int wattage;

    public Electronics(String productId, String productName, String productDescription, int numberOfItemsAvailable, Double price, String brand, int warrantyPeriod, int wattage){
        super(productId, productName, productDescription, numberOfItemsAvailable, price);
        this.brand = brand;
        this.warrantyPeriod = warrantyPeriod;
        this.wattage = wattage;
    }

    public String getProductType(){
        return "Electronics";
    }

    public String getBrand(){
        return this.brand;
    }

    public void setBrand(String brand){
        this.brand = brand;
    }

    public int getWarrantyPeriod(){
        return this.warrantyPeriod;
    }

    public void setWarrantyPeriod(int warrantyPeriod){
        this.warrantyPeriod = warrantyPeriod;
    }
    
    public int getWattage(){
        return this.wattage;
    }

    public void setWattage(int wattage){
        this.wattage = wattage;
    }
}
