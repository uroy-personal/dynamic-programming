package practice.knapsackunbounded;

public class CoinChangeBottomUp {
	public static int countChange(int[] denominations, int total) {
	    int n =  denominations.length;
		int[][] dp = new int[n][total+1];
		/*
		 * populate the 0 total rows
		 */
		for(int i =0; i<n;i++) {
			dp[i][0] =1;
		}
		
		/*
		 * populate rest of the table using bottom up approach
		 */
		for(int j=0;j<n;j++) {
			for(int k=1;k<=total;k++) {
				if(j>0) {
					dp[j][k] = dp[j-1][k];
				}
				if(k>=denominations[j]) {
					dp[j][k] = dp[j][k]+dp[j][k-denominations[j]];
				}
			}
		}
		return dp[n-1][total];
	  }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(countChange(new int[] {1, 2, 3}, 5));
	}

}
