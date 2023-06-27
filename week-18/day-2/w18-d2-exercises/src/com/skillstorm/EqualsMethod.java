package com.skillstorm;

public class EqualsMethod {

	public static void main(String[] args) {
		
		// == vs. the .equals() method in Java
		
		/*
		 * == is great for primitive values
		 * we can directly assess whether, for instance an int variable equals another int variable, etc.
		 */
		
		// using ==
		int intOne = 6;
		int intTwo = 7;
		
		System.out.println(intOne == intTwo);
		System.out.println(intOne != intTwo);
		
		// doesn't work for Objects
		Shape shapeOne = new Shape("Triangle", 3);
		Shape shapeTwo = new Shape("Triangle", 3);
		
		// if I did this, they would in fact be the exact same Shape at the exact same memory location
		// Shape shapeTwo = shapeOne;
		
		// this prints false, because, for Objects, == just compares memory locations
		System.out.println(shapeOne == shapeTwo);
		
		// seeing their memory locations
		System.out.println(shapeOne);
		System.out.println(shapeTwo);
		
		// this prints true, because the String literals are the same
		System.out.println("test" == "test");
		
		// but, this prints false, because the String objects live in different memory locations
		System.out.println(new String("test") == new String("test"));
		
		// this works, because String overrides Object's .equals() method
		System.out.println(new String("test").equals(new String("test")));
		
		// always use .equals() for Strings
		// for our original String comparison, this is better:
		System.out.println("test".equals("test"));
		
		// without overriding Shape's equals method, this returns false (just compares memory locations)
		// after the override, it returns true, because the two properties have equals values
		System.out.println(shapeOne.equals(shapeTwo));
		
		// to fix this, we must override Object's .equals() method in our Shape class
		
		Shape shapeThree = new Shape("Busted Triangle", 3);
		
		System.out.println(shapeOne.equals(shapeThree));
		

	}

}

class Shape {
	public String name;
	public int numberOfSides;
	
	public Shape(String name, int numberOfSides) {
		this.name = name;
		this.numberOfSides = numberOfSides;
	}
	
	@Override
	// must have this signature, because we're overriding Object's .equals method
	public boolean equals(Object obj) {
		
		// if the incoming object is null, return false
		if (obj == null) {
			return false;
		}
		
		// if the incoming object is not a Shape, return false
		if (!(obj instanceof Shape)) {
			return false;
		}
		
		// now that we know the incoming object is a Shape, cast it as a shape
		Shape other = (Shape) obj;
		
		// if the other Shape's properties match our Shape's properties, return true
		if (this.name.equals(other.name) && this.numberOfSides == other.numberOfSides) {
			return true;
		// otherwise, return false
		} else {
			return false;
		}
	}
	
	// you CAN have another .equals method with a different signature
	// watch out on the exams for which .equals method is being called
	public boolean equals(Object obj, int otherValue) {
		return true;
	}
	
	
}













