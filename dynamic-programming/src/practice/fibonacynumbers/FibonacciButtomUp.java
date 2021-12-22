package practice.fibonacynumbers;

public class FibonacciButtomUp {
	
	public int CalculateFibonacci(int n) {
		int[] dp = new int[n+1];
		dp[0]=0;
		dp[1]=1;
		for(int i=2;i<=n;i++) {
			dp[i] = dp[i-2]+dp[i-1];
		}
		return dp[n];
	}
	

	public static void main(String[] args) {
		FibonacciButtomUp fib = new FibonacciButtomUp();
	    System.out.println("5th Fibonacci is ---> " + fib.CalculateFibonacci(5));
	    System.out.println("6th Fibonacci is ---> " + fib.CalculateFibonacci(6));
	    System.out.println("7th Fibonacci is ---> " + fib.CalculateFibonacci(7));
	    System.out.println("7th Fibonacci is ---> " + fib.CalculateFibonacci(50));
	}

}
