package com.OnlineShoppingSystem;

import java.io.IOException;

public interface ShoppingManager {
    void addProduct();
    void removeProduct();
    void showProductsList();
    void saveToFile(String fileName) throws IOException; 

}
