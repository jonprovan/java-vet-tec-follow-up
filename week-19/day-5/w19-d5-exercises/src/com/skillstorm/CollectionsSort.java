package com.skillstorm;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;

public class CollectionsSort {

	public static void main(String[] args) {
		
		// COLLECTIONS.SORT() IN JAVA
		
		/*
		 * Collections.sort() is basically Arrays.sort() but for Lists
		 * 
		 * you can sort a list via natural order, Comparable implementation, a Comparator object, or a lambda expression
		 * 
		 * works for any List, including ArrayList and LinkedList
		 */
		
		// sorting an Integer List via natural order
		ArrayList<Integer> ints = new ArrayList<>(Arrays.asList(3, 8, 1, 2, 11, -3, 300));
		System.out.println(ints);
		
		System.out.println();
		
		Collections.sort(ints);
		System.out.println(ints);
		
		System.out.println();
		
		// our Puppy class has a Comparable implementation, so its "natural order" has been created
		// sorting via Comparable implementation
		LinkedList<Puppy> puppies = new LinkedList<>(Arrays.asList(new Puppy("Labradoodle"), new Puppy("Schnauzer"), new Puppy("Chow")));
		System.out.println(puppies);
		
		System.out.println();
		
		Collections.sort(puppies);
		System.out.println(puppies);
		
		System.out.println();
		
		// sorting via a Comparator
		PuppyComparator pc = new PuppyComparator();
		Collections.sort(puppies, pc);
		System.out.println(puppies);
		
		System.out.println();
		
		// sorting via a lambda expression
		// this is still using a Comparator, we're just providing the implementation to the Functional Interface directly
		Collections.sort(puppies, (a, b) -> b.breed.charAt(2) - a.breed.charAt(2));
		System.out.println(puppies);

	}

}

class Puppy implements Comparable<Puppy> {
	public String breed;
	
	public Puppy(String breed) {
		this.breed = breed;
	}

	@Override
	public String toString() {
		return "Puppy [breed=" + breed + "]";
	}

	@Override
	public int compareTo(Puppy otherPuppy) {
		
		return this.breed.compareTo(otherPuppy.breed);
	}
}

class PuppyComparator implements Comparator<Puppy> {

	@Override
	public int compare(Puppy p1, Puppy p2) {
		
		return p2.breed.compareTo(p1.breed);
	}
	
}










