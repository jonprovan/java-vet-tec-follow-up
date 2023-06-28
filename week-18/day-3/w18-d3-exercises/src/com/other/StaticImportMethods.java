package com.other;

// here, we're going to create some static methods and properties to import in our other class
public class StaticImportMethods {
	
	public static String bestBandEver = "Hanson";
	public static final int NUMBER_OF_PIANOS = 1;
	
	public static void sayMyName() {
		System.out.println(bestBandEver.toUpperCase() + "!!!");
	}
	
	public static int howManyPianos() {
		return NUMBER_OF_PIANOS;
	}
	
	public static String[] topThreeAlbums() {
		String[] albums = { "Shout It Out", "Underneath", "Anthem" };
		return albums;
	}

}
