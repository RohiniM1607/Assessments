/*
 * The P4_DingDongNumber class implements the program that
 * illustrates to displaying "ding" for every 5th number and
 * "dong" for every 10th number for the range of number from 
 * starting number to ending number.
 */

package com.JavaFundamentals;

import java.util.Scanner;

public class P4_DingDongNumber {
	public static void display(int start, int end) {
		for(int i=start; i<=end; i++) {
			if(i%10==0)
				System.out.print("dong ");
			else if(i%5==0)
				System.out.print("ding ");
			else
				System.out.print(i+" ");
		}
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter the starting and ending number: ");
		int start = sc.nextInt();
		int end = sc.nextInt();
		display(start, end);
		sc.close();
	}

}
