// the order of the file structure items is important
// regular Java comment
/*
 * multi-line Java comment
 * 
 * sometimes, on exams, they'll stick comments in strange spots, so be on the lookout
 */

// package declaration (if there is one) must come FIRST
// imports, if any, come AFTER the package declaration but BEFORE the class(es), etc.

package com.skillstorm;

// if you have multiple imports, it doesn't matter their order
import java.util.Set;
import java.util.ArrayList;

// you can have multiple classes in a file
// one class name MUST match the name of the file
// you can NOT have more than one public class
// you do NOT have to have a public class
// BUT, if you do, it MUST be the one whose name matches the name of the file
public class Primitives {

	public static void main(String[] args) {
		
		// PRIMITIVES IN JAVA
		
		/*
		 * Whole number primitives (non-decimal, non-fraction)
		 * -- these are "signed," meaning they have negative and positive values
		 * 
		 * byte -- 8 bits
		 * short -- 16 bits
		 * int -- 32 bits
		 * long -- 64 bits
		 * 
		 * Decimal primitives (can be whole numbers or decimal number)
		 * 
		 * float -- 32 bits
		 * double -- 64 bits
		 * 
		 * char -- 16 bits, represents a single character, under the hood, they look like -- '\u0000'
		 * 
		 * boolean -- 1 bit, either 0 (false) or 1 (true)
		 * 
		 * String -- sometimes treated like a primitive, actually an object
		 */
		
		System.out.println("Byte min and max values:");
		System.out.println(Byte.MIN_VALUE);
		System.out.println(Byte.MAX_VALUE);
		
		System.out.println();
		
		System.out.println("Short min and max values:");
		System.out.println(Short.MIN_VALUE);
		System.out.println(Short.MAX_VALUE);
		
		System.out.println();
		
		System.out.println("Int min and max values:");
		System.out.println(Integer.MIN_VALUE);
		System.out.println(Integer.MAX_VALUE);
		
		System.out.println();
		
		System.out.println("Long min and max values:");
		System.out.println(Long.MIN_VALUE);
		System.out.println(Long.MAX_VALUE);
		
		System.out.println();
		
		System.out.println("Float min and max values:");
		System.out.println(Float.MIN_VALUE);
		System.out.println(Float.MAX_VALUE);
		
		System.out.println();
		
		System.out.println("Double min and max values:");
		System.out.println(Double.MIN_VALUE);
		System.out.println(Double.MAX_VALUE);
		
		// ints get used a lot, because Java assumes whole numbers are ints unless explicitly told otherwise
		System.out.println(1 + 2 + 3);
		
		// same for doubles
		System.out.println(1.2 + 3.4 + 5.6);
		
		// have to cast the number going in as a byte, because Java assumes 4 is an int
		System.out.println(doubleMyByte((byte)4));
		
		// Java assumes decimals are doubles, so to use a float, we have to cast it one of these two ways
		float f = 1.2f;
		float g = (float)1.2;
		
		// booleans
		boolean myBool = true;
		boolean myOtherBool = false;
		
		// chars
		// must use single quotes to declare, otherwise Java thinks it's a String
		char myChar = 'T';
		// can be added to, incremented, decremented, etc.
		myChar++;
		System.out.println(myChar);
		
		// underlying values for chars are used in sorting algorithms for alphabetical order, etc.
		System.out.println('2' <= 'C');
		System.out.println('C' <= 'c');
		
	}
	
	// have to cast the return as a byte, since we're using an int (the 2) in the logic
	public static byte doubleMyByte (byte x) {
		return (byte) (x * 2);
	}

}

//another class in the same file
class TestClass {
	
}



