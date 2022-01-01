package practice.longestcommonsubstring;

import java.util.Arrays;

public class LongestCommonSubstringLengthBottomUp {
    
	public static int findLCSLength(String s1, String s2) {
		int maxLength=0;
		int n = s1.length();
		int m = s2.length();
		int[][] dp = new int[n+1][m+1];
		
		int maxElementRow =0;
		int maxElementColumn = 0;
		for(int i=0;i<=m;i++) {
			dp[0][i]=0;
		}
		for(int i=0;i<=n;i++) {
			dp[n][0]=0;
		}
		
		for(int i=1;i<=n;i++) {
			for(int j=1;j<=m;j++) {
				if(s1.charAt(i-1) == s2.charAt(j-1)) {
					dp[i][j]=1+dp[i-1][j-1];
					if(dp[i][j]>=maxLength) {
						maxElementRow = i;
						maxElementColumn = j;
					}
					maxLength =  Math.max(maxLength, dp[i][j]);
				}else {
					dp[i][j]=0;	
				}
			}
		}
		
		for(int[] row : dp) {
			System.out.println(Arrays.toString(row));
		}
		System.out.println(" maxElementRow --> "+maxElementRow);
		System.out.println(" maxElementColumn --> "+maxElementColumn);
		StringBuilder sb = new StringBuilder();
		while(dp[maxElementRow][maxElementColumn] !=0) {
			sb.append(s1.charAt(maxElementRow-1));
			maxElementRow--;
			maxElementColumn--;
		}
		System.out.println(sb.reverse().toString());
		
		return maxLength;
	}
	public static String findLCSLength(String s1, String s2, int s1CurrentIndex, int s2CurrentIndex, int count, StringBuilder sb) {
		return "";
	}
	
    public static void main(String[] args) {
    	System.out.println(findLCSLength("abdca", "cbda"));
        System.out.println(findLCSLength("passport", "ppsspt"));
	}

}
