package practice.palindromicsubsequence;
import java.util.*;
public class MinimumDeletionToMakePalindromicBottomUp {
	public static int findMinimumDeletionPalindromic(String s) {
		int l=s.length();
		int[][] dp = new int[l][l];
		
		for(int i=0;i<l;i++) {
			dp[i][i] =1;
		}
		
		for(int i=l-2;i>=0;i--) {
			for(int j=i+1;j<l;j++) {
				if(s.charAt(i) == s.charAt(j)) {
					dp[i][j] = 2+dp[i+1][j-1];	
				}else {
					dp[i][j] = Math.max(dp[i+1][j], dp[i][j-1]);
				}
			}
		}
		return s.length()-dp[0][l-1];
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(findMinimumDeletionPalindromic("abdbca"));
	    System.out.println(findMinimumDeletionPalindromic("cddpd"));
	    System.out.println(findMinimumDeletionPalindromic("pqr"));
	     
	    
	    List<Integer> list  = new ArrayList<Integer>(); 
	    list.add(1);
	    list.add(2);
	    list.add(3);
	    list.add(4);
	    list.add(5);
	    list.add(6);
	    list.add(7);
	    list.add(8);
	    list.add(9);
	    list.add(100);
	    
	    while(list.size()>0) {
	    	System.out.println(list.get(0)+list.get(list.size()-1));
	    	list.remove(list.size()-1);
	    	if(list.size()>0) {
	    	list.remove(0);
	    	}
	    }
	    System.out.println(list.size());
	    
	}

}
