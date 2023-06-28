package com.skillstorm;

// this class inherits from Object, even though we don't state it explicitly
public class Inheritance {

}

// to inherit from another class, we use the extends keyword
// now, this class inherits from Inheritance, which inherits from Object
// (using ChildX because we have a Child class in another file in this package)
class ChildX extends Inheritance {
	
}

// now, this class inherits from Child, which inherits from Inheritance, which inherits from Object
class Grandchild extends ChildX {
	
}

// we CAN have multiple classes inherit from a single class
// this is the main reason to use inheritance
// we can group like properties and functionality that multiple classes share into a single parent class
class Stepchild extends ChildX {
	
}

// we CANNOT inherit from multiple classes
// each child class MUST have ONE AND ONLY ONE parent

class Test {
	
}

// we cannot do this
// class GreatGrandchild extends Grandchild, Test {
//	
// }

// if we want to "inherit" from multiple classes, we do something like it with interfaces, but doesn't have the same effect






