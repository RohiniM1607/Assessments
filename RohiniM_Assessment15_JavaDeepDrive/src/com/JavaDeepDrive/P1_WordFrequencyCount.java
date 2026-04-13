/*
 * P1_WordFrequencyCount class implements the java program that illustrates to count
 * the word frequency and print in sorted order and also handle the exception for 
 * file missing.
 */

package com.JavaDeepDrive;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class P1_WordFrequencyCount {

	public static void main(String[] args) {
		try {
            File file = new File("Words.txt");
            Scanner sc = new Scanner(file);

            ArrayList<String> words = new ArrayList<>();

            while (sc.hasNext()) {
                words.add(sc.next().toLowerCase());
            }
            sc.close();

            Collections.sort(words);

            int uniqueCount = 0;
            for (int i = 0; i < words.size(); i++) {
                int count = 1;

                while (i + 1 < words.size() && words.get(i).equals(words.get(i + 1))) {
                    count++;
                    i++;
                }

                System.out.println(words.get(i) + ": " + count);
                uniqueCount++;
            }

            System.out.println("Unique words: " + uniqueCount);

        } catch (FileNotFoundException e) {
            System.out.println("Error: words.txt not found");
        }
	}

}
