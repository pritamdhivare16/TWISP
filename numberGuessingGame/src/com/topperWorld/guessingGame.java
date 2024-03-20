package com.topperWorld;

import java.util.Random;
import java.util.Scanner;

public class guessingGame {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		Random random = new Random();
		
		
		int minNum = 1;
		int maxNum = 100;
		int correctNum = random.nextInt(maxNum - minNum + 1) + minNum;
		int attempts = 0;
		int maxAttempts = 5;
		
		
		System.out.println("Welcome to Guess Number Game");
		System.out.println("You Will Be Asked to Guess A Number To Win The Game");
		System.out.println("Yor have Maximum 5 Attempt Limit");

		
		while (attempts < maxAttempts) {
			System.out.println("Enter a guess number between 1 to 100");
			int guess = sc.nextInt();
			attempts++;
			
			if(guess == correctNum) {
				System.out.println("OOhhOO! Your Number is Correct. Yoy Win the Game!");
				break;
			} else if(guess < correctNum) {
				System.out.println("Your Guess Number is Smaller");
				
			} else {
				System.out.println("Your Guess Number is Greater");
			}
		}
		
		if (attempts == maxAttempts) {
			System.out.println("You exceeded the limit!!!. the correct number was"+correctNum);
		}
		
		sc.close();
	}

}
