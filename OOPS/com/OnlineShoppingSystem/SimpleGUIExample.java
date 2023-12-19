package com.OnlineShoppingSystem;


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SimpleGUIExample {
    public static void main(String[] args) {
        // Create a JFrame
        JFrame frame = new JFrame("Westminster Shopping Centre");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(1000, 1000);

        // Create a JPanel with GridLayout
        JPanel panel = new JPanel(new GridLayout(1, 3));
        frame.add(panel);

        // Create a JLabel for the category text
        JLabel categoryLabel = new JLabel("Choose the category");

        // Create a JComboBox for the dropdown menu
        String[] options = {"Option 1", "Option 2"};
        JComboBox<String> dropdown = new JComboBox<>(options);

        // Create a JButton for the Shopping Cart
        JButton cartButton = new JButton("Shopping Cart");

        // Customize the button
        cartButton.setForeground(Color.BLACK); // Text color
        cartButton.setFont(new Font("Helvetica", Font.PLAIN, 12)); // Font

        // Set the preferred size of the button
        cartButton.setPreferredSize(new Dimension(120, 40));

        // Add ActionListener to the button
        cartButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Open a new frame for the shopping cart
                showShoppingCartFrame();
            }
        });

        // Add components to the panel
        panel.add(categoryLabel);
        panel.add(dropdown);
        panel.add(cartButton);

        // Set the frame to be visible
        frame.setVisible(true);
    }

    private static void showShoppingCartFrame() {
        // Create a new JFrame for the shopping cart
        JFrame shoppingCartFrame = new JFrame("Shopping Cart");
        shoppingCartFrame.setSize(400, 300);

        // Create components for the shopping cart frame
        JLabel cartLabel = new JLabel("Your Shopping Cart is Empty");

        // Add components to the shopping cart frame
        shoppingCartFrame.add(cartLabel);

        // Center the frame on the screen
        shoppingCartFrame.setLocationRelativeTo(null);

        // Set the frame to be visible
        shoppingCartFrame.setVisible(true);
    }
}

