package practice.fibonacynumbers;

public class StaircaseBottomUp {
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
		
     return -1;
		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
