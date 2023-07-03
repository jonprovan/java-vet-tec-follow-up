package com.skillstorm;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class ListSpeedTest {

	public static void main(String[] args) {
		
		// ARRAYLIST VS. LINKEDLIST SPEED TEST
		
		/*
		 * the objective is to see how much longer it takes to insert/remove items in the ArrayList
		 * 
		 * to do this, we'll use the exact same methods, inserting/removing items at the beginning of each collection
		 */
		
		// first, let's create one of each, using the same reference type
		List<Long> al = new ArrayList<>();
		List<Long> ll = new LinkedList<>();
		
		long length = 300000;
		long duration = 0;
		
		duration = System.nanoTime();
		
		for (long i = 0; i < length; i++) {
			al.add(0, i);
		}
		
		for (long i = 0; i < length; i++) {
			al.remove(0);
		}
		
		duration = System.nanoTime() - duration;
		long durationTemp = duration;
		
		System.out.println("Time to insert " + length + " items at index 0, then remove them from index 0 (ArrayList):");
		
		System.out.println((double)duration/1000000000 + " seconds");
		
		duration = System.nanoTime();
		
		for (long i = 0; i < length; i++) {
			ll.add(0, i);
		}
		
		for (long i = 0; i < length; i++) {
			ll.remove(0);
		}
		
		duration = System.nanoTime() - duration;
		
		System.out.println("\nTime to insert " + length + " items at index 0, then remove them from index 0 (LinkedList):");
		
		System.out.println((double)duration/1000000000 + " seconds");
		
		System.out.println("\nTime savings:");
		
		System.out.println(1 - (double)duration/durationTemp + "%");

	}

}
