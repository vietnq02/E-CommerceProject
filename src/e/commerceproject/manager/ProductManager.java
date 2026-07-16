/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package e.commerceproject.manager;

import e.commerceproject.model.Product;
import java.util.ArrayList;
import java.util.Scanner;
import e.commerceproject.util.FileManager;

/**
 *
 * @author Admin
 */
public class ProductManager {

    private ArrayList<Product> products;
    private final Scanner sc = new Scanner(System.in);
   

    public ProductManager() {
        products = FileManager.loadProducts();

        if (products == null || products.isEmpty()) {
            products = new ArrayList<>();
            loadSampleData();
            FileManager.saveProducts(products);
        }
    }

    // Load sample data
    private void loadSampleData() {
        products.add(new Product("P01", "iPhone 17", 24_990_000, 5));
        products.add(new Product("P02", "Keyboard", 500_000, 4));
        products.add(new Product("P03", "Mouse", 250_000, 3));
        products.add(new Product("P04", "Monitor", 6_500_000, 4));
        products.add(new Product("P05", "Headphone", 1_200_000, 5));
        products.add(new Product("P06", "Laptop", 25_990_000, 5));
        products.add(new Product("P07", "USB Hub", 200_000, 3));
        products.add(new Product("P08", "Webcam", 900_000, 4));
        products.add(new Product("P09", "Speaker", 1_500_000, 4));
        products.add(new Product("P10", "Gaming Chair", 4_500_000, 3));
    }

    private void printHeader() {
        System.out.println("+-------+----------------------+---------------+--------+");
        System.out.println("| ID    | Name                 | Price         | Rating |");
        System.out.println("+-------+----------------------+---------------+--------+");
    }

    private void printFooter() {
        System.out.println("+-------+----------------------+---------------+--------+");
    }

    // Display all products
    public void displayProducts() {
        printHeader();

        for (Product p : products) {
            System.out.println(p);
        }

        printFooter();
        System.out.println("Total: " + products.size() + " product(s).");
    }

    // Filter products by price
    public void filterByPrice() {
        System.out.print("Enter minimum price: ");
        String minInput = sc.nextLine().trim();

        System.out.print("Enter maximum price: ");
        String maxInput = sc.nextLine().trim();

        double minPrice;
        double maxPrice;

        try {
            minPrice = Double.parseDouble(minInput.replace(".", ""));
            maxPrice = Double.parseDouble(maxInput.replace(".", ""));
        } catch (NumberFormatException e) {
            System.out.println("Invalid price format.");
            return;
        }

        if (minPrice < 0 || maxPrice < 0) {
            System.out.println("Price cannot be negative.");
            return;
        }

        if (minPrice > maxPrice) {
            System.out.println("Minimum price must be less than maximum price.");
            return;
        }

        boolean found = false;

        printHeader();

        for (Product p : products) {
            if (p.getPrice() >= minPrice && p.getPrice() <= maxPrice) {
                System.out.println(p);
                found = true;
            }
        }

        printFooter();

        if (!found) {
            System.out.println("No products found in this price range.");
        }
    }

    // Filter products by name
    public void filterByName() {
        System.out.print("Enter product name to search: ");
        String keyword = sc.nextLine().trim();

        if (keyword.isEmpty()) {
            System.out.println("Keyword cannot be empty.");
            return;
        }

        boolean found = false;

        printHeader();

        for (Product p : products) {
            if (p.getName().toLowerCase().contains(keyword.toLowerCase())) {
                System.out.println(p);
                found = true;
            }
        }

        printFooter();

        if (!found) {
            System.out.println("No products found matching \"" + keyword + "\".");
        }
    }

    // Filter products by rating
    public void filterByRating() {
        System.out.print("Enter rating from 1 to 5: ");
        String ratingInput = sc.nextLine().trim();

        int rating;

        try {
            rating = Integer.parseInt(ratingInput);
        } catch (NumberFormatException e) {
            System.out.println("Invalid rating format.");
            return;
        }

        if (rating < 1 || rating > 5) {
            System.out.println("Rating must be from 1 to 5.");
            return;
        }

        boolean found = false;

        printHeader();

        for (Product p : products) {
            if (p.getRating() == rating) {
                System.out.println(p);
                found = true;
            }
        }

        printFooter();

        if (!found) {
            System.out.println("No products found with this rating.");
        }
    }

