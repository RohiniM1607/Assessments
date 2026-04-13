/*
 * P4_StoreAndProduct class implements the java program that illustrates to store
 * the ariety of products and sort the products based on various field, sort the product
 * based on the price, id, name, quantity.
 */

package com.JavaDeepDrive;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

class Product implements Comparable<Product>{
	private int productId;
    private String productName;
    private String productCategory;
    private double productPrice;
    private double productDiscount;
    private int productQuantity;

    public Product(int productId, String productName, String productCategory,
                   double productPrice, double productDiscount, int productQuantity) {
        this.productId = productId;
        this.productName = productName;
        this.productCategory = productCategory;
        this.productPrice = productPrice;
        this.productDiscount = productDiscount;
        this.productQuantity = productQuantity;
    }

    public int getProductId() {
        return productId;
    }

    public String getProductCategory() {
        return productCategory;
    }
    
    public double getProductPrice() {
        return productPrice;
    }

    @Override
    public int compareTo(Product p) {
        return this.productId - p.productId;
    }

    @Override
    public String toString() {
        return productId + " | " + productName + " | " + productCategory + " | "
                + productPrice + " | " + productDiscount + " | " + productQuantity;
    }

}

public class P4_StoreAndProduct {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
        List<Product> products = new ArrayList<>();

        System.out.print("Enter the number of products: ");
        int n = sc.nextInt();
        sc.nextLine();

        for (int i = 0; i < n; i++) {
            System.out.println("Enter product " + (i + 1) + " details:");

            System.out.print("Enter Product Id: ");
            int id = sc.nextInt();
            sc.nextLine();

            System.out.print("Enter Product Name: ");
            String name = sc.nextLine();

            System.out.print("Enter Product Category: ");
            String category = sc.nextLine();

            System.out.print("Enter Product Price: ");
            double price = sc.nextDouble();

            System.out.print("Enter Product Discount: ");
            double discount = sc.nextDouble();

            System.out.print("Enter Product Quantity: ");
            int quantity = sc.nextInt();
            sc.nextLine();

            products.add(new Product(id, name, category, price, discount, quantity));
        }

        int choice;

		do {
			System.out.println("1. Sort by Id");
			System.out.println("2. List Mobiles with price more than 40000");
			System.out.println("3. Exit");
			
			System.out.print("Enter the option for sorting: ");
			choice = sc.nextInt();
			
			switch(choice) {
			case 1:
                Collections.sort(products);
                for (Product p : products) {
                    System.out.println(p);
                }
                break;

            case 2:
                boolean found = false;
                for (Product p : products) {
                    if (p.getProductCategory().equalsIgnoreCase("Mobile") && p.getProductPrice() > 40000) {
                        System.out.println(p);
                        found = true;
                    }
                }
                if (!found) {
                    System.out.println("No mobile products found with price more than 40000");
                }
                break;

            case 3:
                System.out.println("Thank you!");
                break;

            default:
                System.out.println("Invalid option");
			}
		}while(choice!=3);
		
		
	}
}
