package com.yetanother;

import com.other.Dog;

public class AnimalTest {

	public static void main(String[] args) {
		
		Dog myDog = new Dog("Fido", "Mammal", "Canine");
		
		// don't have access to this here
		// you would think we would, but the Dog class is not what's trying to access this variable
		// it's the class we're in (AnimalTest), which is neither in the same package as Animal or a subclass of Animal
		
		// System.out.println(myDog.category);

	}

}
