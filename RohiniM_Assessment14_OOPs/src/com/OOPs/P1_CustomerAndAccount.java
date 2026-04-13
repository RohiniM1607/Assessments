/*
 * The class P1_CustomerAndAccount that illustrates the program
 * to create the derived class and perform both classes
 */

package com.OOPs;

import java.util.Scanner;

class Customer{
	private int id;
	private String name;
	private char gender;
	
	public Customer(int id, String name, char gender) {
		super();
		this.id = id;
		this.name = name;
		this.gender = gender;
	}
	
	public int getId() {
		return id;
	}
	
	public String getName() {
		return name;
	}
	
	
	public char getGender() {
		return gender;
	}
	
	
	@Override
	public String toString() {
		return "Customer [id=" + id + ", name=" + name + "]";
	}
	
	
}

class Account{
	private int id;
	private Customer customer;
	private double balance = 0.0;
	
	public Account(int id, Customer customer, double balance) {
		this.id = id;
		this.customer = customer;
		this.balance = balance;
	}
	
	public Account(int id, Customer customer) {
		this.id = id;
		this.customer = customer;
	}

	public int getId() {
		return id;
	}

	public Customer getCustomer() {
		return customer;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

	@Override
	public String toString() {
		return "Account [Id=" + id + ", Balance=" + balance + "]";
	}
	
	public String getCustomerName() {
		return customer.getName();
	}
	
	public Account deposit(double amount) {
		balance+=amount;
		System.out.println("AMOUNT DEPOSITED SUCCESSFULLY!!");
		return this;
	}
	
	public Account withdraw(double amount) {
		if(balance>=amount) {
			balance-=amount;
			System.out.println("AMOUNT WITHDRAW SUCCESSFULLY");
		}
		else
			System.out.println("AMOUNT WITHDRAWN EXCEED THE CURRENT BALANCE!");
		return this;
	}
}

public class P1_CustomerAndAccount {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.print("ACCOUNT_ID: ");
		int accId = sc.nextInt();
		
		System.out.print("CUSTOMER_ID: ");
		int cusId = sc.nextInt();
		
		sc.nextLine();
		
		System.out.print("CUSTOMER_NAME: ");
		String cusName = sc.nextLine();
		
		System.out.print("CUSTOMER_GENDER: ");
		char cusGen = sc.next().charAt(0);
		
		System.out.print("ACCOUNT_BALANCE: ");
		double accBal = sc.nextDouble();
		
		Customer cus = new Customer(cusId, cusName, cusGen);
		Account acc = new Account(accId, cus, accBal);
		
		System.out.println("\nPLEASE SELECT ONE OPTION FROM BELOW");
		int option = 0, amount;
		do {
			System.out.println("\n1. WITHDRAW\n2. DEPOSIT\n3. CHECK BALANCE\n4. EXIT");
			System.out.print("\nOption: ");
			option = sc.nextInt();
			
			switch(option) {
			case 1:
				System.out.print("ENTER AMOUNT TO WITHDRAW: ");
				amount = sc.nextInt();
				acc.withdraw(amount);
				break;
				
			case 2:
				System.out.print("ENTER AMOUNT TO DEPOSIT: ");
				amount = sc.nextInt();
				acc.deposit(amount);
				break;
				
			case 3:
				System.out.println(acc);
				break;
				
			case 4:
				System.out.println("THANK YOU FOR BANKING WITH US!!");
				break;
				
			default:
				System.out.println("Invalid option. please try again!!");
				break;
				
			}
		}while(option!=4);

	}

}
