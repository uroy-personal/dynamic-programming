package practice.knapsack01;

public class SubsetSumTopDown {
	static boolean canPartition(int[] num, int sum) {
		
		boolean[][] dp = new boolean[num.length][sum+1];
		
		for(int i=0;i<num.length;i++) {
			dp[i][0] =true;
		}
		for(int j=0;j<=sum;j++) {
			dp[0][j] = (num[0]==j)?true:false;
		}
		
		for(int k=1;k<num.length;k++) {
			for(int l=1;l<=sum;l++) {
				if(dp[k-1][l]) {
					dp[k][l] = dp[k-1][l];
				}else if(l>=num[k]) {
					dp[k][l] = dp[k-1][l-num[k]];
				}
			}
		}
		return dp[num.length-1][sum];
	  }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(canPartition(new int[] {1, 2, 3, 7}, 6));
		System.out.println(canPartition(new int[] {1, 2, 7, 1, 5}, 10));
		System.out.println(canPartition(new int[] {1, 3, 4, 8}, 6));
		
	}

}
