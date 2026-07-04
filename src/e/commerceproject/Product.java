/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package e.commerceproject;

import java.text.NumberFormat;
import java.util.Locale;

/**
 *
 * @author Admin
 */
public class Product {

    private String id;
    private String name;
    private double price;
    private int rating;

    public Product(String id, String name, double price, int rating) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.rating = rating;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public int getRating() {
        return rating;
    }

    @Override
    public String toString() {
        NumberFormat vn = NumberFormat.getInstance(new Locale("vi", "VN"));
        return String.format("| %-5s | %-20s | %15s ₫ | %-5s |",
                id, name, vn.format(price), rating + "/5");
    }
}
