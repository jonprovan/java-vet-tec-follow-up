package com.skillstorm;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ArrayLists {

	public static void main(String[] args) {
		
		// ARRAYLISTS IN JAVA
		
		/*
		 * ArrayList is a class in the Java Collections Framework that implements the List interface
		 * 
		 * under the hood, it is an array, BUT, unlike a regular array, ArrayList will resize if you exceed the current capacity
		 * 
		 * when this happens, a new underlying array is created, and the values are copied over into the new array
		 * 
		 * ADVANTAGES:
		 * 		constant-time access to items in the ArrayList (like an array)
		 * 		no manual management of size
		 * 
		 * DISADVANTAGES:
		 * 		time lost when resizing
		 * 		insertion/removal anywhere except the end requires copying over all items after the insertion/removal point
		 */
		
		// we CANNOT instantiate a List object directly, because it's an interface
		// can't do this:
		
		// List<String> myList = new List<>();
		
		// but I can use List as a reference type for ArrayList, OR use the ArrayList type directly
		List<String> myOtherList = new ArrayList<>();
		ArrayList<String> myAdditionaList = new ArrayList<>();
		
		// what does <String> mean?
		// the class in the <> gives the reference variable a type
		// meaning, it tells us what kind(s) of objects the collection is allowed to hold
		// Collections CANNOT hold primitives! They must use objects of some sort
		// if you want to hold primitive values, you have to use wrapper classes
		
		// must use Integer instead of int
		ArrayList<Integer> myIntList = new ArrayList<>();
		
		// this auto-boxes into an Integer
		// the .add method adds an item AT THE END
		myIntList.add(123);
		
		// can't do this, because it's not a number
		// myIntList.add("test");
		
		// this auto-boxes into a Short, which doesn't match
		// myIntList.add((short)123);
		
		myIntList.add(4);
		myIntList.add(234);
		myIntList.add(-23);
		myIntList.add(55);
		myIntList.add(11111);
		myIntList.add(-9876);
		
		for (Integer i : myIntList) {
			System.out.println(i);
		}
		
		// this gives us the current number of items in the ArrayList
		System.out.println(myIntList.size());
		
		// but this is not the total current capacity, i.e., how many items it CAN hold without resizing
		
		// this, however, trims the capacity to the current size
		// in our case, this trims the underlying array to one of size 7
		// this method is only available with a reference type of ArrayList, since it doesn't exist in List
		myIntList.trimToSize();
		
		// but, we can still add, and it expands the underlying array
		myIntList.add(432);
		
		System.out.println(myIntList);
		
		// to insert at a specific index
		// inserts 0 at index 3
		myIntList.add(3, 0);
		
		System.out.println(myIntList);
		
		// .set() REPLACES the value at a specific index
		// replaces index 3 with 555
		myIntList.set(3, 555);
		
		System.out.println(myIntList);
		
		// .contains() tells us if a value is anywhere within our ArrayList
		// returns true if it does, false if it doesn't
		System.out.println(myIntList.contains(11111));
		System.out.println(myIntList.contains(-11111));
		
		// can also search for multiple values with .containsAll()
		List<Integer> searchList = new ArrayList<>(Arrays.asList(123, 55, 432));
		System.out.println(myIntList.containsAll(searchList));
		
		// .indexOf(x) returns the index for the value in the parentheses
		// this tells us that 234 is at index 2
		System.out.println(myIntList.indexOf(234));
		
		myIntList.add(555);
		
		// two ways to remove an item
		// by index or by value
		myIntList.remove(6);
		
		System.out.println(myIntList);
		
		// in our case, we must cast this as an Integer; otherwise, it thinks it's an index
		// this removes ONLY THE FIRST instance of the value
		myIntList.remove((Integer)555);
		
		System.out.println(myIntList);
		
		myIntList.add(555);
		System.out.println(myIntList);
		
		// to remove all of them, you'd have to loop
		while (myIntList.indexOf(555) != -1)
			myIntList.remove((Integer)555);
		
		System.out.println(myIntList);
		
		// to clear the ArrayList, use .clear()
		myIntList.clear();
		
		System.out.println(myIntList);

	}

}
