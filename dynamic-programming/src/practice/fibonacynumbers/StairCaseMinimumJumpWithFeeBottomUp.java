package practice.fibonacynumbers;

public class StairCaseMinimumJumpWithFeeBottomUp {
	public static int findMinFee(int[] fee) {
		int l = fee.length;
		    int[] dp = new int[l+1];
		    dp[0] =fee[0];
		    dp[1]=fee[0];
		    dp[2] =fee[0];
		    dp[3] =fee[0];
		    for(int start=3;start<l;start++) {
		    	// reach next step from here
		    	int reachFromCurrentStep = fee[start] + dp[start]; 
		    	// reach nextstep from last step
		    	int reachFromLastStep = fee[start-1]+dp[start-1];
		    	// reach nextstep from second last step
		    	int reachFromSecondLastStep = fee[start-2]+dp[start-2];
		    	
		    	dp[start+1] = Math.min(reachFromCurrentStep, Math.min(reachFromLastStep, reachFromSecondLastStep));
		    }
		    return dp[l];
    }
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(findMinFee(new int[] {1,2,5,2,1,2}));
		System.out.println(findMinFee(new int[] {2,3,4,5}));
	}

}
