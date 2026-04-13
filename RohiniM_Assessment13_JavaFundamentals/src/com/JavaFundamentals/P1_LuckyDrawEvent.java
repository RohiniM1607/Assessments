/*
 * The p1_LuckyDrawEvent class implement the program 
 * illustrate to find the first, second, third prize amount
 * based on the token number using arrays.
 */

package com.JavaFundamentals;

import java.util.Scanner;

public class P1_LuckyDrawEvent {
	public static int addNum(int num) {
		int sum = 0;
		while(num>0) {
			int rem = num%10;
			sum+=rem;
			num/=10;
		}
		return sum;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("No of Participants: ");
		int n = sc.nextInt();
		int []token = new int[n];
		System.out.print("Token Number for "+n+" participants: ");
		for(int i=0; i<n; i++) {
			token[i] = sc.nextInt();
			if(!(token[i]>=1000 && token[i]<=9999)) {
				System.out.println("Invalid Input!!");
				return;
			}
		}
		int first=0, second=0, third=0;
		for(int i=0; i<n; i++) {
			int num = token[i];
			int sum = addNum(num);
			while(sum>9)
				sum = addNum(sum);
			if(sum == 7) 
				first = token[i];
			else if(sum==5)
				second = token[i];
			else if(sum==3)
				third = token[i];
		}
		System.out.println("First Prize is to token: "+first);
		System.out.println("Second Prize is to token: "+second);
		System.out.println("Third Prize is to token: "+third);
	}

}
