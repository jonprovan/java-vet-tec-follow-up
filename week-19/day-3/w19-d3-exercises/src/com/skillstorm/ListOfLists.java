package com.skillstorm;

import java.util.Arrays;
import java.util.LinkedList;

public class ListOfLists {

	public static void main(String[] args) {
		// A LIST OF LISTS IN JAVA
		
		/*
		 * just like Arrays, various List classes (ArrayList, LinkedList, etc.) can hold other lists
		 * 
		 * we access their indices and/or loop through them the same as with multi-dimensional arrays
		 */
		
		// creating a container list to hold other lists
		// for its type, we give it the type of the list to hold, not just the eventual data type
		LinkedList<LinkedList<Character>> container = new LinkedList<>();
		
		// creating lists of Characters to go in the container
		LinkedList<Character> chars1 = new LinkedList<>(Arrays.asList('A', 'B', 'C'));
		LinkedList<Character> chars2 = new LinkedList<>(Arrays.asList('D', 'E', 'F'));
		LinkedList<Character> chars3 = new LinkedList<>(Arrays.asList('G', 'H', 'I'));
		
		container.add(chars1);
		container.add(chars2);
		container.add(chars3);
		
		System.out.println(container);
		
		// I cannot add this, because the new list is of the wrong type
		// I can ONLY add LinkedLists of type Character to my container
//		LinkedList<String> strList = new LinkedList<>();
//		container.add(strList);
		
		// looping through and making the chars lowercase
		
		// going through each list in the container list
		for (int i = 0; i < container.size(); i++) {
			
			// going through each Character in one of the inner lists
			for (int j = 0; j < container.get(i).size(); j++) {
				
				// changing each to another character
				container.get(i).set(j, '@');
				
			}
		}
		
		System.out.println(container);

	}

}