    // Generate new product ID
    private String generateNewId() {
        int maxNumber = 0;

        for (Product p : products) {
            String numberPart = p.getId().replaceAll("[^0-9]", "");

            try {
                int number = Integer.parseInt(numberPart);

                if (number > maxNumber) {
                    maxNumber = number;
                }
            } catch (NumberFormatException e) {
                // Ignore invalid ID format
            }
        }

        return "P" + String.format("%02d", maxNumber + 1);
    }

    // Find product by ID
    private Product findById(String id) {
        for (Product p : products) {
            if (p.getId().equalsIgnoreCase(id)) {
                return p;
            }
        }

        return null;
    }

    // Add new product
    public void addProduct() {
        String id = generateNewId();

        System.out.print("Enter product name: ");
        String name = sc.nextLine().trim();

        if (name.isEmpty()) {
            System.out.println("Product name cannot be empty.");
            return;
        }

        System.out.print("Enter product price: ");
        String priceInput = sc.nextLine().trim();

        double price;

        try {
            price = Double.parseDouble(priceInput.replace(".", ""));
        } catch (NumberFormatException e) {
            System.out.println("Invalid price format.");
            return;
        }

        if (price <= 0) {
            System.out.println("Price must be greater than 0.");
            return;
        }

        System.out.print("Enter rating from 1 to 5: ");
        String ratingInput = sc.nextLine().trim();

        int rating;

        try {
            rating = Integer.parseInt(ratingInput);
        } catch (NumberFormatException e) {
            System.out.println("Invalid rating format.");
            return;
        }

        if (rating < 1 || rating > 5) {
            System.out.println("Rating must be from 1 to 5.");
            return;
        }

        Product newProduct = new Product(id, name, price, rating);
        products.add(newProduct);
        FileManager.saveProducts(products);

        System.out.println("Product added successfully:");
        printHeader();
        System.out.println(newProduct);
        printFooter();
    }

    // Update product
    public void updateProduct() {
        System.out.print("Enter product ID to update: ");
        String id = sc.nextLine().trim();

        Product product = findById(id);

        if (product == null) {
            System.out.println("Product not found.");
            return;
        }

        System.out.println("Current product:");
        printHeader();
        System.out.println(product);
        printFooter();

        System.out.print("Enter new product name: ");
        String name = sc.nextLine().trim();

        if (!name.isEmpty()) {
            product.setName(name);
        }

        System.out.print("Enter new product price: ");
        String priceInput = sc.nextLine().trim();

        if (!priceInput.isEmpty()) {
            try {
                double price = Double.parseDouble(priceInput.replace(".", ""));

                if (price <= 0) {
                    System.out.println("Price must be greater than 0.");
                    return;
                }

                product.setPrice(price);

            } catch (NumberFormatException e) {
                System.out.println("Invalid price format.");
                return;
            }
        }

        System.out.print("Enter new rating from 1 to 5: ");
        String ratingInput = sc.nextLine().trim();

        if (!ratingInput.isEmpty()) {
            try {
                int rating = Integer.parseInt(ratingInput);

                if (rating < 1 || rating > 5) {
                    System.out.println("Rating must be from 1 to 5.");
                    return;
                }

                product.setRating(rating);

            } catch (NumberFormatException e) {
                System.out.println("Invalid rating format.");
                return;
            }
        }

        FileManager.saveProducts(products);

        System.out.println("Product updated successfully:");
        printHeader();
        System.out.println(product);
        printFooter();
    }

    // Delete product
    public void deleteProduct() {
        System.out.print("Enter product ID to delete: ");
        String id = sc.nextLine().trim();

        if (id.isEmpty()) {
            System.out.println("Product ID cannot be empty.");
            return;
        }

        Product productToDelete = findById(id);

        if (productToDelete == null) {
            System.out.println("Product not found.");
            return;
        }

        System.out.println("Product found:");
        printHeader();
        System.out.println(productToDelete);
        printFooter();

        System.out.print("Are you sure you want to delete this product? (Y/N): ");
        String confirm = sc.nextLine().trim();

        if (confirm.equalsIgnoreCase("Y")) {
            products.remove(productToDelete);
            FileManager.saveProducts(products);
            System.out.println("Product deleted successfully.");
        } else {
            System.out.println("Delete cancelled.");
        }
    } 
}