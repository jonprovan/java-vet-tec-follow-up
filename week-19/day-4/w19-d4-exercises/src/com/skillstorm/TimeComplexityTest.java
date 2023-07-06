package com.skillstorm;

import java.util.ArrayList;
import java.util.LinkedList;

public class TimeComplexityTest {

	public static void main(String[] args) {
		
		// TIME COMPLEXITY IN JAVA
		
		/*
		 * time complexity refers to the amount of time an algorithm will take
		 * 
		 * BIG O NOTATION -- the worst-case scenario
		 * BIG OMEGA NOTATION -- the best-case scenario
		 * BIG THETA NOTATION -- the expected scenario (in general)
		 * 
		 * we are going to test this with getting items from a LinkedList vs. an ArrayList
		 * for our insertion test, the LinkedList was MUCH faster
		 * for this one, we expect the ArrayList to be faster
		 */
		
		// change this to change the size of each collection
		int size = 100000;
		
		// holders for time calculations
		long time;
		long duration;
		long durationTemp;
		
		// creating two collections to test
		ArrayList<Integer> al = new ArrayList<>();
		LinkedList<Integer> ll = new LinkedList<>();
		
		// inserting values into each collection
		for (int i = 0; i <= size; i++) {
			al.add(i);
			ll.add(i);
		}
		
		time = System.nanoTime();
		
		// getting the middle element from the ArrayList many times
		for (int i = 0; i <= size; i++) {
			al.get(i/2);
		}
		
		duration = System.nanoTime() - time;
		durationTemp = duration;
		
		System.out.println("Getting " + size + " elements from the middle of an ArrayList...");
		System.out.println("Time: " + (double)duration/1000000000 + " seconds");
		System.out.println();
		
		time = System.nanoTime();
		
		// getting the middle element from the LinkedList many times
		for (int i = 0; i <= size; i++) {
			ll.get(i/2);
		}
		
		duration = System.nanoTime() - time;
		
		System.out.println("Getting " + size + " elements from the middle of a LinkedList...");
		System.out.println("Time: " + (double)duration/1000000000 + " seconds");
		System.out.println();
		
		System.out.println("Percentage Savings Using ArrayList: " + (1 - (double)durationTemp/duration)*100 + "%");
	}

}








