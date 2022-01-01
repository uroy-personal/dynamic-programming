package practice.fibonacynumbers;
/*
 * Express with 1, 3 & 4
 */
public class NumberFactorBrutForce {
	public static int countWays(int n) {
		if(n==0) {
			return 1;
		}
		// base case 1 , {1}
		if(n==1) {
			return 1;
		}
		// base case 2 ,  {1,1}
		if(n==2) {
			return 1;
		}
		// base case 3 {1,1,1}, {3}
		if(n==3) {
			return 2;
		}
		
		int countWithOne = countWays(n-1);
		int countWithThree = countWays(n-3);
		int countWithFour = countWays(n-4);
		
		return countWithOne+countWithFour+countWithThree;
		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
	    System.out.println(countWays(4));
	    System.out.println(countWays(5));
	    System.out.println(countWays(6));
	}

}
