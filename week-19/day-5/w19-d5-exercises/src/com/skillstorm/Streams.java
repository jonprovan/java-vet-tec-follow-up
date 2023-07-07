package com.skillstorm;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.stream.Stream;

public class Streams {

	public static void main(String[] args) {
	
		// STREAMS AND THE JAVA STREAM API
		
		/*
		 * Streams are individual items from a collection sent through a series of processes
		 * -- we're not talking about processing the group as a whole, we're talking about processing each one individually
		 * 
		 * the Java Stream API is a group of tools we can use to easily process these items
		 * 
		 * - the tools are already created, so we don't have to code them
		 * - the syntax is easy to ready, and it's easy to understand what's happening and in what order
		 * - it's not as error-prone, since we have fewer intermittent variables
		 * 
		 * there are many tools in the Stream API; we're going to talk about just four:
		 * 
		 * forEach (terminal) -- takes in an item and does something WITH it [requires a Consumer function]
		 * map (intermediate) -- takes in an item, does something TO it, returns it to the Stream [requires a Supplier function]
		 * filter (intermediate) -- takes in an item and returns it to the Stream if it meets some criteria [requires a Predicate function]
		 * reduce (terminal) -- takes all the items and returns a single value
		 * 
		 * we can't just run these operations on a collection directly,
		 * we first have to turn it into a Stream
		 * 
		 * once we've processed the Stream, it no longer exists and is no longer usable
		 * to process the same items again, we'd need to create a new Stream
		 * the changes we make to the items DO NOT affect the original collection
		 * UNLESS the items are objects and we're altering their properties OR collections themselves whose contents we're changing
		 * 
		 * some processes are considered terminal -- when they run, they close out the stream
		 * others are intermediate -- when they run, they create a new Stream and pass it along to another process
		 * 
		 * WE MUST HAVE a terminal operation at the end of the Stream, or NONE OF THE PROCESSES WILL EXECUTE!
		 * 
		 */
		
		// creating a Stream
		Stream<Integer> myStream1 = Stream.of(1, 2, 3, 4, 5);
		
		LinkedList<Integer> intList = new LinkedList<>(Arrays.asList(1, 2, 3, 4, 5));
		
		// both these approaches do the same thing
		// this one has the advantage that I can create a new Stream from the original List as many times as I want
		Stream<Integer> myStream2 = intList.stream();
		
		
		// forEach -- takes in an item and does something WITH it; terminates the Stream
		// requires a Consumer function, one that takes in a parameter and has no return -- (x) -> System.out.println(x)
		// you can do whatever you want inside the Consumer, as long as you don't return anything
		intList.stream().forEach(
					item -> System.out.println(item)
				);
		
		System.out.println();
		
		intList.stream().forEach(item -> {
			item += item;
			System.out.println(item);
		});
		
		System.out.println();
		
		
		// map -- takes in an item, does something TO it, returns it to the Stream, MUST be eventually followed by a terminal operation
		// if you just use map WITHOUT a terminal operation, the Stream will not process
		// it requires a Supplier function, one that takes in a parameter and returns something -- (x) -> x
		// items move through the Stream individually, so all actions take place for a single item before we move on to the next
		intList.stream().map(item -> {
			System.out.println(item);
			return item*item;
		}).forEach(item -> {
			System.out.println(item);
		});
		
		System.out.println();
		
		
		// filter -- takes in an item, returns it to the Stream ONLY IF it meets certain criteria
		// also an intermediate operation that requires a terminal operation afterward
		// it requires a Predicate function, one that takes in a parameter and return a boolean
		// this boolean will be true if the item meets the criteria, false if not
		// if it's true, the item will be returned to the Stream unchanged
		// if it's false, the item will be removed from the Stream
		intList.stream().filter(item -> {
			if (item >= 3) return true;
			else return false;
		}).forEach(item -> {
			System.out.println(item);
		});
		
		System.out.println();
		
		
		// reduce takes in the entire Stream and returns a single "accumulated" value
		// it requires a function that takes in two parameters and returns a value
		// its first parameter is a starting or "accumulated" value that tracks the accumulation as you go
		// this is a terminal operation that DOES NOT return a Stream
		// here, we're adding all the numbers together
		int sum = intList.stream().reduce(0, (a, b) -> {
			return a + b;
		});
		
		System.out.println(sum);
		
		System.out.println();
		
		// here, we're finding the longest String
		String result = Stream.of("Larry", "Mo", "Curly", "Lawrence", "Maurice", "Ed").reduce("", (a, b) -> {
			return (a.length() > b.length()) ? a : b;
		});
		
		System.out.println(result);
		
		System.out.println();
		
		// chaining together multiple operations
		intList.stream()
			   .map(item -> item * item)
			   .filter(item -> item % 2 != 0)
			   .map(item -> item * item)
			   .forEach(item -> System.out.println(item));
		
		// you can't process the same Stream twice
		myStream1.forEach(x -> {});
		// can't do this, because the Stream has already been closed
		// myStream1.forEach(x -> {});
		
		

	}

}
