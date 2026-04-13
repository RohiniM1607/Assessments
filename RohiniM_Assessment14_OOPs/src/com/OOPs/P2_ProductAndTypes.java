/*
 * The class P2_ProductAndTypes that implements the program
 * that illustrates to create a abstract class and give definition
 * for the sub classes
 */

package com.OOPs;

import java.util.Scanner;

abstract class Product{
	int productId;
	String productName;
	double price;
	public Product(int productId, String productName, double price) {
		this.productId = productId;
		this.productName = productName;
		this.price = price;
	}
	
	public int getProductId() {
		return productId;
	}
	
	public String getProductName() {
		return productName;
	}
	
	public double getPrice() {
		return price;
	}
	
	abstract void displayInfo();
	
}

class ElectronicProduct extends Product{
	int warrantyPeriod;

	public ElectronicProduct(int productId, String productName, double price, int warrantyPeriod) {
		super(productId, productName, price);
		this.warrantyPeriod = warrantyPeriod;
	}
	
	int getWarrantyPeriod() {
		return warrantyPeriod;
	}
	
	void displayInfo(){
		System.out.println("ELECTRONIC PRODUCT INFORMATION:");
		System.out.println("Product id: "+productId);
		System.out.println("Product Name: "+productName);
		System.out.println("Price: $"+price);
		System.out.println("Warranty Period: "+warrantyPeriod+" Months");
	}
}

class ClothingProduct extends Product{
	String size;
	String material;
	public ClothingProduct(int productId, String productName, double price, String size, String material) {
		super(productId, productName, price);
		this.size = size;
		this.material = material;
	}
	
	public String getSize() {
		return size;
	}
	
	public String getMaterial() {
		return material;
	}
	
	void displayInfo() {
		System.out.println("ELECTRONIC PRODUCT INFORMATION:");
		System.out.println("Product id: "+productId);
		System.out.println("Product Name: "+productName);
		System.out.println("Price: $"+price);
		System.out.println("Size: "+size);
		System.out.println("Material: "+material);
	}
}

public class P2_ProductAndTypes {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int choice;

		do {

			System.out.println("\nPRODUCT TYPE");
			System.out.println("1. Electronic Product");
			System.out.println("2. Clothing Product");
			System.out.println("3. Exit");

			System.out.print("\nSelect the product Type: ");
			choice = sc.nextInt();
			
			if (choice==1 || choice==2) {

				System.out.print("Enter the Product Id: ");
				int productId = sc.nextInt();

				sc.nextLine();

				System.out.print("Enter the Product Name: ");
				String productName = sc.nextLine();

				System.out.print("Enter the price: ");
				double price = sc.nextDouble();

				if (choice==1) {

					System.out.print("Enter the Warranty Period: ");
					int warrantyPeriod = sc.nextInt();

					Product elePro = new ElectronicProduct(productId, productName, price, warrantyPeriod);
					elePro.displayInfo();
				}

				else {
					System.out.print("Enter the size: ");
					String size = sc.next();

					System.out.print("Enter the Material: ");
					String material = sc.next();

					Product cloPro = new ClothingProduct(productId, productName, price, size, material);
					cloPro.displayInfo();
				}
			}

			else if (choice==3) 
				System.out.println("Exiting from the application. Thank you");
			

			else 
				System.out.println("Invalid Choice!");
			

		} while (choice != 3);

	}

}
