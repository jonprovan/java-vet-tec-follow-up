package com.skillstorm;

import java.util.Comparator;
import java.util.PriorityQueue;

public class PriorityQueues {

	public static void main(String[] args) {
		
		// PRIORITYQUEUES IN JAVA
		
		/*
		 * as discussed previously, a PriorityQueue is an actual object, not an interface
		 * 
		 * it stores items in an unpredictable order
		 * BUT, when it releases items from the Queue, it does so in a sorted way
		 * either via natural order, Comparable implementation, or a Comparator (either an instance of a class or a lambda)
		 */
		
		// creating a PriorityQueue
		PriorityQueue<Integer> pqi = new PriorityQueue<>();
		
		pqi.offer(4);
		pqi.offer(11);
		pqi.offer(-12);
		pqi.offer(68);
		pqi.offer(2);
		
		// this printout is not indicative of release order
		System.out.println(pqi);
		
		// but the items release in natural order
		while (!pqi.isEmpty())
			System.out.println(pqi.poll());
		
		System.out.println();
		
		// a new PriorityQueue using our CellPhone objects
		PriorityQueue<CellPhone> pqcp = new PriorityQueue<>();
		
		pqcp.offer(new CellPhone("Samsung"));
		pqcp.offer(new CellPhone("Nokia"));
		pqcp.offer(new CellPhone("Sony"));
		pqcp.offer(new CellPhone("Blackberry"));
		pqcp.offer(new CellPhone("Apple"));
		
		System.out.println(pqcp);
		
		// removal order follows the "natural order" dictated in my Comparable implementation
		while (!pqcp.isEmpty())
			System.out.println(pqcp.poll());
		
		System.out.println();
		
		// using a Comparator to indicate the sorting method
		// you can add a Comparator to the constructor of the PriorityQueue
		CellPhoneComparator cpc = new CellPhoneComparator();
		
		// note the cpc in the parentheses at the end
		PriorityQueue<CellPhone> pqcp2 = new PriorityQueue<>(cpc);
		
		pqcp2.offer(new CellPhone("Samsung"));
		pqcp2.offer(new CellPhone("Nokia"));
		pqcp2.offer(new CellPhone("Sony"));
		pqcp2.offer(new CellPhone("Blackberry"));
		pqcp2.offer(new CellPhone("Apple"));
		
		System.out.println(pqcp2);
		
		// removal order follows the order dictated by my Comparator class
		while (!pqcp2.isEmpty())
			System.out.println(pqcp2.poll());
		
		System.out.println();
		
		// using a lambda expression to indicate the removal order
		PriorityQueue<CellPhone> pqcp3 = new PriorityQueue<>((a, b) -> a.brand.charAt(1) - b.brand.charAt(1));
		
		pqcp3.offer(new CellPhone("Samsung"));
		pqcp3.offer(new CellPhone("Nokia"));
		pqcp3.offer(new CellPhone("Sony"));
		pqcp3.offer(new CellPhone("Blackberry"));
		pqcp3.offer(new CellPhone("Apple"));
		
		System.out.println(pqcp3);
		
		// removal order follows the order dictated by my lambda expression
		while (!pqcp3.isEmpty())
			System.out.println(pqcp3.poll());
		
		System.out.println();
		

	}

}

class CellPhone implements Comparable<CellPhone> {
	
	public String brand;
	
	public CellPhone(String brand) {
		this.brand = brand;
	}

	@Override
	public String toString() {
		return "CellPhone [brand=" + brand + "]";
	}



	@Override
	public int compareTo(CellPhone other) {
		
		return this.brand.compareTo(other.brand);
	}
	
}

class CellPhoneComparator implements Comparator<CellPhone> {

	@Override
	public int compare(CellPhone cp1, CellPhone cp2) {
		
		return cp2.brand.compareTo(cp1.brand);
	}
	
}
