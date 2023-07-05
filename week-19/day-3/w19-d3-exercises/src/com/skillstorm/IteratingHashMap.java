package com.skillstorm;

import java.util.Arrays;
import java.util.HashMap;

public class IteratingHashMap {

	public static void main(String[] args) {
		
		// ITERATING OVER HASHMAP IN JAVA
		
		/*
		 * HashMap (and really, Map in general) DOES NOT descend in any way from Iterable, so we can't iterate its contents
		 * 
		 * we need to extract the keys and/or values in order to iterate over the contents
		 */
		
		HashMap<String, Integer> myMap = new HashMap<>();
		
		// I cannot do this, because HashMap is not iterable
//		for (Integer i : myMap) {
//			System.out.println(i);
//		}
		
		HashMap<Integer, String> students = new HashMap<>();
		
		students.put(12, "Nicolas");
		students.put(2, "Jon");
		students.put(345, "LeeRoy");
		students.put(104, "Shentill");
		students.put(566, "Sarah");
		
		// iterating over just the values
		// .values() returns an iterable collection of the map's values ONLY (no keys)
		for (String s : students.values()) {
			System.out.println(s);
		}
		
		System.out.println();
		
		// iterating over just the keys
		// .keySet() returns a set of the keys from the map
		for (Integer i : students.keySet()) {
			System.out.println(i);
		}
		
		System.out.println();
		
		// to get the values also, we can iterate over the keys and then use them
		for (Integer i : students.keySet()) {
			System.out.println("Key: " + i + ", Value: " + students.get(i));
		}
		
		System.out.println();
		
		// to get them into some sort of order first
		Object[] keys = students.keySet().toArray();
		Arrays.sort(keys);
		
		for (Object o : keys) {
			System.out.println("Key: " + o + ", Value: " + students.get(o));
		}
		

	}

}
