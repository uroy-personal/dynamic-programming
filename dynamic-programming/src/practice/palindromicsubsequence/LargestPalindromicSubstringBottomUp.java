package practice.palindromicsubsequence;

public class LargestPalindromicSubstringBottomUp {
	public static int computeLargestPalindromicSubstringLength(String s) {
		int length = s.length();
		int[][] dp = new int[length][length];
		
		// base case, for single character string palindrome length is 1
		for(int i=0;i<length;i++) {
			dp[i][i] = 1;
		}
		for(int i=length-2;i>=0;i--) {
			for(int j=i+1;j<=length-1;j++) {
				if(s.charAt(i) == s.charAt(j) &&  j-i-1 == dp[i+1][j-1]) {
						dp[i][j] =j-i+1;
				}else {
					dp[i][j]  = Math.max(dp[i][j-1], dp[i+1][j]);
				}
			}
		}
		for(int[] row: dp) {
			// System.out.println(Arrays.toString(row));
		}
		return dp[0][length-1];
	}
	public static int computeLargestPalindromicSubstringLengthRecursive(String s, int startIndex, int endIndex ) {
		// base case 1
		if(startIndex>endIndex) {
			return 0;
		}
		
		// base case 2
		if(startIndex==endIndex) {
			return 1;
		}
		// if start and end character are same and they enclose another palindrome
		if(s.charAt(startIndex) == s.charAt(endIndex)) {
			int remainingLength = endIndex-startIndex-1;
			if(remainingLength == computeLargestPalindromicSubstringLengthRecursive(s, startIndex+1, endIndex-1)) {
				return 2+ remainingLength;
			}
		}
		// length including currentElement
		int lengthWithCurrentElement = computeLargestPalindromicSubstringLengthRecursive(s, startIndex, endIndex-1);
		int lengthWithoutCurrentElement = computeLargestPalindromicSubstringLengthRecursive(s, startIndex+1, endIndex);
		return Math.max(lengthWithCurrentElement, lengthWithoutCurrentElement);
	}
	public static void main(String[] args) {
		System.out.println(computeLargestPalindromicSubstringLength("abdbca"));
	    System.out.println(computeLargestPalindromicSubstringLength("cddpd"));
	    System.out.println(computeLargestPalindromicSubstringLength("pqr"));
	}

}
