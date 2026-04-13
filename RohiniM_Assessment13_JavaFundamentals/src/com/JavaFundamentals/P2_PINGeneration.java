/*
 * The P2_PINGeneration class implements the program
 * that illustrates to generate the password(PIN) using
 * three input numbers
 */

package com.JavaFundamentals;

import java.util.Scanner;

public class P2_PINGeneration {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter the first number: ");
		int input1 = sc.nextInt();
		System.out.print("Enter the second number: ");
		int input2 = sc.nextInt();
		System.out.print("Enter the third number: ");
		int input3 = sc.nextInt();
		if((!(input1>=100 && input1<=999))||(!(input1>=100 && input1<=999))||(!(input1>=100 && input1<=999))) {
			System.out.println("Invalid Input!!!");
			return;
		}
		int u1 = input1%10;
		int u2 = input2%10;
		int u3 = input3%10;
		
		int t1 = (input1/10)%10;
		int t2 = (input2/10)%10;
		int t3 = (input3/10)%10;
		
		int h1 = input1/100;
		int h2 = input2/100;
		int h3 = input3/100;
		
		int []arr = {u1, u2, u3, t1, t2, t3, h1, h2, h3};
		
		
		int ones = Math.min(u1, Math.min(u2, u3));
		int tens = Math.min(t1, Math.min(t2, t3));
		int hund = Math.min(h1, Math.min(h2, h3));
		
		int max = arr[0];
		for(int num: arr) {
			if(max<num)
				max = num;
		}
		int thou = max;
		//System.out.println(ones+" "+tens+" "+hund+" "+thou);
		int pin = (thou*1000)+(hund*100)+(tens*10+(ones*1));
		System.out.println("PIN:"+pin);
	}

}
