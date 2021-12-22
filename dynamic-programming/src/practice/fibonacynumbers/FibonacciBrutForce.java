package practice.fibonacynumbers;

public class FibonacciBrutForce {
	public int CalculateFibonacci(int n) {
		    if(n < 2)
		      return n;
		    return CalculateFibonacci(n-1) + CalculateFibonacci(n-2);
	}
	public static void main(String[] args) {
		FibonacciBrutForce fib = new FibonacciBrutForce();
		
	    System.out.println("5th Fibonacci is ---> " + fib.CalculateFibonacci(5));
	    System.out.println("6th Fibonacci is ---> " + fib.CalculateFibonacci(6));
	    System.out.println("7th Fibonacci is ---> " + fib.CalculateFibonacci(7));
	    System.out.println("7th Fibonacci is ---> " + fib.CalculateFibonacci(50));

	}

}
