package com.skillstorm;

public class Overriding {

	public static void main(String[] args) {
		
		// METHOD OVERRIDING IN JAVA
		
		/*
		 * overriding REQUIRES inheritance
		 * 
		 * because method overriding is taking a method from a parent class
		 * and altering its functionality in a child class
		 * 
		 * when the method is called, REGARDLESS OF THE REFERENCE TYPE
		 * the method execution is chosen, based on the actual type of the object
		 * 
		 * so, a Dog that inherits from Animal, if it has an overridden method of an Animal method
		 * will always run its own version at runtime
		 * 
		 * THIS DOES NOT APPLY TO STATIC METHODS, only instance methods
		 * 
		 * we must match the exact name and parameters of the overridden method
		 * 
		 * access modifier for the overriding method MUST BE at least as open as the overridden method
		 * so, I can go from protected -> protected OR protected -> public, but NOT protected -> default or private
		 * if I'm overriding more than once, I CANNOT go back to a previous level of access
		 * I MUST continue at the same level or more open
		 * 
		 * there are also some rules about Exceptions (we'll handle these tomorrow)
		 */
		
		// since this is a Food object, it uses the Food class's version of the method
		Food food = new Food();
		food.prepare("Waffles", "Butter");
		
		// since this is a Pizza object, it uses the Pizza class's version of the method
		// REGARDLESS of the reference type (Food, in this case)
		Food pizza = new Pizza();
		pizza.prepare("Sauce", "Cheese");
		
		// same thing here
		Food fakePizza = new FakePizza();
		fakePizza.prepare("Drumsticks", "Coffee");

	}

}

class Food {
	
	void prepare(String ing1, String ing2) {
		System.out.println("Add some " + ing1 + ", then add some " + ing2 + ".");
	}
	
}

class Pizza extends Food {
	
	// this annotation is optional but helpful for clarity
	@Override
	// the names of the parameters don't matter, as long as they're the same type/order/number
	protected void prepare(String ingA, String ingB) {
		System.out.println("Put some " + ingA + " on the dough, then cover it with " + ingB + ".");
	}
	
}

class FakePizza extends Pizza {
	
	@Override
	public void prepare(String fakeIng1, String fakeIng2) {
		System.out.println("Plasticize " + fakeIng1 + " and " + fakeIng2 + ", then display.");
	}
}

class First {
//	public int returnNumber() {
//		return 0;
//	}
	
	public First returnObject() {
		return new First();
	}
}

class Second extends First {
	
	// I cannot have an override with a completely incompatible return type to the parent
//	@Override
//	public short returnNumber() {
//		return 1;
//	}
	
	// I CAN do this, because First and Second are compatible, specifically, a Second IS-A first
	// I CANNOT do this in reverse, because a First IS-NOT-A Second
	// I must have the same return object OR one that is a descendant of the original return object (however many levels away)
	// this is called covariance -- or covariant return types
	@Override
	public Second returnObject() {
		return new Second();
	}
}

class Third extends Second {
	// I CANNOT do this, because a First IS-NOT-A Second
//	@Override
//	public First returnObject() {
//		return new First();
//	}
	
	// I CAN do this
	@Override
	public Third returnObject() {
		return new Third();
	}
}

















