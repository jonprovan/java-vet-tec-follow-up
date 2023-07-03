package com.skillstorm;

public class ArraysInJava {

	public static void main(String[] args) {
		
		// ARRAYS IN JAVA
		
		/*
		 * an array is a collection of items in contiguous memory
		 * 
		 * you can store primitives OR objects in an array, unlike other collections where you can only store objects
		 * 
		 * they are 0-indexed, meaning the first item in the array is at index 0
		 * 
		 * they are a fixed size -- once your array size is set, you cannot change it
		 * 		- if you want your values to be in a larger array, you have to create a new array and copy over the values
		 * 
		 */
		
		// instantiating arrays
		
		// creating an array of type int
		
		// preferred declaration
		// this declares an int[] with no instantiated size
		int[] nums;
		
		// still works, but not preferred
		int nums2[];
		// confusing, because the reference type appears to be int, but it's not, so this doesn't work
		// nums2 = 6;
		
		// giving our array a size
		// this declares a variable for an int[] and creates a new one with size 5
		int[] nums3 = new int[5];
		
		// can also use an array literal
		// this declares the size AND fills the array with values
		int[] nums4 = { 5, 7, 123, 99, 14 };  // 5 is at index 0, 99 is at index 3, etc.
		
		// filling in values for our nums3 array
		nums3[0] = 12;
		nums3[1] = 44;
		nums3[2] = -5;
		nums3[3] = 999;
		nums3[4] = -50145;
		
		// finding the length of our array
		// note that .length is a property for arrays in Java, not a method, like LinkedList's .size()
		System.out.println(nums4.length);
		
		System.out.println();
		
		// what values does an array start with, if we don't give it any values?
		
		// can't do this, because it hasn't been initialized
		// System.out.println(nums[0]);
		
		int[] nums5 = new int[5];
		
		// instantiated arrays without values provided are given Java primitive default values
		System.out.println(nums5[0]);
		
		boolean[] bools = new boolean[3];
		System.out.println(bools[2]);
		
		String[] strs = new String[7];
		System.out.println(strs[4]);
		
		// you can ONLY use an array literal to instantiate an array
		// you CANNOT use an array literal to assign a new value to array
		// EVEN IF the number of slots is the same
		
		// so, I can't do this
		// nums4 = { 1, 2, 3, 4, 5 };
		
		// I CAN null it out...
		nums4 = null;
		// but I can't go back and do this, even after that
		// nums4 = { 1, 2, 3, 4, 5 };
		
		// this doesn't bring up a checked Exception...
		// ...but it throws an ArrayIndexOutOfBoundsException at runtime (a RuntimeException)
		// System.out.println(nums3[5]);
		
		// additionally, you have to be sure you're not calling methods, etc. on null values inside the array
		// when you're using an array of objects
		
		strs[0] = "Hello, World!";
		// I CAN do that...
		System.out.println(strs[0].charAt(0));
		// ...but, if I do this, I throw a NullPointerException, because the value at slot 1 is null
		// so I'm trying to run a method on a null object
		// this is an unchecked RuntimeException as well, so the compiler won't alert you
		// System.out.println(strs[1].charAt(0));
		
		// if you're using loops to go through your arrays, be sure to include some sort of null check to avoid this problem
		
		System.out.println();
		
		// arrays are iterable, meaning we can go through them item by item, including using the enhanced for loop
		
		Game[] games = { new Game("Zaxxon"), new Game("The Adventures of Dino-Riki"), new Game("Jackal"), null, new Game("Rocketbirds") };
		
		// this requires a null check, because we have a null Game, so we throw an Exception
		for (Game game : games) {
			if (game != null)
				System.out.println(game.getName());
			else
				System.out.println("This Game is null!");
		}
		
		System.out.println();
		
		// creating a new array with values from our original array
		// easier with a standard for loop, because we have access to the index values
		String[] gameNames = new String[games.length];
		
		for (int i = 0; i < games.length; i++) {
			if (games[i] != null)
				gameNames[i] = games[i].getName();
			else
				gameNames[i] = "Name not provided!";
		}
		
		for (String name : gameNames) {
			System.out.println(name);
		}
		
		

	}

}

class Game {
	public String name;
	
	public Game(String name) {
		this.name = name;
	}
	
	public String getName() {
		return this.name;
	}
}


