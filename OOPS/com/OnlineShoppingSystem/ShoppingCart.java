package com.OnlineShoppingSystem;

import java.util.ArrayList;

public class ShoppingCart {

    private ArrayList<Product> products;

    public ShoppingCart(){
        this.products = new ArrayList<>();
    }

    public void addProduct(Product product){
        products.add(product);
    }

    public void removeProduct(String productId, String productName) {
        for (int i = 0; i < products.size(); i++) {
            Product product = products.get(i);
            if (product.getProductId().equals(productId) && product.getProductName().equals(productName)) {
                products.remove(product);
                System.out.println(productName + " with ID " + productId + " removed from the cart.");
                return;
            }
        }
        System.out.println("Product with ID (" + productId + ") and name " + productName + " is not found in the cart.");
    }

    public int getNumberOfProducts() {
        return products.size();
    }

    public Double totalCost(){
        Double totalCost = 0.0;
        for (int i = 0; i < products.size(); i++) {
            Product product = products.get(i);
            totalCost = totalCost + product.getPrice();
        }
        return totalCost;
    }

    public void showCart() {
        System.out.println("Shopping Cart:");
        for (int i = 0; i < products.size(); i++) {
            Product product = products.get(i);
            System.out.println(product.getProductName() + " - $" + product.getPrice());
        }
        System.out.println("Total Cost: $" + totalCost());
        System.out.println("Number of Products in the Cart: " + getNumberOfProducts());
    }
}
