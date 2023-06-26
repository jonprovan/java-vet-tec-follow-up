package com.other;

import com.skillstorm.Animal;

public class Dog extends Animal {
	
	public String type;
	
	public Dog(String name, String category, String type) {
		// call to super-constructor must come first
		super(name, category);
		this.type = type;
		
		this.category = "Fish";
	}

	public static void main(String[] args) {
		
		Dog myDog = new Dog("Fido", "Mammal", "Canine");
		
		// can do this because name is public
		System.out.println(myDog.name);
		
		// can do this because category is protected and I'm still in the same class
		System.out.println(myDog.category);
		
		

	}

}
