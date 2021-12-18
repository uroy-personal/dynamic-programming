package practice.knapsackunbounded;

public class UnboundedKnapsackBottomUp {
	public static  int solveKnapsack(int[] profits, int[] weights, int capacity) {
		
		int[][] dp = new int[weights.length][capacity+1];
		/*
		 *  populate the first column based on 0 capacity,
		 *  for 0 capacity profit is also 0
		 */
		for(int i=0;i<profits.length;i++) {
			dp[i][0] =0;
		}
		
		for(int k=0;k<profits.length;k++) {
			for(int l=1;l<=capacity;l++) {
				/* profit including the first element */
				int profit1=0;
				/* profit excluding the first element */
				int profit2=0;
				
				if(weights[k]<=l) {
					profit1 = profits[k]+dp[k][l-weights[k]];
				}
				
				if(k>0) {
				profit2 = dp[k-1][l];
				}
				
				dp[k][l] = profit1>profit2? profit1: profit2;
			}
			
		}
		
		
	    return dp[profits.length-1][capacity];
	  }
	
	
	public static void main(String[] args) {
		System.out.println(solveKnapsack(new int[] {15,20,50}, new int[] {1,2,3},  5));
	}

}
