package com.OnlineShoppingSystem;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.InputMismatchException;
import java.util.Scanner;

public class WestminsterShoppingManager implements ShoppingManager{

    private ArrayList<Product> productsList;

    public WestminsterShoppingManager(){
        this.productsList = new ArrayList<>();
    }

    public void showMenu() {
        Scanner scanner = new Scanner(System.in);
        int option;

        do {
            System.out.println("~~~~~~~~ MANAGER MENU ~~~~~~~~");
            System.out.println("1. Add a product");
            System.out.println("2. Delete a product");
            System.out.println("3. Display the list of all the products");
            System.out.println("4. Save product details to a file");
            System.out.println("5. Load file information");
            System.out.println("0. Exit ");
            System.out.print("Enter your choice : ");

            try {
                option = scanner.nextInt();
                scanner.nextLine(); // Consume the newline left by nextInt()

                switch (option) {
                    case 1:

                        addProduct();
                        break;
                    case 2:
                        removeProduct();
                        break;
                    case 3: 
                        showProductsList();
                        break;
                    case 4:
                        System.out.print("What should the file be saved as : ");
                        String fileName = scanner.nextLine();
                        try {
                            saveToFile(fileName);
                        } catch (IOException e) {
                            System.out.println("Error saving to file: " + fileName);
                        }
                        break;
                    case 5:
                        System.out.print("Enter the filename to load: ");
                        String loadFileName = scanner.nextLine();
                        loadFromFile(loadFileName);
                        break;
                    case 0:
                        System.out.println("Exiting the program. Goodbye!");
                        System.exit(0);
                        break;
                    default:
                        System.out.println("Input is not valid. Please select from one of the options shown in the menu.");
                        break;
                }
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a valid number.");
                scanner.next(); // Consume the invalid input
                option = -1; // Set option to -1 to avoid an infinite loop
            }
        } while (option != 0);
    }


    public void addProduct(){
        // Check if maximum limit of 50 products is reached
        if (productsList.size() >= 50) {
            System.out.println("Cannot add more products. Maximum limit of 50 is reached, delete products to add more.");
            return;
        }

        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter the details of the product");
        String productType;

        do {
            System.out.print("Enter the product Type (Electronics OR Clothing only): ");
            productType = scanner.nextLine().toLowerCase();
        } while (!productType.equals("electronics") && !productType.equals("clothing"));

        System.out.print("Enter the product ID : ");
        String productId = scanner.nextLine();
        System.out.print("Enter the product name: ");
        String productName = scanner.nextLine();
        System.out.print("Enter the product Description: ");
        String productDescription = scanner.nextLine();

        int numberOfItemsAvailable;
        double price;

        // Validate and get the number of items in stock
        do {
            System.out.print("Enter the number of items in stock: ");
            try {
                numberOfItemsAvailable = Integer.parseInt(scanner.nextLine());
                break;
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a valid number for items in stock.");
            }
        } while (true);

        // Validate and get the price
        do {
            System.out.print("Enter the price in £: ");
            try {
                price = Double.parseDouble(scanner.nextLine());
                break;
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a valid price.");
            }
        } while (true);

        if (productType.equals("electronics")) {
            System.out.print("Enter the brand of product: ");
            String brand = scanner.nextLine();
            System.out.print("Enter the warranty period in months: ");
            int warrantyPeriod;
            while (true) {
                try {
                    warrantyPeriod = scanner.nextInt();
                    break;
                } catch (InputMismatchException e) {
                    System.out.println("Invalid input. Please enter a valid number for warranty period.");
                    scanner.next(); // Consume the invalid input
                }
            }

            System.out.print("Enter the wattage of the electronic item: ");
            int wattage;
            while (true) {
                try {
                    wattage = scanner.nextInt();
                    break;
                } catch (InputMismatchException e) {
                    System.out.println("Invalid input. Please enter a valid number for wattage.");
                    scanner.next(); // Consume the invalid input
                }
            }

            Product electronicsProduct = new Electronics(productId, productName, productDescription, numberOfItemsAvailable, price, brand, warrantyPeriod, wattage);
            productsList.add(electronicsProduct);

        } else if (productType.equals("clothing")) {
            String size;

            // Validate and get the size
            do {
                System.out.print("Enter the size (XS, S, M, L, XL, XXL, XXXL): ");
                size = scanner.nextLine().toUpperCase();
                if (size.equals("XS") || size.equals("S") || size.equals("M") || size.equals("L") || size.equals("XL") || size.equals("XXL") || size.equals("XXXL")) {
                    break;
                } else {
                    System.out.println("Invalid size. Please enter one of the specified sizes.");
                }
            } while (true);

            System.out.print("Enter the colour: ");
            String colour = scanner.nextLine();
            Product clothingProduct = new Clothing(productId, productName, productDescription, numberOfItemsAvailable, price, size, colour);
            productsList.add(clothingProduct);

        } else {
            System.out.println("Please choose a product type between Electronics or Clothing");
        }
    }

