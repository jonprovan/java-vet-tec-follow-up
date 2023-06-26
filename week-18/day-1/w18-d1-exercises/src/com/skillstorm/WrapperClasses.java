package com.skillstorm;

import java.util.ArrayList;
import java.util.LinkedList;

public class WrapperClasses {

	public static void main(String[] args) {
		
		// WRAPPER CLASSES
		
		/*
		 * in some instances, we can't use primitives, only objects
		 * 
		 * arrays can hold primitives, but other collections (ArrayList, LinkedList, etc.) cannot
		 * 
		 * we have to bundle our primitives into objects, so we can use them
		 */
		
		// note the required explicit casts for Byte and Short, but not for Integer and Long
		Byte myByte = new Byte((byte)123);
		Short myShort = new Short((short)456);
		Integer myInteger = new Integer(78901);
		Long myLong = new Long(123456789);
		
		ArrayList<Integer> myIntegers = new ArrayList<>();
		
		// values are auto-boxed into Integer objects
		myIntegers.add(1);
		myIntegers.add(2);
		myIntegers.add(3);
		
		// we can see that the class of the object actually added was Integer, not the int primitive
		System.out.println(myIntegers.get(0).getClass());
		
		
		Character myCharacter = new Character('X');
		System.out.println(myCharacter);
		
		LinkedList<Character> myCharacters = new LinkedList<>();
		
		// these get auto-boxed into Character objects
		myCharacters.add('a');
		myCharacters.add('b');
		myCharacters.add('c');
		
		// we can see that the class of the object actually added was Character, not the char primitive
		System.out.println(myCharacters.get(2).getClass());
		
		Boolean myBoolean = new Boolean(true);
		
		System.out.println(myBoolean.getClass());
		
		// the wrapper classes have various methods/properties you can use, since they are classes/objects
		System.out.println(myLong.compareTo(new Long(123456)));
		System.out.println(Long.MAX_VALUE);
		
		Float myFloat = new Float(123.456);
		Double myDouble = new Double(123456.7890123);
		
		
	}

}
