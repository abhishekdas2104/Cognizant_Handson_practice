package DSAExercise.InventoryManagementSystem;

import java.util.ArrayList;

public class InventoryManagement {
    static class Product {
        int productId;
        String productName;
        int quantity;
        double price;
        Product(int productId, String productName, int quantity, double price) {
            this.productId = productId;
            this.productName = productName;
            this.quantity = quantity;
            this.price = price;
        }
    }
    public static void main(String[] args) {
        ArrayList<Product> products = new ArrayList<>();
        products.add(new Product(101, "Laptop", 10, 50000));
        products.add(new Product(102, "Mouse", 20, 500));
        products.add(new Product(103, "Keyboard", 15, 1000));
        System.out.println("Products:");

        for(int i = 0; i < products.size(); i++) {
            Product p = products.get(i);
            System.out.println(p.productId + " " + p.productName + " " + p.quantity + " " + p.price);
        }
        for(int i = 0; i < products.size(); i++) {
            if(products.get(i).productId == 101) {
                products.get(i).quantity = 25;
            }
        }
        for(int i = 0; i < products.size(); i++) {
            if(products.get(i).productId == 102) {
                products.remove(i);
                break;
            }
        }
        System.out.println("\nAfter Update and Delete:");

        for(int i = 0; i < products.size(); i++) {
            Product p = products.get(i);
            System.out.println(p.productId + " " + p.productName + " " + p.quantity + " " + p.price);
        }
    }
}