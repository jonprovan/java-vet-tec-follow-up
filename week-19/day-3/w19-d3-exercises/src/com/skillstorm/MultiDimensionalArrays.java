package com.skillstorm;

import java.util.Arrays;

public class MultiDimensionalArrays {

	public static void main(String[] args) {
	
		// MULTI-DIMENSIONAL ARRAYS IN JAVA
		
		/*
		 * the standard array is one-dimensional, i.e., it is a linear collection of items
		 * 
		 * e.g. [ 1 - 4 - 7 - 3 - 9 - etc. ]
		 * 
		 * a single value in each slot
		 * 
		 * a two-dimensional (2D) array holds an array in each slot, each of which can have multiple values
		 * 
		 * e.g. [ [1, 2] - [3, 4] - [6, 12] - [66, 42] - etc. ]
		 * 
		 * so, we can view this as a "matrix" of sorts
		 * 
		 *      2		4		12		42
		 *      1		3		6		66
		 *      
		 * these are useful for storing any data that might be best visualized in a table, for instance
		 * 		- coordinates
		 * 		- lists of entries with values in various fields
		 * 		- relational database records, etc.
		 * 
		 * 3D arrays are harder to visualize, but the same logic extrapolates
		 * 
		 * 
		 */
		
		// instantiating a 2D array
		// a 1D array looks like what we've seen before
		int[] nums = { 1, 2, 3, 4, 5 };
		
		// a 2D array looks like this
		// using array literals for the "outer" array AND the "inner" arrays
		// so, this is an array holding 5 arrays, each of which has two items in it
		int[][] nums2D = { {1, 2}, {3, 4}, {5, 6}, {7, 8}, {9, 10} };
		
		// you can also declare the variable without giving it values
		int[][] numsX;
		
		// you can also declare the variable and instantiate its size
		// this creates a 2D array with 3 slots in the outer array but no indication as to the size of the inner arrays
		// inner arrays can be different sizes from each other -- this is called a "ragged" array
		int[][] numsY = new int[3][];
		
		// this creates a 2D array with 2 slots in the outer array and six slots in EACH of the inner arrays
		int[][] numsZ = new int[2][6];
		
		// I CANNOT do this...
		// you MUST specify the first dimension in order to specify the second dimension
		// int[][] numsZZ = new int[][3];
		
		// reading/writing values in the 2D array
		System.out.println(Arrays.toString(nums2D[0]));
		System.out.println(Arrays.toString(nums2D[4]));
		
		nums2D[0][0] = 11;
		
		System.out.println(Arrays.toString(nums2D[0]));
		
		nums2D[4][1] = 100;
		
		System.out.println(Arrays.toString(nums2D[4]));
		
		System.out.println();
		
		// using a loop to move through and access the values in our 2D array
		// this solves, for instance, the problem we have when trying to print our 2D array
		
		// the outer loop goes through the arrays in the outer array
		for (int i = 0; i < nums2D.length; i++) {
			
			System.out.print("[ ");
			
			// the inner loop goes through the items in an individual inner array
			for (int j = 0; j < nums2D[i].length; j++) {
				
				// print the value at this index of this inner array
				System.out.print(nums2D[i][j]);
				
				// in essence, whenever it's not the last iteration, print a comma and space
				if (nums2D[i].length - j != 1)
					System.out.print(", ");
				
			}
			
			System.out.print(" ]");
			
			// whenever it's not the last iteration, print a comma and space
			if (nums2D.length - i != 1)
				System.out.print(", ");
			
		}
		
		
		// what types are the values at various depths in the multi-dimensional array?
		
		// can't do this, because nums2D is a 2D array, not a 1D array
		// int[] x = nums2D;
		
		// I CAN do this, because the 0 index of nums2D is a 1D array of ints
		int[] x = nums2D[0];
		// I can also do this, because the 0 index of the 0 index of nums2D is an individual int
		int y = nums2D[0][0];
		// since we stored the 0 index of nums2D as x, I can also do this
		y = x[0];
		
		// I CANNOT do this, because it's the wrong type
		// String[] s = nums2D[0];
		
		// true for 3D arrays as well, even with default values
		int[][][] nums3D = new int[2][2][2];
		
		int[][] a = nums3D[0];
		int[] b = nums3D[0][0];
		int c = nums3D[0][0][0];
		
		System.out.println();
		
		// looping through a 3D array
		int[][][] printLoop = { 
								{ { 0, 1 }, { 2, 3 }, { 4, 5 } }, 
							    { { 6, 7 }, { 8, 9 }, { 10, 11 } }, 
							    { { 12, 13 }, { 14, 15 }, { 16, 17 } } 
							  };
		
		// going through each 2D array in the 3D array
		OUTER: for (int i = 0; i < printLoop.length; i++) {
			
			// going through each 1D array in one of the 2D arrays
			MIDDLE: for (int j = 0; j < printLoop[i].length; j++) {
				
				// going through each int in one of the 1D arrays
				INNER: for (int k = 0; k < printLoop[i][j].length; k++) {
					
					System.out.println(printLoop[i][j][k]);
					
				}
			}
		}
		
		
		

	}

}



