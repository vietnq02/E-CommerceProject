package e.commerceproject.util;

import e.commerceproject.model.Product;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class FileManager {

    private static final String FILE_NAME = "products.dat";

    public static void saveProducts(ArrayList<Product> products) {
        try (ObjectOutputStream output =
                new ObjectOutputStream(new FileOutputStream(FILE_NAME))) {

            output.writeObject(products);

        } catch (IOException e) {
            System.out.println("Error saving product data.");
        }
    }

    @SuppressWarnings("unchecked")
    public static ArrayList<Product> loadProducts() {
        try (ObjectInputStream input =
                new ObjectInputStream(new FileInputStream(FILE_NAME))) {

            return (ArrayList<Product>) input.readObject();

        } catch (IOException | ClassNotFoundException e) {
            return new ArrayList<>();
        }
    }
}