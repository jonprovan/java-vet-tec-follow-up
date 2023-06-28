package com.skillstorm;

public class StaticOverrides {

	public static void main(String[] args) {

		// OVERRIDING STATIC METHODS
		
		/*
		 * Punchline: you can't.
		 * 
		 * Static methods don't get overridden like instance methods
		 * Because they're being baked in at compile-time, not runtime
		 * 
		 * The classes exist separate from one another
		 * The instances are contained "within" one another, but the classes themselves have little relation
		 */
		
		Top top = new Top();
		Middle middle = new Middle();
		Bottom bottom = new Bottom();
		
		// standard overriding results
		top.instanceSpeak();
		middle.instanceSpeak();
		bottom.instanceSpeak();
		
		System.out.println();
		
		// this works the same, regardless of casting
		Top top2 = new Bottom();
		
		top2.instanceSpeak();
		
		System.out.println();
		
		// this does not work with static methods
		// the reference type, NOT the instance type, is what's used to determine which static method to run
		Top top3 = new Bottom();
		
		top3.staticSpeak();
		// what's basically happening is that the compiler takes the reference type
		// and "replaces" top3 with Top to determine the static method to run
		
		System.out.println();
		
		// this is confusing, so I shouldn't call it like this; instead, I should say:
		Top.staticSpeak();
		Middle.staticSpeak();
		Bottom.staticSpeak();
		
	}

}

class Top {
	
	public void instanceSpeak() {
		System.out.println("Instance Top");
	}
	
	public static void staticSpeak() {
		System.out.println("Static Top");
	}
}

class Middle extends Top {
	
	public void instanceSpeak() {
		System.out.println("Instance Middle");
	}
	
	public static void staticSpeak() {
		System.out.println("Static Middle");
	}
	
}

class Bottom extends Middle {
	
	public void instanceSpeak() {
		System.out.println("Instance Bottom");
	}
	
	public static void staticSpeak() {
		System.out.println("Static Bottom");
	}
	
}







