package com.skillstorm;

import java.util.Arrays;

public class ComparableImplementation {

	public static void main(String[] args) {
		
		// COMPARABLE IN JAVA
		
		/*
		 * if a class implements Comparable, we're able to give it its own sorting methodology
		 * 
		 * specifically, we do this by overriding the compareTo() method
		 * 
		 * we can indicate in this method whether an object should go earlier or later in the sorting order
		 * 
		 * as opposed to using a Comparator, this method does not require feeding a separate object into the sort method
		 * 
		 * we're essentially "overriding" the natural sorting order
		 */
		
		// natural sorting order
		int[] nums = { 3, 6, 1, 9, 3 };
		Arrays.sort(nums);
		System.out.println(Arrays.toString(nums));
		
		String[] strings = { "v", "j", "w", "Z", "2" };
		Arrays.sort(strings);
		System.out.println(Arrays.toString(strings));
		
		// what happens with Objects?
		// this throws an Exception, because Object does not implement Comparable
		// this is what would happen with our own objects as well
//		Object[] objs =  { new Object(), new Object(), new Object(), new Object() };
//		Arrays.sort(objs);
//		System.out.println(Arrays.toString(objs));
		
		System.out.println();
		
		// using the Comparable functionality with our new Cake objects
		Cake[] cakes = { new Cake("Red Velvet", 8), new Cake("Carrot", 2), new Cake("Cheese", 0), new Cake("Chocolate Mousse", 6) };
		System.out.println(Arrays.toString(cakes));
		System.out.println();
		// after implementing Comparable, this sort operation uses our compareTo() method to determine the order
		Arrays.sort(cakes);
		System.out.println(Arrays.toString(cakes));
		
		System.out.println();
		
		// we only have one sort method in the class
		// we CAN feed in a lambda directly to sort in another way
		// this is providing a Comparator via a lambda expression, but we can create Comparator objects to store different sorting methods
		Arrays.sort(cakes, (a, b) -> a.type.compareTo(b.type));
		System.out.println(Arrays.toString(cakes));

	}

}

// you must implement the Comparable interface, giving it a type for what you wish to compare it to
class Cake implements Comparable<Cake> {
	
	public String type;
	public int deliciousness;
	
	public Cake(String type, int deliciousness) {
		this.type = type;
		this.deliciousness = deliciousness;
	}

	@Override
	public String toString() {
		return "Cake [type=" + type + ", deliciousness=" + deliciousness + "]";
	}

	// you must override this method, which returns some int when comparing this Cake to another Cake
	// YOU ONLY GET ONE compareTo() METHOD!
	// if you wish to use different sorting methods at different times, you must use a Comparator instead
	@Override
	public int compareTo(Cake otherCake) {
		
		// if the cake we're looking at has a higher deliciousness value, move it earlier in the list
		// returning a negative number of any kind will move the item you're looking at earlier
		// returning a positive number of any kind will move it later
		// returning zero will keep them in the same position
		return otherCake.deliciousness - this.deliciousness;
	}
	
	
	
}





