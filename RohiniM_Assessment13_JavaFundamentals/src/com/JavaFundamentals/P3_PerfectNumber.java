/*
 * The P3_PerfectNumber class implements the program that 
 * illustrates to check whether the given number is perfect
 * number or not.
 */

package com.JavaFundamentals;

import java.util.Scanner;

public class P3_PerfectNumber {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter a positive number: ");
		int num = sc.nextInt();
		if(num<=0) {
			System.out.println("Invalid Number");
			return;
		}
		int sum = 0;
		for(int i=1; i<num; i++) {
			if(num%i==0)
				sum+=i;
		}
		if(num==sum)
			System.out.println("The given number is perfect");
		else
			System.out.println("The given number is not perfect");
		sc.close();
	}

}
