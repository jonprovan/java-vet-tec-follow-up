package com.skillstorm;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class NextAndPrevious {

	public static void main(String[] args) {
		
		// NEXT AND PREVIOUS FOR LINKEDLISTS
		
		/*
		 * you'd think, with pointers, you'd have access to some sort of next/previous methods
		 * but you don't...
		 * 
		 * you could do something where you manually increment the index
		 * OR, to make this a little easier in practice, you could create a class that HAS-A LinkedList (or ArrayList, for that matter)
		 * and add your own methods
		 */
		
		// no next/previous with a regular LinkedList
		List<Integer> nums = new LinkedList<>(Arrays.asList(1, 5, 2, 7, 0, 3, 6, 8));
		
		// to go forward from a particular value, I'd have to basically take the current index, then find the value at the next one manually
		System.out.println(nums.get(nums.indexOf(7) + 1));
		System.out.println(nums.get(nums.indexOf(7) - 1));
		
		// using our class that HAS-A LinkedList
		ListTest<String> slt = new ListTest<>();
		
		slt.list.add("Hello");
		slt.list.add(" World");
		slt.list.add("!");
		
		System.out.println(slt.next(" World"));
		System.out.println(slt.previous(" World"));
	}

}

// this is simplified, and there are problems that arise, but you could work on it to avoid them or add further functionality
class ListTest<T> {
	public LinkedList<T> list = new LinkedList<>();
	
	public T next(T t) {
		return this.list.get(list.indexOf(t) + 1);
	}
	
	public T previous(T t) {
		return this.list.get(list.indexOf(t) - 1);
	}
}




