/*
 * P2_SubstringAndConcat class implements the java program that illustrate 
 * to return the string length 2 made of its first 2 character. If the string length is 
 * less that 2, use @ for the missing characters.
 */

package com.JavaDeepDrive;

import java.util.Scanner;

public class P2_SubstringAndConcat {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter the String: ");
		String str = sc.nextLine();
		if (str.length() >= 2) {
            System.out.println(str.substring(0, 2));
        } 
		else if (str.length() == 1) {
            System.out.println(str + "@");
        } 
		else {
            System.out.println("@@");
        }

	}

}
