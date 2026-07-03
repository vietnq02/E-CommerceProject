/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package e.commerceproject;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Admin
 */
public class ProductManager {

    private ArrayList<Product> products;

    public ProductManager() {
        products = new ArrayList<>();
        loadSampleData();
    }

    private void loadSampleData() {
        products.add(new Product("P01", "iPhone 17", 24990000, 5));
        products.add(new Product("P02", "Keyboard", 500000, 4));
        products.add(new Product("P03", "Mouse", 250000, 3));
        products.add(new Product("P04", "Monitor", 6500000, 4));
        products.add(new Product("P05", "Headphone", 1200000, 5));
        products.add(new Product("P06", "Laptop", 25990000, 5));
        products.add(new Product("P07", "USB Hub", 200000, 3));
        products.add(new Product("P08", "Webcam", 900000, 4));
        products.add(new Product("P09", "Speaker", 1500000, 4));
        products.add(new Product("P10", "Gaming Chair", 4500000, 3));
    }

    public void displayProducts() {
        System.out.println("+-------+----------------------+-----------+---------+");
        System.out.println("| ID    | Name                 |     Price | Rating |");
        System.out.println("+-------+----------------------+-----------+---------+");
        for (Product p : products) {
            System.out.println(p);
        }
        System.out.println("+-------+----------------------+-----------+---------+");
        System.out.println("Total: " + products.size() + " product(s).");
    }

    public void filterByPrice() {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter minimum price: ");
        String minInput = sc.next();
        double minPrice = Double.parseDouble(minInput.replace(".",""));

        System.out.print("Enter maximum price: ");
        String maxInput = sc.next();
        double maxPrice = Double.parseDouble(maxInput.replace(".",""));

        if (minPrice < 0 || maxPrice < 0) {
            System.out.println("Price cannot be negative.");
            return;
        }

        if (minPrice > maxPrice) {
            System.out.println("Minimum price must be less than maximum price.");
            return;
        }

        boolean found = false;

        System.out.println("+-------+----------------------+-----------+---------+");
        System.out.println("| ID    | Name                 |     Price | Rating |");
        System.out.println("+-------+----------------------+-----------+---------+");

        for (Product p : products) {
            if (p.getPrice() >= minPrice && p.getPrice() <= maxPrice) {
                System.out.println(p);
                found = true;
            }
        }

        System.out.println("+-------+----------------------+-----------+---------+");

        if (!found) {
            System.out.println("No products found in this price range.");
        }
    }
}
