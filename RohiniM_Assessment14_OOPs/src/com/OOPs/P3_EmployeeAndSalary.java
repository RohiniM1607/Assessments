/*
 * The class P3_EmployeeAndSalary implement the program
 * that illustrates to method overload that provide the
 * variations of method to handle different salary related
 * scenario for the employees
 */

package com.OOPs;

import java.util.Scanner;

class Employee{
	int employeeId;
	String name;
	String designation;
	double salary;
	public Employee(int employeeId, String name, String designation, double salary) {
		super();
		this.employeeId = employeeId;
		this.name = name;
		this.designation = designation;
		this.salary = salary;
	}
	void displayInfo() {
		System.out.println("Employee Id: "+employeeId);
		System.out.println("Employee Name: "+name);
		System.out.println("Designation: "+designation);
		System.out.println("Salary: "+salary);
		
	}
	
	void increaseSalary(double percentage) {
		salary +=  (salary*percentage/100);
	}
	
	void increaseSalary(double percentage, double bonus) {
		salary += (salary * percentage / 100) + bonus;
	}
}

public class P3_EmployeeAndSalary {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		System.out.print("Enter Employee Id: ");
		int id = sc.nextInt();

		sc.nextLine();

		System.out.print("Enter Employee Name: ");
		String name = sc.nextLine();

		System.out.print("Enter Designation: ");
		String designation = sc.nextLine();

		System.out.print("Enter Salary: ");
		double salary = sc.nextDouble();

		Employee emp = new Employee(id, name, designation, salary);

		System.out.println("\nInitial Employee Details:");
		emp.displayInfo();

		System.out.print("Enter percentage to increase salary: ");
		double percentage = sc.nextDouble();

		emp.increaseSalary(percentage);

		System.out.println("\nAfter Percentage Increase:");
		emp.displayInfo();

		System.out.print("Enter bonus amount: ");
		double bonus = sc.nextDouble();

		emp.increaseSalary(percentage, bonus);

		System.out.println("\nAfter Percentage Increase + Bonus:");
		emp.displayInfo();
	}

}
