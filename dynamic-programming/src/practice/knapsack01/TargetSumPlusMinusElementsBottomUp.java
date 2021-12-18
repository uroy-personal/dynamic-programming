package practice.knapsack01;
import java.util.*;
public class TargetSumPlusMinusElementsBottomUp {
	public static int findTargetSubsets(int[] num, int s) {
			int totalSum = 0;
			int negativeSum =0;
			for(int n:num) {
				totalSum+=n;
			}
			negativeSum = (totalSum-s)/2;
			int n = num.length;
			int [][] dp = new int[n][negativeSum+1];
			// populate the 0 negativeSum column
			
			
			
			for(int i=0;i<n;i++) {
				dp[i][0]=1;
			}
			
			
			System.out.println("::");
			// populate the first row
			for(int j=1;j<=negativeSum;j++) {
				dp[0][j] = (num[0] == j ? 1 : 0);
			}
			for(int[]row: dp) {
				System.out.println(Arrays.toString(row));
			}
			System.out.println("::");
			for(int k=1;k<n;k++) {
				for(int l=1;l<=negativeSum;l++) {
					dp[k][l]=dp[k-1][l];
					if(num[k]<=l) {
						dp[k][l] = dp[k][l]+dp[k-1][l-num[k]];
					}
				}
			}
			for(int[]row: dp) {
				System.out.println(Arrays.toString(row));
			}
			return dp[n-1][negativeSum];
		  }
	
	public static void main(String[] args) {
		long startTime = new Date().getTime();
		System.out.println(findTargetSubsets(new int[] {1, 1, 2, 3}, 1));
		// System.out.println(findTargetSubsets(new int[] {1, 2, 7, 1}, 9));
		long endTime = new Date().getTime();
		System.out.println(" ::: Execution time ::: "+(endTime-startTime));
	}

}
