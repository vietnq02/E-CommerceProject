/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package e.commerceproject;

import java.util.Scanner;

public class ECommerceProject {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        ProductManager manager = new ProductManager();

        int choice;

        do {
            System.out.println("\n========== PRODUCT CATALOG ==========");
            System.out.println("1. Display Products");
            System.out.println("2. Add Product");
            System.out.println("3. Update Product");
            System.out.println("4. Delete Product");
            System.out.println("5. Filter By Name");
            System.out.println("6. Filter By Price");
            System.out.println("7. Filter By Rating");
            System.out.println("0. Exit");
            System.out.print("Choose: ");

            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    manager.displayProducts();
                    break;
                case 2:
                    System.out.println("Add Product - Coming soon...");
                    break;
                case 3:
                    System.out.println("Update Product - Coming soon...");
                    break;
                case 4:
                    System.out.println("Delete Product - Coming soon...");
                    break;
                case 5:
                    manager.filterByName();
                    break;
                case 6:
                    manager.filterByPrice();
                    break;
                case 7:
                    manager.filterByRating();
                    break;
                case 0:
                    System.out.println("Good bye!");
                    break;
                default:
                    System.out.println("Invalid choice!");
            }

        } while (choice != 0);
    }
}
