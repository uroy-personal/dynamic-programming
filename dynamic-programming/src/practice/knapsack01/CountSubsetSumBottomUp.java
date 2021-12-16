package practice.knapsack01;

import java.util.Arrays;

public class CountSubsetSumBottomUp {
    static int countSubsets(int[] num, int sum) {
    	
      int[][] dp =  new int[num.length][sum+1];
      
      // populate first column
      
      for(int i=0;i<num.length-1;i++) {
    	  dp[i][0] = 1;
      }
      // populate the remaining first columns in the first row  
      for(int j=1;j<=sum;j++) {
    	  dp[0][j] = (num[0]==j)? 1:0;
      }
      // 
      
      /*
       * populate the dp table
       * 
       */
      for(int k=1;k<num.length;k++) {
    	  for(int l=1;l<=sum;l++) {
    		  // exclude current number
    		  dp[k][l] = dp[k-1][l];
    		  // 
    		  if(num[k]<=l) {
    			  dp[k][l]+=dp[k-1][l-num[k]];
    		  }
    	  }
      }
      
      for(int[] row: dp) {
    	  System.out.println(Arrays.toString(row));
      }
      
      
      return dp[num.length-1][sum];
    }
    
	public static void main(String[] args) {
		System.out.println(countSubsets(new int[] {1, 1, 2, 3}, 4));
		System.out.println(countSubsets(new int[] {1, 2, 7, 1, 5}, 9));
	}

}
