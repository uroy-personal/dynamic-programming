package practice.palindromicsubsequence;

public class CountOfPalindromicSubstringBrutForce {
	public static int countPalindromicSubsequence(String s) {
		int length = s.length();
		int count = 0;
		boolean[][] dp = new boolean[length][length];

		for (int i = 0; i < length; i++) {
			dp[i][i] = true;
			count++;
		}

		for (int i = length - 1; i >= 0; i--) {
			for (int j = i + 1; j <= length - 1; j++) {
				if(s.charAt(i) == s.charAt(j)) {
				if (j == i + 1 || dp[i + 1][j - 1]) {
					count++;
					dp[i][j] = true;
				}
				}
			}
		}

		return count;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(countPalindromicSubsequence("abdbca"));
	    System.out.println(countPalindromicSubsequence("cdpdd"));
	    System.out.println(countPalindromicSubsequence("pqr"));

	}

}
