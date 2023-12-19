package com.OnlineShoppingSystem;
import javax.swing.*;
import java.awt.*;
import java.util.Vector;

public class CustomGridLayoutExample {


    public static void main(String[] args) {
        // Create a JFrame
        JFrame frame = new JFrame("Westminster Shopping Centre");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(1000, 800);

        // Create a JPanel with BorderLayout
        JPanel mainPanel = new JPanel(new BorderLayout());
        frame.add(mainPanel);

        // Create a JPanel for the top part with FlowLayout
        JPanel topPanel = new JPanel(new FlowLayout(FlowLayout.LEADING, 30, 20)); // Adjust the alignment and gaps
        topPanel.setBorder(new EmptyBorder(20, 30, 0, 30)); // Add padding to the top
        mainPanel.add(topPanel, BorderLayout.NORTH);

        // Create a JLabel for the category text
        JLabel categoryLabel = new JLabel("Choose the product category type : ");
        topPanel.add(categoryLabel);

        // Adjust spacing between label and dropdown
        topPanel.add(Box.createRigidArea(new Dimension(0, 0))); // Add 20 pixels of spacing

        // Create a JComboBox for the dropdown menu
        String[] options = {"Clothing", "Electronics"};
        JComboBox<String> dropdown = new JComboBox<>(options);

        topPanel.add(dropdown);

        // Adjust spacing between dropdown and button
        topPanel.add(Box.createRigidArea(new Dimension(300, 20))); // Add 20 pixels of spacing

        // Create a JButton for the Shopping Cart
        JButton cartButton = new JButton("Shopping Cart");
        customizeButton(cartButton);
        topPanel.add(cartButton);

        // Create a JPanel for the main content with GridLayout
        JPanel contentPanel = new JPanel(new GridLayout(1, 1));
        mainPanel.add(contentPanel, BorderLayout.CENTER);

        // Create a table for displaying products
        JTable productTable = createProductTable();
        contentPanel.add(new JScrollPane(productTable));

        // Set the frame to be visible
        frame.setVisible(true);
    }

    private static void customizeButton(JButton button) {
        // Customize the button appearance
        button.setForeground(Color.BLACK);
        button.setBackground(new Color(0, 0, 0));
        button.setFocusPainted(false);
        button.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(new Color(0, 0, 0), 1),
                BorderFactory.createEmptyBorder(10, 20, 10, 20)
        ));
    }

    private static JTable createProductTable() {
        Vector<String> columnNames = new Vector<>();
        columnNames.add("Product ID");
        columnNames.add("Product Name");
        columnNames.add("Category");
        columnNames.add("Price");
        columnNames.add("Info");

        Vector<Vector<String>> data = new Vector<>();

        // Populate data with sample products
        for (int i = 0; i < 10; i++) {
            Vector<String> row = new Vector<>();
            row.add("ID" + i);
            row.add("Product" + i);
            row.add("Category" + i);
            row.add("$" + (i * 10));
            row.add("Info" + i);
            data.add(row);
        }

        DefaultTableModel model = new DefaultTableModel(data, columnNames);
        JTable productTable = new JTable(model);
        productTable.setShowGrid(true);
        productTable.setGridColor(Color.BLACK);
        productTable.setIntercellSpacing(new Dimension(5, 5));

        // Set bold font for table header
        JTableHeader header = productTable.getTableHeader();
        header.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 14)); // Increased font size

        // Set bold font for table cells
        productTable.setFont(new Font(Font.SANS_SERIF, Font.PLAIN, 14)); // Increased font size

        // Center align cell data
        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment(SwingConstants.CENTER);
        for (int i = 0; i < productTable.getColumnCount(); i++) {
            productTable.getColumnModel().getColumn(i).setCellRenderer(centerRenderer);
        }

        // Adjust column widths
        for (int i = 0; i < productTable.getColumnCount(); i++) {
            productTable.getColumnModel().getColumn(i).setPreferredWidth(200); // Increased width
        }

        // Add more padding
        productTable.setRowHeight(productTable.getRowHeight() + 10);

        return productTable;
    }
}
