package practice.palindromicsubsequence;

public class LargestPalindromicSubsequenceBottomUp {
	public static int computeLargestPalindromicSubsequence(String s) {
		int length = s.length();
		int[][] dp = new int[length][length];
		
		// single character string is a palindrome when startIndex==endIndex
		for(int i=0;i<length;i++) {
			dp[i][i]=1;
		}
		
		for(int i=length-2;i>=0;i--) {
			for(int j=i+1; j<=length-1;j++) {
				// case 1 , startIndex and endIndex character same
				if(s.charAt(i) == s.charAt(j)) {
					dp[i][j] = 2+ dp[i+1][j-1];
				}else {
				// case 2 , startIndex and endIndex characters are different	
					dp[i][j] = Math.max(dp[i+1][j], dp[i][j-1]);
				}
			}
		}
		
		return dp[0][s.length()-1];
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(computeLargestPalindromicSubsequence("abdbca"));
		System.out.println(computeLargestPalindromicSubsequence("cddpd"));
		System.out.println(computeLargestPalindromicSubsequence("pqr"));
	}
 
}
