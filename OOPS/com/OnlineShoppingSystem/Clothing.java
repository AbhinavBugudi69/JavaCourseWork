package com.OnlineShoppingSystem;

public class Clothing extends Product{

    private String size;
    private String colour;

    public Clothing(String productId, String productName, String productDescription, int numberOfItemsAvailable, Double price, String size, String colour){
        super(productId, productName, productDescription, numberOfItemsAvailable, price);
        this.size = size;
        this.colour = colour;
    }

    public String getProductType(){
        return "Clothing";
    }

    public String getSize(){
        return this.size;
    }

    public void setSize(String size){
        this.size = size;
    }

    public String getColour(){
        return this.colour;
    }

    public void setColour(String colour){
        this.colour = colour;
    }

}
