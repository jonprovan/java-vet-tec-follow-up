package com.skillstorm;

import java.util.HashMap;
import java.util.Objects;

public class HashMaps {

	public static void main(String[] args) {
		
		// HASHMAPS IN JAVA
		
		/*
		 * a HashMap is a collection that stores items via key-value pairs
		 * 
		 * each item stored has a value = whatever it is we want to store (String, Integer, object, collection, etc.)
		 * 
		 * each item also has a key = what we will give to the HashMap in order to retrieve a value
		 * 
		 * For instance:
		 * 		KEY			VALUE
		 * 		1			"Chicago Bulls"
		 * 		2			"Boston Celtics"
		 * 		3			"LA Lakers"
		 * 
		 * HashMaps run in constant time (essentially), meaning very fast access to values
		 * 
		 * When you exceed the storage capacity of the Map, it actually creates internal LinkedLists at each key to store additional values
		 */
		
		// when instantiating a HashMap, we must give it a type for the key AND a type for the value
		// in this case, we're going to use a String for the key and an Integer for the value
		// these types must be objects, NOT primitives
		HashMap<String, Integer> inventory = new HashMap<>();
		
		// adding items to our HashMap using .put()
		// each of these creates a new String key in the HashMap with an associated Integer value
		inventory.put("Balloon", 100);
		inventory.put("Car Door", 7);
		inventory.put("Dishtowel", 45);
		inventory.put("Coaster", 554);
		
		// getting items using the key with .get()
		System.out.println(inventory.get("Dishtowel"));
		
		// values are just returned, not removed, etc.
		// we must store them to reuse them
		int x = inventory.get("Coaster");
		System.out.println("Coasters Remaining: " + x);
		
		// what happens if I put a new value in with the same key?
		inventory.put("Coaster", 12);
		
		// the value at key "Coaster" gets replaces with the new value
		System.out.println(inventory.get("Coaster"));
		
		// finding out the hashcode
		System.out.println("Coaster".hashCode());
		
		// getting the size with .size()
		// this returns the total number of entries in the HashMap
		System.out.println(inventory.size());
		
		// removing an entry with .remove()
		inventory.remove("Balloon");
		System.out.println(inventory.get("Balloon"));
		
		// removing an entry ONLY IF the key AND value match
		inventory.remove("Car Door", 90);
		System.out.println(inventory.get("Car Door"));
		
		// checking if the HashMap contains a certain key
		System.out.println(inventory.containsKey("Cheese Wheel"));
		
		// checking if the HashMap contains a certain value
		System.out.println(inventory.containsValue(7));
		
		
		// uncovering a problem with hashCode()/equals()
		
		HashMap<Violator, Integer> badMap = new HashMap<>();
		
		Violator vOne = new Violator("Doug");
		Violator vTwo = new Violator("Larry");
		Violator vThree = new Violator("Larry");
		
		badMap.put(vOne, 99);
		badMap.put(vTwo, 100);
		
		System.out.println(badMap.get(vOne));
		System.out.println(badMap.get(vTwo));
		System.out.println(badMap.get(vThree));
		
		// we expect to get back 100 on this last line, but we don't...there's a problem with our hashCode()/equals() contract
		// even though vTwo and vThree are, for all intents and purposes, identical, they return a different hashCode()
		// because they're just using Object's hashCode() method, which doesn't take into account any of the properties of our object
		// it basically just looks at the memory address
		
		// now that we've overridden the methods in the Violator class, vTwo and vThree return the same hashcode
		// and thus, we get the right results from the HashMap
		System.out.println(vTwo.hashCode());
		System.out.println(vThree.hashCode());
		
		

	}

}

class Violator {
	
	String name;
	
	public Violator(String name) {
		this.name = name;
	}

	@Override
	public int hashCode() {
		return Objects.hash(name);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Violator other = (Violator) obj;
		return Objects.equals(name, other.name);
	}
	
}
