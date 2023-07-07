package com.skillstorm;

import java.util.Arrays;
import java.util.Comparator;

public class ComparatorImplementation {

	public static void main(String[] args) {
		
		// THE COMPARATOR INTERFACE IN JAVA
		
		/*
		 * Comparator allows us to create a third-party class storing a sorting method for our objects
		 * 
		 * Comparable only allows one sorting method, but we may want multiples we can reuse
		 * 
		 * By creating an instance of our Comparator-implementing object, we can feed it into a sort call
		 * and use that sorting method instead of the natural order or the one defined in our Comparable implementation
		 */
		
		// an array of Coffee objects
		Coffee[] coffees = { new Coffee("Light", "Brazil", 9.99), new Coffee("Dark", "Colombia", 12.99), new Coffee("Medium", "Panama", 10.99) };
		System.out.println(Arrays.toString(coffees));
		
		System.out.println();
		
		// I can't do this, because we didn't implement Comparable
		// Arrays.sort(coffees);
		
		// BUT, I CAN use a Comparator to sort them
		// the second parameter in Arrays.sort() is a Comparator
		// I can feed in a lambda expression or an instance of a Comparator-implementing object
		RoastTypeComparator rtc = new RoastTypeComparator();
		Arrays.sort(coffees, rtc);
		System.out.println(Arrays.toString(coffees));
		
		System.out.println();
		
		// using a different Comparator to sort by origin
		OriginComparator oc = new OriginComparator();
		Arrays.sort(coffees, oc);
		System.out.println(Arrays.toString(coffees));
		
		System.out.println();
		
		// using a different Comparator to sort by costPerPound
		CostComparator cc = new CostComparator();
		Arrays.sort(coffees, cc);
		System.out.println(Arrays.toString(coffees));
		
		System.out.println();
		
		// we can also just create a custom Comparator via a lambda when we run this sort
		// this sorts by alpha order using the second character in the roastType property
		// if you're only sorting this way in one place, you don't need to create an entire Comparator class
		Arrays.sort(coffees, (a, b) -> a.roastType.charAt(1) - b.roastType.charAt(1));
		System.out.println(Arrays.toString(coffees));

	}

}

// we don't need to implement sorting methods in the class itself
class Coffee {
	public String roastType;
	public String origin;
	public double costPerPound;
	
	public Coffee(String roastType, String origin, double costPerPound) {
		super();
		this.roastType = roastType;
		this.origin = origin;
		this.costPerPound = costPerPound;
	}

	@Override
	public String toString() {
		return "Coffee [roastType=" + roastType + ", origin=" + origin + ", costPerPound=" + costPerPound + "]";
	}

}

// this class will be used to sort Coffee object by roastType
// we must implement Comparator and give it a type for the objects we wish to compare
class RoastTypeComparator implements Comparator<Coffee> {

	// we also must implement the compare() method
	// this takes in two objects, not one, because we're not inside our Coffee class
	@Override
	public int compare(Coffee c1, Coffee c2) {
		
		return c1.roastType.compareTo(c2.roastType);
		
	}
	
}

// a different Comparator to sort by origin
class OriginComparator implements Comparator<Coffee> {

	// sorting by origin instead
	@Override
	public int compare(Coffee c1, Coffee c2) {
		
		return c1.origin.compareTo(c2.origin);
		
	}
	
}

//a different Comparator to sort by costPerPound
class CostComparator implements Comparator<Coffee> {

	// sorting by cost instead
	@Override
	public int compare(Coffee c1, Coffee c2) {
		
		// doing this a different way, because we're dealing with doubles and may end up with a false 0 value
		if (c1.costPerPound > c2.costPerPound)
			return 1;
		else if (c1.costPerPound < c2.costPerPound)
			return -1;
		else
			return 0;
	}
	
}






