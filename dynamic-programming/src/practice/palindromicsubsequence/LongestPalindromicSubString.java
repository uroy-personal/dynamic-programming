package practice.palindromicsubsequence;

import java.util.Arrays;

class Pair{
	int startIndex;
	int endIndex;
	Pair(int startIndex, int endIndex){
		this.startIndex=startIndex;
		this.endIndex=endIndex;
	}
}
public class LongestPalindromicSubString {
	
	public static String longestPalindrome(String s) {
		String longestPalindrome="";
		int maxLength = Integer.MIN_VALUE;
		for(int i=0;i<s.length();i++) {
			for(int j=i;j<=s.length();j++) {
				// System.out.println(s.substring(i,j));
				if(isPalindrome(s.substring(i,j))) {
					if(j-i+1> maxLength) {
						maxLength = j-i+1;
						longestPalindrome = s.substring(i,j);
					}
				}
			}
		}
		return longestPalindrome;
	}
	
	public static String longestPalindromeDp(String s) {
		String longestPalindrome="";
		
		int maxLength = Integer.MIN_VALUE;
		int[][] dp = new int[s.length()][s.length()];
		
		/* set the base conditions */
		for(int i=0;i<dp.length;i++) {
			dp[i][i]=1;
			
			if(i<dp.length-1) {
				dp[i][i+1]=s.charAt(i)==s.charAt(i+1)?1:0;
			}
		}
		for(int j=0;j<dp.length;j++) {
			for(int k=0;k<j;k++) {
				if(j==k) {
					continue;
				}
				if(j-k==1) {
					dp[j][k]=(s.charAt(j)==s.charAt(k))?1:0;
				}
				if(j-k>=2) {
					dp[j][k] = (s.charAt(j)==s.charAt(k))? dp[j+1][k-1]:0;
				}
				
				if(dp[j][k]==1) {
					if(j-k+1>maxLength) {
						maxLength = j-k+1;
						longestPalindrome = s.substring(j,k+1);
					}
				}
			}
		}
		
		for(int[] row: dp) {
			System.out.println(Arrays.toString(row));
		}
		
		
		
		
		return longestPalindrome;
	}
	
	public static String longestPalindromeDp2(String s) {


        if (s == null || "".equals(s)) {
            return s;
        }
        
        int len = s.length();

        String ans = "";
        int max = 0;

        boolean[][] dp = new boolean[len][len];

        for (int j = 0; j < len; j++) {
            
            for (int i = 0; i <= j; i++) {
                
                boolean judge = s.charAt(i) == s.charAt(j);
                
                dp[i][j] = j - i > 2 ? dp[i + 1][j - 1] && judge : judge;

                if (dp[i][j] && j - i + 1 > max) {
                    max = j - i + 1;
                    ans = s.substring(i, j + 1);
                }
            }
            for(boolean[] row:dp) {
            	System.out.println(Arrays.toString(row));
            }
            System.out.println("--");
        }
        
        
        return ans;
	}
	
	public static boolean isPalindrome(String s) {
		if(s==null) {
			return false;
		}
		if(s.equalsIgnoreCase("") || s.length()==1) {
			return true;
		}
		if(s.charAt(0) == s.charAt(s.length()-1)) {
			return isPalindrome(s.substring(1, s.length()-1));
		}else {
			return false;
		}
		
	}
	
	// public int extendFrom
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String test = "fghiihgf";
		String test2 = "babad";
		// System.out.println(isPalindrome(test));
		System.out.println(longestPalindromeDp(test));
	}

}
