package com.skillstorm;

public class Constructors {
	
	// properties
	public String name;
	public String category;
	
	// constructors
	
	/*
	 * a constructor is a special method that returns an instance of the class
	 * we can have as many as we like, as long as they have different method signatures
	 * 
	 * if I provide NO constructors, Java includes the default constructor, which looks like:
	 * 
	 * public Constructors() {
	 * 		super();    -- this refers to Object's constructor, since all classes extend from Object
	 *   }
	 */
	
	// no-args constructor
	// if we want this functionality and we have another constructor, we need to include it explicitly
	public Constructors() {
		super(); // this calls the superclass (Object, in this case) no-args constructor
	}
	
	// overloaded constructors
	// must have different signatures (different parameters being taken in)
	public Constructors(String name) {
		super();
		this.name = name;
		this.category = "General";
	}
	
	public Constructors(String name, String category) {
		super();
		this.name = name;
		this.category = category;
	}
	
	// not limited to just taking in direct values for properties
	public Constructors(int id) {
		if (id == 0) {
			this.name = "Undefined";
			this.category = "General";
		} else {
			this.name = "Mega Constructor";
			this.category = "Unique";
		}
	}
	
	public static void main(String[] args) {
		Constructors con = new Constructors(0);
		
		System.out.println(con.name + ", " + con.category);
		
		HeavyMachine hm = new HeavyMachine("Digger XL", "Excavation", "Caterpillar", "Heavy Digging 6");
		
		System.out.println(hm);
		
		Excavator ex = new Excavator("Excavator Xtreme", "Mack", 123456789);
		
		System.out.println(ex);
	}
	
}

class HeavyMachine extends Constructors {
	
	// properties
	public String brand;
	public String licenseLevel;
	
	// constructors
	// I *could* assign the property values directly
	// better to use the superclass constructor
	public HeavyMachine(String name, String category, String brand, String licenseLevel) {
		// this.name = name;
		// this.category = category;
		super(name, category);
		this.brand = brand;
		this.licenseLevel = licenseLevel;
	}

	@Override
	public String toString() {
		return "HeavyMachine [name=" + name + ", category="
				+ category + ", brand=" + brand + ", licenseLevel=" + licenseLevel + "]";
	}
	
}

class Excavator extends HeavyMachine {
	
	// properties
	public long modelNumber;
	
	// constructor
	public Excavator(String name, String brand, long modelNumber) {
		super(name, "Excavation", brand, "Heavy Digging 6");
		this.modelNumber = modelNumber;
	}

	@Override
	public String toString() {
		return "Excavator [modelNumber=" + modelNumber + ", brand=" + brand + ", licenseLevel=" + licenseLevel
				+ ", name=" + name + ", category=" + category + "]";
	}
	
}






