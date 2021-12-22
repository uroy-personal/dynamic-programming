package practice.knapsackunbounded;

public class MinimumCoinChangeBottomUp {
	public static int minChangeCount(int[] denominations, int total) {
		int noOfCoins = denominations.length;
		int[][] dp = new int[noOfCoins][total+1];
		// populate the table
		for(int i=0; i < noOfCoins; i++)
	        for(int j=0; j <= total; j++)
	          dp[i][j] = Integer.MAX_VALUE;
		// populate the 0 total column
	    for(int i=0;i<noOfCoins;i++) {
			dp[i][0] =0;
		}
		
		for(int i=0;i<noOfCoins;i++) {
			for(int j=1;j<=total;j++) {
				
				if(i>0) {
					dp[i][j] = dp[i-1][j];
				}
				if(denominations[i]<=j) {
					if(dp[i][j-denominations[i]]!= Integer.MAX_VALUE) {
						dp[i][j] = Math.min(dp[i][j], 1+dp[i][j-denominations[i]]);
					}
				}
			}
		}
		
		return dp[noOfCoins-1][total] == Integer.MAX_VALUE?-1:dp[noOfCoins-1][total];
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] denominations = {1, 2, 3};
	    System.out.println(minChangeCount(denominations, 5));
	}

}
