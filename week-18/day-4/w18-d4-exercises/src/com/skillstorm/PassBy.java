package com.skillstorm;

import java.util.Arrays;
import java.util.LinkedList;

public class PassBy {
	
	public static void main(String[] args) {
		
		// PASS-BY-VALUE vs. PASS-BY-REFERENCE IN JAVA
		
		/*
		 * in a general sense, when we pass a primitive into a method, Java passes the value of that primitive
		 * and, when we pass an object of any type into a method, Java passes the reference to that object
		 * 
		 * value = the actual primitive value (e.g. 6 for int a = 6 or 'F' for char f = 'F', etc.)
		 * 		-- NOT the variable itself or a reference to the variable
		 * 
		 * reference = the memory location of the object
		 * 		-- NOT the "value" of the object or the object itself
		 */
		
		// this creates a variable reference called myInt, and its value is 10
		double myInt = 10;
		
		// we might expect that myInt would change to 100.0
		squareInt(myInt);
		
		// ...but it has stayed the same
		// since myInt is a primitive, we only passed the VALUE of the variable, NOT the reference
		System.out.println(myInt);
		
		// to actually change the value of myInt, we need to do this:
		myInt = squareInt2(myInt);
		
		System.out.println(myInt);
		
		Object obj = new Object();
		
		System.out.println(obj);
		
		// this ALSO does not change the original obj object, even though we "null it out" in the method
		// it still only affects the local variable
		negateObject(obj);
		
		System.out.println(obj);
		
		System.out.println();
		
		PandorasBox panBo = new PandorasBox();
		
		System.out.println(panBo.size);
		for (String content : panBo.contents)
			System.out.println(content);
		
		openTheBox(panBo);
		
		System.out.println(panBo.size);
		for (String content : panBo.contents)
			System.out.println(content);
		
		System.out.println();
		
		LinkedList<String[]> groceries = new LinkedList<>();
		
		String[] fruits = { "Apples", "Oranges", "Pears" };
		String[] veggies = { "Celery", "Sprouts", "Kale" };
		String[] dairy = { "Milk", "Cheese", "Yogurt" };
		
		groceries.add(fruits);
		groceries.add(veggies);
		groceries.add(dairy);
		
		System.out.println(groceries);
		
		// this doesn't actually change anything
		// innermost loop includes a passed value and a local variable reassignment, NOT an Object property change
		changeGroceries(groceries);
		
		System.out.println(groceries.get(0)[0]);
		

	}
	
	// once a primitive value gets passed in, its value becomes the value of the local variable x
	// at this point, there's no longer ANY connection to the original variable
	public static void squareInt(double x) {
		// this ONLY changes the value of the local variable, NOT the original one
		x = Math.pow(x, 2);
	}
	
	public static double squareInt2(double x) {
		return Math.pow(x, 2);
	}
	
	public static void negateObject(Object o) {
		// o here has nothing to do with the original obj reference
		// it just happens to contain the reference to the same object in the heap
		// nulling it out just removes the reference to that object from the local variable o
		o = null;
	}
	
	public static void openTheBox(PandorasBox pb) {
		pb.size = "XS";
		pb.contents[2] = "More and More Mysteries";
	}
	
	// groc is a reference to an object (LinkedList of String[]s)
	public static void changeGroceries(LinkedList<String[]> groc) {
		// dept is a reference to an object (String[])
		for (String[] dept : groc) {
			// item is a reference to a value (String literal)
			// so, when we change it, we're just pointing to a different value
			// NOT altering the original
			for (String item : dept) {
				item = item.toUpperCase();
			}
		}
			
	}

}

class PandorasBox {
	public String size = "XL";
	public String[] contents = { "Pain", "Suffering", "Infinite Wisdom" };
}




