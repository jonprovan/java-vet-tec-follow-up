package com.skillstorm;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ArraysUtility {

	public static void main(String[] args) {

		// THE ARRAYS UTILITY CLASS
		
		/*
		 * The Java Arrays class provides us with a series of useful static methods
		 * 
		 * These are useful for sorting, comparing, copying, etc.
		 * 
		 * Some things that arrays don't do automatically can be accomplished using this class
		 * 
		 */
		
		// Arrays.asList() will return a List with the contents of the array we give it
		String[] rawStrings = { "One", "Two", "Three" };
		
		List<String> strList = new ArrayList<>(Arrays.asList(rawStrings));
		
		System.out.println(strList);
		
		System.out.println();
		
		// attempting to copy an array
		int[] nums = { 1, 2, 3, 4, 5 };
		
		int[] nums2 = nums;
		
		// to print an array without a loop
		System.out.println(Arrays.toString(nums));
		
		// this doesn't work, because both variables are pointing to the same array
		nums2[0] = 100;
		
		System.out.println(Arrays.toString(nums));
		nums[0] = 1;
		
		// instead, I need to use Arrays.copyOf()
		// first parameter is the array to copy
		// second parameter is the length of the new array
		// it will truncate or pad the original array in the copy, based on the new length
		// this will create a new array with the nums values in the first 5 slots, then default values for the rest
		nums2 = Arrays.copyOf(nums, 10);
		
		System.out.println(Arrays.toString(nums2));
		
		// this is an ACTUAL copy, so changing values in one does not affect the other
		nums2[0] = 100;
		System.out.println(Arrays.toString(nums));
		
		// to copy only a portion of the original array, we can use .copyOfRange()
		// first parameter = the array to copy
		// second parameter = the starting index (inclusive)
		// third parameter = the finishing index (exclusive)
		int[] nums3 = Arrays.copyOfRange(nums, 1, 3);
		
		System.out.println(Arrays.toString(nums3));
		
		System.out.println();
		
		// checking for array equality
		char[] chars1 = { 'a', 'b', 'c' };
		char[] chars2 = { 'a', 'b', 'c' };
		
		// this doesn't work, because it's just comparing memory locations
		System.out.println(chars1 == chars2);
		
		// this doesn't work, either, because it's using Object's .equals() method, which does the same thing
		System.out.println(chars1.equals(chars2));
		
		// we need to use Arrays.equals()
		// two parameters are the arrays to compare
		System.out.println(Arrays.equals(chars1, chars2));
		
		System.out.println();
		
		// sorting arrays using Arrays.sort()
		// by default, it's going to use the "natural order"
		// this is ascending numerical for numbers, alpha order for Strings
		// it will also use your Comparable methodology, if you've implemented it
		
		int[] outOfOrderNums = { 45, -12, 3, 10000, -245 };
		
		System.out.println(Arrays.toString(outOfOrderNums));
		
		Arrays.sort(outOfOrderNums);
		
		System.out.println(Arrays.toString(outOfOrderNums));
		
		String[] outOfOrderStrings = { "xyz", "pqr", "efg", "nmo", "abc" };
		
		System.out.println(Arrays.toString(outOfOrderStrings));
		
		// BE CAREFUL! Capital letters take sort preference BEFORE lowercase letters, and numbers go FIRST
		Arrays.sort(outOfOrderStrings);
		
		System.out.println(Arrays.toString(outOfOrderStrings));
		
		// you can do this with your own objects, if you implement Comparable
		Student[] students = { new Student("Nick", 100), new Student("Doug", 42.5), new Student("LeeAnn", 91.6), new Student("Jolene", 12) };
		
		System.out.println(Arrays.toString(students));
		
		// the objects in our array MUST implement Comparable, or we throw a ClassCastException at runtime
		// whatever logic you want to use to sort your class, put it in the class's compareTo() method
		Arrays.sort(students);
		
		System.out.println(Arrays.toString(students));
	
	}

}

class Student implements Comparable<Student> {
	
	public String name;
	public double grade;
	
	public Student(String name, double grade) {
		this.name = name;
		this.grade = grade;
	}

	// sorting by grade
	@Override
	public int compareTo(Student student) {
		if (this.grade > student.grade)
			return -1;
		else if (student.grade > this.grade)
			return 1;
		else return 0;
	}
	
	// sorting by name
//	@Override
//	public int compareTo(Student student) {
//		return this.name.compareTo(student.name);
//	}

	@Override
	public String toString() {
		return "Student [name=" + name + ", grade=" + grade + "]";
	}
	
}






