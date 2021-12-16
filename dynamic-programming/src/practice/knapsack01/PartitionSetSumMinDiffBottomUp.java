package practice.knapsack01;
import java.util.*;
public class PartitionSetSumMinDiffBottomUp {
	static int canPartition(int[] num) {
		int sum=0;
		for(int n: num) {
			sum+=n;
		}
		boolean[][] dp = new boolean[num.length][sum/2+1];
		
		for(int i=0;i<num.length;i++) {
			dp[i][0] =true;
		}
		for(int j=1;j<=sum/2;j++) {
			dp[0][j] = (num[0]==j)?true:false;
		}
		
		for(boolean[] row: dp) {
			System.out.println(Arrays.toString(row));
		}
		System.out.println("before building");
		for(int k=1;k<num.length;k++) {
			for(int l=1;l<=sum/2;l++) {
				if(dp[k-1][l]) {
					dp[k][l]=dp[k-1][l];
				}else if (num[k]<=l) {
					dp[k][l] = dp[k-1][l-num[k]];
				}
				
			}
		}
		for(boolean[] row: dp) {
			System.out.println(Arrays.toString(row));
		}
		int diff=0;
		for(int m=sum/2;m>=0;m--) {
			if(dp[num.length-1][m]) {
				//System.out.println(m);
				int subsetSum = m;
				int otherSum = sum-subsetSum;
				diff = Math.abs(subsetSum-otherSum);
				break;
			}
		}
		return diff;
	}
	
	
	
	public static void main(String[] args) {
		System.out.println(canPartition(new int[]{1, 2, 3, 9}));
		System.out.println(canPartition(new int[]{1, 2, 7, 1, 5}));
		System.out.println(canPartition(new int[]{1, 3, 100, 4}));
		 
	}

}