    public void removeProduct() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter the details of the product that needs to be removed");
        System.out.print("Enter Product ID: ");
        String productIdToRemove = scanner.nextLine();

        boolean productFound = false;

        for (int i = 0; i < productsList.size(); i++) {
            Product product = productsList.get(i);
            if (product.getProductId().equals(productIdToRemove)) {
                productsList.remove(i);
                System.out.println("Product with ID " + productIdToRemove + " removed from the Products list. There are " + productsList.size() + " Products.");
                productFound = true;
                break;  // Exit the loop once the product is found and removed
            }
        }
        if (!productFound) {
            System.out.println("Product with ID " + productIdToRemove + " is not found in the products list.");
        }
    }

    public void showProductsList(){
        System.out.println("Product List (Sorted by Product ID): ");
        Collections.sort(productsList, (p1, p2) -> p1.getProductId().compareTo(p2.getProductId()));
        
        for (Product product : productsList) {
            System.out.println("Product ID : " + product.getProductId());
            System.out.println("Product Type : " + product.getProductType());
            System.out.println("Product Name : " + product.getProductName());
            System.out.println("Product Description : " + product.getProductDescription());
            System.out.println("Price : " + product.getPrice());
        }
    }

    public void saveToFile(String fileName) throws IOException{
        File file = new File(fileName);

        if (file.exists()) {
            loadFromFile(fileName);
        }

        if (file.createNewFile()) {
            try (FileWriter writer = new FileWriter(file)) {
                for (int i = 0; i < productsList.size(); i++) {
                    Product product = productsList.get(i);
                    if (product instanceof Electronics) {
                        // Electronics format
                        String productInfo = product.getProductId() + ", " + product.getProductName() + ", "
                                + product.getProductDescription() + ", " + product.getNumberOfItemsAvailable() + ", "
                                + product.getPrice() + ", " + ((Electronics) product).getBrand() + ", "
                                + ((Electronics) product).getWarrantyPeriod() + ", " + ((Electronics) product).getWattage();
                        writer.write(productInfo);
                        writer.write(System.lineSeparator());
                    } else if (product instanceof Clothing) {
                        // Clothing format
                        String productInfo = product.getProductId() + ", " + product.getProductName() + ", "
                                + product.getProductDescription() + ", " + product.getNumberOfItemsAvailable() + ", "
                                + product.getPrice() + ", " + ((Clothing) product).getSize() + ", "
                                + ((Clothing) product).getColour();
                        writer.write(productInfo);
                        writer.write(System.lineSeparator());
                    }
                }
                System.out.println("Product information saved to " + fileName);
            }
        } else {
            System.out.println("Error creating file or file already exists. Product information was not saved.");
        }  
    }

    private void loadFromFile(String fileName) {
        File file = new File(fileName);

    if (file.exists()) {
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(", ");
                if (parts.length == 8) { // Assuming 8 fields for Electronics
                    String productId = parts[0];
                    String productName = parts[1];
                    String productDescription = parts[2];
                    int numberOfItemsAvailable = Integer.parseInt(parts[3]);
                    double price = Double.parseDouble(parts[4]);
                    String brand = parts[5];
                    int warrantyPeriod = Integer.parseInt(parts[6]);
                    int wattage = Integer.parseInt(parts[7]);

                    Product product = new Electronics(productId, productName, productDescription, numberOfItemsAvailable, price, brand, warrantyPeriod, wattage);
                    productsList.add(product);
                } else if (parts.length == 7) { // Assuming 7 fields for Clothing
                    String productId = parts[0];
                    String productName = parts[1];
                    String productDescription = parts[2];
                    int numberOfItemsAvailable = Integer.parseInt(parts[3]);
                    double price = Double.parseDouble(parts[4]);
                    String size = parts[5];
                    String colour = parts[6];

                    Product product = new Clothing(productId, productName, productDescription, numberOfItemsAvailable, price, size, colour);
                    productsList.add(product);
                }
            }
            System.out.println("Product information loaded from " + fileName);
        } catch (IOException | NumberFormatException e) {
            System.out.println("An error occurred while loading product information.");
            e.printStackTrace();
        }
    } else {
        System.out.println("File does not exist. Starting with an empty product list.");
    }

    }
}
