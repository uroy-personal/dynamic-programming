package practice.fibonacynumbers;

public class Staircase {
	public static int countWays(int n) {
		// there is only one way for no steps
		if(n==0) {
			return 1;
		}
		// we can take one step to reach and that is the only way
		if(n==1) {
			return 1;
		}
		// we can take one step twice or jump two steps to reach the top
		if(n==2) {
			return 2;
		}
		//
		int countWithOneStep = countWays(n-1);
		int countWithTwoSteps = countWays(n-2);
		int countWithThreeSteps =  countWays(n-3);
		
		
     return countWithOneStep+countWithTwoSteps+countWithThreeSteps;
		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(countWays(3));
		System.out.println(countWays(4));
	}

}
