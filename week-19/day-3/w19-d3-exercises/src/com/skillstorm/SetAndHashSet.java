package com.skillstorm;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class SetAndHashSet {

	public static void main(String[] args) {

		// SET AND HASHSET IN JAVA
		
		/*
		 * a Set is an interface describing a collection that DOES NOT allow duplicates
		 * 
		 * we cannot instantiate it directly, so we are going to use a HashSet object
		 * 
		 * HashSet is backed by a HashMap under the hood
		 * 
		 * so, to properly use a Set, we need to make sure we've overridden our .equals() method
		 * without doing this, we could add two practically equal items and end up with (essential) duplicates
		 * 
		 * a few methods are a little different than previous collections
		 * 
		 */
		
		// instantiating a Set using HashSet
		// cannot create a Set directly, since it's an interface
		Set<String> movies = new HashSet<>();
		
		movies.add("Star Wars: The Last Jedi");
		movies.add("Dead Alive");
		movies.add("The Menu");
		
		// when adding a String successfully, I get back true
		System.out.println(movies.add("Frownland"));
		
		System.out.println(movies);
		
		// but, if I add a String that's already in there...
		// ... I get false
		System.out.println(movies.add("Frownland"));
		
		System.out.println(movies);
		
		// to remove a String, we need the String itself -- there are no indices or keys to use
		movies.remove("Frownland");
		
		System.out.println(movies);
		
		// if I remove a String successfully, I get back true; otherwise, I get false
		System.out.println(movies.remove("Dead Alive"));
		System.out.println(movies.remove("Bee Movie"));
		
		// because it's the best movie of all time...
		movies.add("Dead Alive");
		
		// we also have .size(), .contains(Object o), and other typical stuff
		
		System.out.println();
		
		// testing out the necessity for overriding hashCode/equals
		Set<SetTest> mySet = new HashSet<>();
		
		SetTest st1 = new SetTest("Frodo");
		SetTest st2 = new SetTest("Sam");
		SetTest st3 = new SetTest("Sam");
		
		mySet.add(st1);
		mySet.add(st2);
		mySet.add(st3);
		
		// without fixing our class, we're allowed to add st3, even though it's equal to st2
		// and, when we search the set for st3 after only adding st1 and st2, it returns false
		System.out.println(mySet);
		System.out.println(mySet.contains(st3));
		
	}

}

class SetTest {
	public String name;
	
	public SetTest(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "SetTest [name=" + name + "]";
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
		SetTest other = (SetTest) obj;
		return Objects.equals(name, other.name);
	}
	
	
}
