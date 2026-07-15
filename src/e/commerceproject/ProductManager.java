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

    private void printHeader() {
        System.out.println("+-------+----------------------+-------------------+-------+");
        System.out.println("| ID    | Name                 |             Price | Rate  |");
        System.out.println("+-------+----------------------+-------------------+-------+");
    }

    private void printFooter() {
        System.out.println("+-------+----------------------+-------------------+-------+");
    }

    // public void displayProducts() {
    // System.out.println("+-------+----------------------+-----------+---------+");
    // System.out.println("| ID | Name | Price | Rating |");
    // System.out.println("+-------+----------------------+-----------+---------+");
    // for (Product p : products) {
    // System.out.println(p);
    // }
    // System.out.println("+-------+----------------------+-----------+---------+");
    // System.out.println("Total: " + products.size() + " product(s).");
    // }
    public void displayProducts() {
        printHeader();
        for (Product p : products) {
            System.out.println(p);
        }
        printFooter();
        System.out.println("Total: " + products.size() + " product(s).");
    }

    // public void filterByPrice() {
    // Scanner sc = new Scanner(System.in);
    //
    // System.out.print("Enter minimum price: ");
    // String minInput = sc.next();
    // double minPrice = Double.parseDouble(minInput.replace(".", ""));
    //
    // System.out.print("Enter maximum price: ");
    // String maxInput = sc.next();
    // double maxPrice = Double.parseDouble(maxInput.replace(".", ""));
    //
    // if (minPrice < 0 || maxPrice < 0) {
    // System.out.println("Price cannot be negative.");
    // return;
    // }
    //
    // if (minPrice > maxPrice) {
    // System.out.println("Minimum price must be less than maximum price.");
    // return;
    // }
    //
    // boolean found = false;
    //
    // System.out.println("+-------+----------------------+-----------+---------+");
    // System.out.println("| ID | Name | Price | Rating |");
    // System.out.println("+-------+----------------------+-----------+---------+");
    //
    // for (Product p : products) {
    // if (p.getPrice() >= minPrice && p.getPrice() <= maxPrice) {
    // System.out.println(p);
    // found = true;
    // }
    // }
    //
    // System.out.println("+-------+----------------------+-----------+---------+");
    //
    // if (!found) {
    // System.out.println("No products found in this price range.");
    // }
    // }
    public void filterByPrice() {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter minimum price: ");
        String minInput = sc.next();
        double minPrice = Double.parseDouble(minInput.replace(".", ""));

        System.out.print("Enter maximum price: ");
        String maxInput = sc.next();
        double maxPrice = Double.parseDouble(maxInput.replace(".", ""));

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

    // public void filterByName() {
    // Scanner sc = new Scanner(System.in);
    // System.out.print("Enter product name to search: ");
    // String keyword = sc.nextLine().trim();
    //
    // if (keyword.isEmpty()) {
    // System.out.println("Keyword cannot be empty.");
    // return;
    // }
    //
    // String keywordLower = keyword.toLowerCase();
    // boolean found = false;
    //
    // System.out.println("+-------+----------------------+-----------+---------+");
    // System.out.println("| ID | Name | Price | Rating |");
    // System.out.println("+-------+----------------------+-----------+---------+");
    // for (Product p : products) {
    // if (p.getName().toLowerCase().contains(keywordLower)) {
    // System.out.println(p);
    // found = true;
    // }
    // }
    // System.out.println("+-------+----------------------+-----------+---------+");
    //
    // if (!found) {
    // System.out.println("No products found matching \"" + keyword + "\".");
    // }
    // }
    public void filterByName() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter product name to search: ");
        String keyword = sc.nextLine().trim();

        if (keyword.isEmpty()) {
            System.out.println("Keyword cannot be empty.");
            return;
        }

        String keywordLower = keyword.toLowerCase();
        boolean found = false;

        printHeader();
        for (Product p : products) {
            if (p.getName().toLowerCase().contains(keywordLower)) {
                System.out.println(p);
                found = true;
            }
        }
        printFooter();

        if (!found) {
            System.out.println("No products found matching \"" + keyword + "\".");
        }
    }

    // public void filterByRating() {
    // System.out.print("Enter rating from 1 to 5: ");
    // int rating = sc.nextInt();
    //
    // if (rating < 1 || rating > 5) {
    // System.out.println("Rating must be from 1 to 5.");
    // return;
    // }
    //
    // boolean found = false;
    //
    // System.out.println("+-------+----------------------+-----------+---------+");
    // System.out.println("| ID | Name | Price | Rating |");
    // System.out.println("+-------+----------------------+-----------+---------+");
    //
    // for (Product p : products) {
    // if (p.getRating() == rating) {
    // System.out.println(p);
    // found = true;
    // }
    // }
    //
    // System.out.println("+-------+----------------------+-----------+---------+");
    //
    // if (!found) {
    // System.out.println("No products found with this rating.");
    // }
    // }
    public void filterByRating() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter rating from 1 to 5: ");
        int rating = sc.nextInt();

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

    public void addProduct() {
        Scanner sc = new Scanner(System.in);

        // Nhập ID sản phẩm
        System.out.print("Enter product ID: ");
        String id = sc.nextLine().trim();

        if (id.isEmpty()) {
            System.out.println("Product ID cannot be empty.");
            return;
        }

        // Kiểm tra ID đã tồn tại chưa (không được trùng)
        for (Product p : products) {
            if (p.getId().equalsIgnoreCase(id)) {
                System.out.println("Product ID already exists. Please use a different ID.");
                return;
            }
        }

        // Nhập tên sản phẩm
        System.out.print("Enter product name: ");
        String name = sc.nextLine().trim();

        if (name.isEmpty()) {
            System.out.println("Product name cannot be empty.");
            return;
        }

        // Nhập giá sản phẩm
        // Dùng cách xử lý giống filterByPrice: bỏ dấu "." để parse số cho đúng (vd: 1.500.000 -> 1500000)
        System.out.print("Enter product price: ");
        String priceInput = sc.next();
        double price;
        try {
            price = Double.parseDouble(priceInput.replace(".", ""));
        } catch (NumberFormatException e) {
            System.out.println("Invalid price format.");
            return;
        }

        if (price < 0) {
            System.out.println("Price cannot be negative.");
            return;
        }

        // Nhập rating (đánh giá sao) từ 1 đến 5
        System.out.print("Enter rating from 1 to 5: ");
        int rating;
        try {
            rating = sc.nextInt();
        } catch (Exception e) {
            System.out.println("Invalid rating format.");
            return;
        }

        if (rating < 1 || rating > 5) {
            System.out.println("Rating must be from 1 to 5.");
            return;
        }

        // Tạo sản phẩm mới và thêm vào danh sách
        Product newProduct = new Product(id, name, price, rating);
        products.add(newProduct);

        // In ra sản phẩm vừa thêm để xác nhận
        System.out.println("Product added successfully:");
        printHeader();
        System.out.println(newProduct);
        printFooter();
    }

    public void deleteProduct() {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter product ID to delete: ");
        String id = sc.nextLine().trim();

        if (id.isEmpty()) {
            System.out.println("Product ID cannot be empty.");
            return;
        }

        Product productToDelete = null;

        for (Product p : products) {
            if (p.getId().equalsIgnoreCase(id)) {
                productToDelete = p;
                break;
            }
        }

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
            System.out.println("Product deleted successfully.");
        } else {
            System.out.println("Delete cancelled.");
        }
    }
}
