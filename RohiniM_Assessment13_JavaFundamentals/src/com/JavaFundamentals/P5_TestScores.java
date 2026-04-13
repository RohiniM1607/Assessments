/*
 * The P5_TestScores class implements the program that 
 * illustrates to replace the students score based on 
 * the condition.
 */

package com.JavaFundamentals;

import java.util.Scanner;

public class P5_TestScores {
	public static int[] replaceScore(int[] scores, int count) {

		int[] modifiedScore = new int[count];

		for (int i = 0; i < count; i++) {
			int score = scores[i];
			int result = -1;

			if (score % 2 == 0)
				result = Math.max(result, 0);

			if (score % 2 != 0)
				result = Math.max(result, 1);

			if (score % 8 == 0)
				result = Math.max(result, 2);

			if (score % 10 == 3)
				result = Math.max(result, 3);

			if (score % 9 == 0)
				result = Math.max(result, 4);

			modifiedScore[i] = result;
		}

		return modifiedScore;
	}

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		int score;
		int scores[] = new int[100];
		int count = 0;

		System.out.println("Enter the scores (enter a negative number to stop input):");

		do {
			score = sc.nextInt();

			if (score >= 0) {
				scores[count] = score;
				count++;
			}

		} while (score >= 0);

		int modifiedScore[] = replaceScore(scores, count);

		System.out.println("\nScores before processing:");
		for (int i = 0; i < count; i++)
			System.out.print(scores[i] + " ");

		System.out.println("\n\nScores after processing:");
		for (int i = 0; i < count; i++)
			System.out.print(modifiedScore[i] + " ");
	}

}
