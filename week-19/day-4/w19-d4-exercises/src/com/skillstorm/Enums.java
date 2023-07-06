package com.skillstorm;

public class Enums {

	public static void main(String[] args) {
		
		// ENUMS IN JAVA
		
		/*
		 * in essence, an enum is a set of constants we can use to delineate collections of permanent things
		 * 
		 * for instance, you might have an enum of the days of the week that includes Monday, Tuesday, Wednesday, etc.
		 * you don't want anyone to be able to add one or change one in any way
		 * 
		 * they're called enums because it's short for enumerations, i.e., specifically designated properties/values
		 * 
		 * an enum can be its own class or a property of another class
		 */
		
		// accessing our enum
		System.out.println(MovieStars.LUPITA_NYONGO);
		
		System.out.println(MovieStars.WARWICK_DAVIS.getName() + ", " + MovieStars.WARWICK_DAVIS.getGenre());

	}

}

// we create an enum like a class but use the word "enum" instead of "class"
enum MovieStars {
	
	// the first thing in the enum is the list of constants
	// the parentheses hold the parameters to use when running the constructor
	SANDRA_BULLOCK("Sandra Bullock", "Action"), 
	MORGAN_FREEMAN("Morgan Freeman", "Drama"), 
	CARY_GRANT("Cary Grant", "Classics"), 
	BETTY_WHITE("Betty White", "Comedy"), 
	LUPITA_NYONGO("Lupita Nyongo", "Blockbusters"), 
	WARWICK_DAVIS("Warwick Davis", "Fantasy");
	
	// they can have properties like any other object
	private String name;
	private String genre;
	
	// the constructor MUST be private
	// it is ONLY run by the list of constants above and their properties in parentheses
	private MovieStars(String name, String genre) {
		this.name = name;
		this.genre = genre;
	}
	
	// we have getters for our properties, but no setters, since we want these to be constants
	// you can create whatever custom methods you want!
	public String getName() {
		return name;
	}
	public String getGenre() {
		return genre;
	}
	
	
	
}
