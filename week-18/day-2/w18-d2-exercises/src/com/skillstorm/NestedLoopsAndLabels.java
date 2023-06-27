package com.skillstorm;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Scanner;

public class NestedLoopsAndLabels {

	public static void main(String[] args) {

		// NESTED LOOPS AND LABELS IN JAVA
		
		/*
		 * a nested loop is, simply, a loop inside another loop
		 * 
		 * for each iteration of the "outer" loop, the "inner" loop will fully execute
		 * 	- of course, we can add other conditions, including break/continue statements, to change this
		 */
		
		int counter = 1;
		
		// our outer loop
		for (int i = 0; i < 3; i++) {
			
			System.out.println("Iteration " + (i + 1) + " of outer loop\n****");
			
			// our inner loop
			// every time this loop finishes and starts again with the next iteration of the outer loop,
			// j stops existing and a new j is created with an initial value of 0
			for (int j = 0; j < 3; j++) {
				System.out.println("Iteration " + (j + 1) + " of inner loop");
				System.out.println(counter++);
			}
			
			System.out.println("*****\n");
			
		}
		
		System.out.println();
		
		// creating three LinkedLists of Strings with band members' names
		LinkedList<String> bandOne = new LinkedList<>(Arrays.asList("Ben Folds", "Darren Jesse", "Robert Sledge"));
		LinkedList<String> bandTwo = new LinkedList<>(Arrays.asList("Eddie Vedder", "Matt Cameron", "Stone Gossard", "Jeff Ament", "Mike McCready", "Boom Gaspar"));
		LinkedList<String> bandThree = new LinkedList<>(Arrays.asList("Taylor Hanson", "Isaac Hanson", "Zac Hanson"));
		
		// creating a master LinkedList holding the other three LinkedLists
		LinkedList<LinkedList<String>> bands = new LinkedList<>(Arrays.asList(bandOne, bandTwo, bandThree));
		
		// outer loop executes for each LinkedList<String> in the LinkedList
		for (LinkedList<String> band : bands) {
			// inner loop executes for each String in the LinkedList
			for (String member : band) {
				if (member.length() > 12)
					continue;
				if (member.charAt(0) == 'B')
					break;
				System.out.println(member);
			}
		}
		
		System.out.println();
		
		// HOW TO USE LOOP LABELS
		
		// the label comes before the loop declaration (required), on the same line (conventionally)
		// convention is all-caps, but not required
		// don't use any keywords
		// you can label something that's not a loop without a compiler error
		// BUT, if you try to break/continue that label, you'll throw an error
		OUTER: for (int i = 0; i < 5; i++) {
			
			System.out.println("\nOUTER LOOP INDEX = " + i);
			
			INNER: for (int j = 0; j < 5; j++) {
				
				System.out.println("Inner loop index = " + j);
				
				if (i == 3) {
					break INNER;
				}
				
				if (j == 2) {
					continue OUTER;
				}
			}
			
		}
		
		// using a do-while loop with Scanner and text input
		
		Scanner scan = new Scanner(System.in);
		
		String input;
		
		do {
			System.out.println("Please type the letter 'y':");
			input = scan.nextLine().trim().toLowerCase();
		} while (!(input.equals("y")));
		
		System.out.println("Thank you!");
		

	}

}
