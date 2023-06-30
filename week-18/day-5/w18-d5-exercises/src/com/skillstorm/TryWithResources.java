package com.skillstorm;

import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class TryWithResources {

	public static void main(String[] args) {
		
		// TRY-WITH-RESOURCES AND SUPPRESSED EXCEPTIONS IN JAVA
		
		/*
		 * sometimes, we only need a certain resource during a try block and want to get rid of it afterward
		 * this is particularly useful for resources that use memory unnecessarily
		 * or that may throw Exceptions of some sort, like FileWriter, etc. (IOExceptions)
		 */
		
		// without try-with-resources
		// not recommended for resources that need to be closed
		// if we forget to close them, not only do they stay open
		// but, like in this case, the write method doesn't even have any effect
		try {
			FileWriter fw = new FileWriter("output.txt");
			fw.write("Hello, World!");
			fw.close();
		} catch (IOException ie) {
			ie.printStackTrace();
		}
		
		// with try-with-resources
		// the instant the try block is complete, this resource is closed
		// FileWriter implements the AutoCloseable interface
		// which has a method called close() that is automatically executed when the try block ends
		try (FileWriter fw = new FileWriter("output.txt")) {
			fw.write("Hello, try-with-resources!");
		} catch (IOException ie) {
			ie.printStackTrace();
		}
		
		
		// creating and locating a suppressed Exception
		try (Suppressed s = new Suppressed()) {
			System.out.println("Try block started...");
			throw new Exception();
		} catch (Exception e) {
			System.out.println("Exception caught!");
			// the Exception caught is the one we manually threw above
			e.printStackTrace();
			// BUT, the close() method in our Suppressed object threw an IOException
			// it gets suppressed at runtime and is "packed in" with the main Exception thrown
			// into an array of suppressed Exceptions
			// we can access this array with the .getSuppressed() method, then access an index with bracket notation
			System.out.println(e.getSuppressed()[0]);
		}
		

	}

}

class Suppressed implements AutoCloseable {

	@Override
	public void close() throws IOException {
		
		System.out.println("Suppressed object closing...");
		throw new IOException("This IOException gets suppressed if another Exception is thrown before close()");
		
	}
	
}
