package com.skillstorm;

import java.util.Random;

public class UtilityClass {
	
	private String name;
	private int id;
	
	public UtilityClass(String name, int id) {
		this.name = name;
		this.id = id;
	}
	
	public void randomInteger(int range) {
		this.id = new Random().nextInt(range) + 1;
	}
	
	public void threeOptions(String name) throws Exception {
		
		switch(name) {
			case "":
				throw new Exception();
			case "Methuselah":
				this.name = name;
				break;
			default:
				this.randomInteger(1);
		}
		
	}

	public String getName() {
		return this.name;
	}
	
	public int getId() {
		return this.id;
	}

}
