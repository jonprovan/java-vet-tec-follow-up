package com.skillstorm;

import java.io.IOException;
import java.util.Random;

public class CustomExceptions {

	public static void main(String[] args) throws LootBoxException {

		// CUSTOM EXCEPTIONS IN JAVA
		
		/*
		 * we have many types of Exceptions available to us by default
		 * we can import any of them and use them however we like
		 * 
		 * BUT, you might want to create a custom Exception for a particular type of program behavior
		 * or that has specific functionality
		 */
		
		// manually throwing it
		// throw new LootBoxException();
		
		try {
			throw new LootBoxException();
		} catch (LootBoxException lbe) {
			lbe.printStackTrace();
			System.out.println(lbe.name + " thrown...no risk, no reward!");
			lbe.result();
		}

	}

}

class LootBoxException extends IOException {
	
	public String name = "Loot Box Exception";
	
	public void result() {
		int x = new Random().nextInt(3);
		
		if (x == 0) {
			System.out.println("BOOM! Your system exploded. Off to Best Buy for a new one...");
		} else if (x == 1) {
			System.out.println("Fried your CPU, but the rest of your system is okay.");
		} else {
			System.out.println("Here's a million bucks -- huzzah for you, sir!");
		}
	}
}








