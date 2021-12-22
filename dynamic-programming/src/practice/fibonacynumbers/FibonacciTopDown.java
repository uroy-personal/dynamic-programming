package practice.fibonacynumbers;

import java.util.*;

public class FibonacciTopDown {
	
	public int CalculateFibonacci(int n) {
		Map<Integer, Integer> fibMap = new HashMap<Integer, Integer>();
		 return  calculateFibonacciRecursive(n, fibMap);  
	}
	
	public int calculateFibonacciRecursive(int n, Map<Integer, Integer> fibMap) {
		if(fibMap.containsKey(n)) {
			// System.out.println("Returned from cache");
			return fibMap.get(n);
		}
	    if(n < 2) {
	    	fibMap.put(n, n);
	    	return n;
	    		  }
	    int returnValue = calculateFibonacciRecursive(n-1, fibMap) + calculateFibonacciRecursive(n-2, fibMap);
	    fibMap.put(n, returnValue);
	    return returnValue;
	}
	public static void main(String[] args) {
		FibonacciTopDown fib = new FibonacciTopDown();
	    System.out.println("5th Fibonacci is ---> " + fib.CalculateFibonacci(5));
	    System.out.println("6th Fibonacci is ---> " + fib.CalculateFibonacci(6));
	    System.out.println("7th Fibonacci is ---> " + fib.CalculateFibonacci(7));
	    System.out.println("7th Fibonacci is ---> " + fib.CalculateFibonacci(50));
	}

}
