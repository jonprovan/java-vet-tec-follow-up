package com.skillstorm;

public class Casting {

	public static void main(String[] args) {
		
		// CASTING IN JAVA
		
		/*
		 * in general, we're talking about making the system "think" of a value as a specific type
		 * 
		 * 10, by default, is an int, but we can "cast" it as something else
		 * 
		 * there are limitations to what we can cast, depending on what we're trying to cast
		 * 
		 * IMPLICIT vs. EXPLICIT
		 * -- implicit is when we're not actively saying something is a different type
		 * -- explicit is when we are
		 */
		
		byte myByte = 4;
		
		// implicitly casting the value of myByte as an int
		int myInt = myByte;
		
		myByte = 6;
		
		System.out.println(myInt);
		
		Animalx animal = new Animalx();
		
		// implicitly casting the value of the Animal object created above as an Object
		Object object = animal;
		
		Dog dog = new Dog();
		
		// implicitly casting the Dog object created above as an Animal
		Animalx animal2 = dog;
		Animalx animal3 = new Cat();
		// implicitly casting the Dog object created above as an Object
		Object object2 = dog;
		
		// explicit casting
		// I'm specifically telling my int 10 to be thought of as a byte
		byte myOtherByte = (byte)10;
		
		// explicitly casting the input value as a byte
		testByte((byte)10);
		
		// Java knows that dog is an Animal
		testAnimal(dog);
		
		// since animal2 thinks of itself as an Animal, regardless of the fact that it holds a Dog
		// we must explicitly cast it as a Dog
		testDog((Dog)animal2);
		
		// we cannot do this, because a Cat is not a Dog
		// but Java doesn't quite know that, so we don't throw a checked Exception
		// we instead throw a ClassCastException at runtime
		// testDog((Dog)animal3);

	}

	static void testByte(byte myByte) {
		
	}
	
	static void testAnimal(Animalx myAnimal) {
		
	}
	
	static void testDog(Dog dog) {
		
	}
	
	

}

class Animalx {
	
}

class Dog extends Animalx {
	
}

class Cat extends Animalx {
	
}
