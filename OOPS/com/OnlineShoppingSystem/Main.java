package com.OnlineShoppingSystem;


public class Main {
    public static void main(String[] args) {
        WestminsterShoppingManager shoppingManager = new WestminsterShoppingManager();

        // Test your menu in a loop until the user chooses to exit (option 0)
        do {
            shoppingManager.showMenu();
        } while (true);
    }
}