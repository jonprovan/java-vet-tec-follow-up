package com.skillstorm;

// this is a static import statement
// MUST include the static keyword
// can do one at a time... (no parentheses for methods)
// import static com.other.StaticImportMethods.sayMyName;
// can get them all at once
import static com.other.StaticImportMethods.*;

import static java.lang.Long.*;
import static java.lang.Integer.*;

public class StaticImports {

	public static void main(String[] args) {

		// STATIC IMPORTS IN JAVA
		
		/*
		 * if we want to utilize a class, we can import the class, then use all its static and non-static methods, etc.
		 * 
		 * sometimes, though, we want to clean up our code and have direct access to static methods and properties
		 * 
		 * to do this, we can directly import the static methods and properties, rather than importing the entire class
		 * 
		 * we do this via a static import
		 */
		
		// normally, we'd import the whole class and then use standard static syntax
		// StaticImportMethods.sayMyName();
		
		// with a static import, though, we can just do this:
		sayMyName();
		
		System.out.println("They have " + howManyPianos() + " piano(s).");
		System.out.println("They have " + NUMBER_OF_PIANOS + " piano(s).");
		
		System.out.println("Top Three Albums:");
		
		for (String album : topThreeAlbums()) {
			System.out.println(album);
		}
		
		System.out.println();
		
		// we did NOT import the class, so we CANNOT use the normal syntax to call these methods
		// StaticImportMethods.sayMyName();
		// if we want to get to the class, we have to use the full class path, like this:
		com.other.StaticImportMethods.sayMyName();
		
		System.out.println();
		
		// if you have static imports with conflicting names, you'll run into Exceptions
		// here, both Long and Integer, whose methods/properties we've statically imported, have a MAX_VALUE constant
		// can't do this...
		// System.out.println(MAX_VALUE);  // doesn't compile
		
		// would have to get around it like this...
		System.out.println(java.lang.Long.MAX_VALUE);
	}

}
