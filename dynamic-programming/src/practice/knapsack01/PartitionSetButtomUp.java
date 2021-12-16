package practice.knapsack01;

import java.util.HashMap;
import java.util.Map;

public class PartitionSetButtomUp {
	
	static boolean canPartition(int[] nums) {
		int sum = 0;
	    for(int element:nums) {
	    	sum+=element;
	    }
	    if(sum%2!=0) {
	    	return false;
	    }
	    
	    int n = nums.length;
	    
	   boolean[][] dp = new boolean[n][sum/2+1];
	   
	   for(int i=0;i<n;i++) {
		   dp[i][0] = true;
	   }
	   for(int j=0;j<=sum;j++) {
		   dp[0][j]=(j==nums[0])?true:false;
	   }
	   for(int k=1;k<n;k++) {
		   for(int l=1;l<=sum;l++) {
			   if(dp[k-1][l]) {
				   dp[k][l] = dp[k-1][l]; 
			   }else if(l>=nums[k]) {
				   dp[k][l] = dp[k-1][l-nums[k]];
			   }
		   }
	   }
	   return dp[n-1][sum]; 
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
