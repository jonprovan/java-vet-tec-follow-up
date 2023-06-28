package com.skillstorm;

public class IsAHasA {

	public static void main(String[] args) {
		
		// IS-A vs. HAS-A in JAVA
		
		/*
		 * an IS-A relationship describes how a child object IS-A parent object as well
		 * 
		 * for instance, if we have a Cup class that inherits from a DrinkingVessel class
		 * 		the Cup object IS-A DrinkingVessel as well
		 * 
		 * for this reason, we can group multiple child objects into Collections of parent objects
		 *   for collective processing, organization, etc.
		 *   
		 *   
		 * a HAS-A relationship describes when an object has another object as one of its properties
		 * 
		 * we're technically doing this already whenever we use String as a property
		 * but usually, we're talking about other, user-created objects in this context
		 * 
		 */
		
		DrinkingVessel dv = new DrinkingVessel();
		Cup cup = new Cup();
		WaterFlask wf = new WaterFlask();
		
		// without inheritance, I can't do this
		// BUT, since these three are ALL DrinkingVessels, I can include them in the same collection
		DrinkingVessel[] dva = { dv, cup, wf };
		
		dv.sayType();
		cup.sayType();
		wf.sayType();
		
		System.out.println();
		
		// can call the same method on each via a loop, and it overrides
		
		// I CANNOT do this, because the loop is thinking of the items as Objects, and Object doesn't have this method
		// it looks to Object first, because that's the reference type, and it doesn't find what it's looking for
//		for (Object drve : dva) {
//			drve.sayType();
//		}
		
		// I CAN do this, because the parent class has the appropriate method
		for (DrinkingVessel drve : dva) {
			drve.sayType();
		}
		
		
		// using our Dryer class with its private Filter
		Dryer dryer = new Dryer();
		
		// I can't do this
		// the Filter class is hidden inside the Dryer class, so I can't instantiate it
		// Filter filter = new Filter();
		
		// I can still get to the created Filter
		System.out.println(dryer.filter);
		
		// I can even still get to the one created right after creating a new Dryer
		// but I can't create a Filter on its own
		System.out.println(new Dryer().filter);

	}

}

// a DrinkingVessel IS-AN Object
class DrinkingVessel {
	
	public void sayType() {
		System.out.println("DrinkingVessel");
	}
	
}

// a Cup IS-A DrinkingVessel and also IS-AN Object
class Cup extends DrinkingVessel {
	
	public void sayType() {
		System.out.println("Cup");
	}
	
}

//a WaterFlask IS-A DrinkingVessel and also IS-AN Object
class WaterFlask extends DrinkingVessel {
	
	public void sayType() {
		System.out.println("WaterFlask");
	}
	
}

// HAS-A EXAMPLES

class Jet {
	
	// properties
	public String name; // technically a HAS-A, but that's not really what we mean
	
	// the Jet HAS-AN Engine as one of its properties
	public Engine engine = new Engine();
	
	// the Jet also HAS-AN array of Wing objects as another of its properties
	public Wing[] wings = { new Wing(), new Wing() };
	
	// the existence of the Jet is dependent upon the existence of Engine and Wing objects
	// BUT, the Jet does not inherit from the Engine/Wing classes in any way
	// nor do the Engine/Wing objects inherit from the Jet class in any way
	
	
}

class Engine {
	
}

class Wing {
	
}

// using inner classes to prevent the instantiation of HAS-A objects
// perhaps we don't want to be able to create a Filter without a Dryer to hold it

class Dryer {
	
	// the Dryer HAS-A Filter
	// since the Filter is a private inner class, we can't instantiate it anywhere except from the Dryer class
	public Filter filter = new Filter();
	
	// an inner class
	private class Filter {
		
	}
	
}



















