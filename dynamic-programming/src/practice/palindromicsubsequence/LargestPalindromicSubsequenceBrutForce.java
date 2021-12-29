package practice.palindromicsubsequence;

import java.util.*;

public class LargestPalindromicSubsequenceBrutForce {
	public static int computeLargestPalindromicSubsequence(String s) {
		return computeLargestPalindromicSubsequenceRecursive(s, 0, s.length()-1);
	}
	
	public static int computeLargestPalindromicSubsequenceRecursive(String s, int startIndex, int endIndex) {
		
		if(startIndex>endIndex) {
			return 0;
		}
		if(startIndex==endIndex) {
			return 1;
		}
		
		if(s.charAt(startIndex)==s.charAt(endIndex)) {
			return 2+computeLargestPalindromicSubsequenceRecursive(s, startIndex+1, endIndex-1);
		} 
		
		int lpsLengthLeavingStartElement = computeLargestPalindromicSubsequenceRecursive(s, startIndex+1, endIndex);
		int lpsLengthLeavingEndElement = computeLargestPalindromicSubsequenceRecursive(s, startIndex, endIndex-1);
		int maxLength = Math.max(lpsLengthLeavingStartElement, lpsLengthLeavingEndElement);
		
		return maxLength;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(computeLargestPalindromicSubsequence("abdbca"));
		System.out.println(computeLargestPalindromicSubsequence("cddpd"));
		System.out.println(computeLargestPalindromicSubsequence("pqr"));
	}
 
}
