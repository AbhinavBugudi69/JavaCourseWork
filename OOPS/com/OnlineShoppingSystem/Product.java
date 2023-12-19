package com.OnlineShoppingSystem;

public abstract class Product {

    private String productId;
    private String productName;
    private String productDescription;
    private int numberOfItemsAvailable;
    private Double price;

    public Product(){
        this.productId = "";
        this.productName="";
        this.productDescription="";
        this.numberOfItemsAvailable = 0;
        this.price = 0.0;
    }

    public Product(String productId, String productName, String productDescription, int numberOfItemsAvailable, Double price){
        this.productId = productId;
        this.productName = productName;
        this.productDescription = productDescription;
        this.numberOfItemsAvailable = numberOfItemsAvailable;
        this.price = price;
    }

    // Inside the Product class
    public static Product createProduct(String productId, String productName, String productType, int numberOfItemsAvailable, double price) {
        switch (productType.toLowerCase()) {
            case "electronics":
                return new Electronics(productId, productName, "", numberOfItemsAvailable, price, "", 0, 0);
            case "clothing":
                return new Clothing(productId, productName, "", numberOfItemsAvailable, price, "", "");
            // Add more cases for other product types if needed
            default:
                throw new IllegalArgumentException("Invalid product type: " + productType);
        }
    }

    public abstract String getProductType();

    public void getProductInfo(){
        System.out.println("Product ID : "+this.productId);
        System.out.println("Product Name : "+this.productName);
        System.out.println("Product Description : "+this.productDescription);
        System.out.println("Number of Products in stock : "+this.numberOfItemsAvailable);
        System.out.println("Price : £"+this.price);
    }


    public String getProductId(){
        return this.productId;
    }

    public void setProductId(String productId){
        this.productId = productId;
    }

    public String getProductName(){
        return this.productName;
    }

    public void setProductName(String productName){
        this.productName = productName;
    }

    public String getProductDescription(){
        return this.productDescription;
    }

    public void setProductDescription(String productDescription){
        this.productDescription = productDescription;
    }

    public int getNumberOfItemsAvailable(){
        return this.numberOfItemsAvailable;
    }

    public void setNumberOfItemsAvailable(int numberOfItemsAvailable){
        this.numberOfItemsAvailable = numberOfItemsAvailable;
    }

    public Double getPrice(){
        return this.price;
    }

    public void setPrice(Double price){
        this.price = price;
    }

}
