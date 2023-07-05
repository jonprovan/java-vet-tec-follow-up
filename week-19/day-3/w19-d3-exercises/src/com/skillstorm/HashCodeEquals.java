package com.skillstorm;

import java.util.Objects;

public class HashCodeEquals {

	public static void main(String[] args) {
		
		// THE HASHCODE/EQUALS CONTRACT IN JAVA
		
		/*
		 * to properly resolve this contract, we need to remember two things:
		 * 
		 * two equal objects MUST return the same hashcode
		 * BUT, two unequal objects CAN STILL return the same hashcode
		 * 
		 */
		// these two Strings are not equal, but they return the same hashcode = OKAY
		System.out.println("Aa".equals("BB"));
		System.out.println("Aa".hashCode());
		System.out.println("BB".hashCode());
		
		// these two Objects are not equal and do not return the same hashcode = OKAY
		Object obj1 = new Object();
		Object obj2 = new Object();
		System.out.println(obj1.equals(obj2));
		System.out.println(obj1.hashCode());
		System.out.println(obj2.hashCode());
		
		// these two object are now equal (same object) and return the same hashcode = OKAY
		obj1 = obj2;
		System.out.println(obj1.equals(obj2));
		System.out.println(obj1.hashCode());
		System.out.println(obj2.hashCode());
		
		System.out.println();
		
		// dealing with our Compliance objects
		Compliance c1 = new Compliance("Marianne");
		Compliance c2 = new Compliance("Marianne");
		
		// without overriding Object's .equals() method, this returns false
		System.out.println(c1.equals(c2));
		
		// without overriding Object's .hashCode() method, these return different hashcodes
		// which is illegal under the contract -- if they're equal, they MUST return the same hashcode
		System.out.println(c1.hashCode());
		System.out.println(c2.hashCode());

	}

}

// to get this to comply, we need to override Object's .equals() and .hashCode() methods
class Compliance {
	
	public String name;
	
	public Compliance(String name) {
		this.name = name;
	}

	// to solve the problem of two identical-seeming objects coming up not equal, we override .equals() to look at the properties
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Compliance other = (Compliance) obj;
		return Objects.equals(name, other.name);
	}
	
	// hashing the same String returns the same exact hashcode, so this solves the second part of the problem
	@Override
	public int hashCode() {
		return Objects.hash(name);
	}

	
	
	
	
	
}










