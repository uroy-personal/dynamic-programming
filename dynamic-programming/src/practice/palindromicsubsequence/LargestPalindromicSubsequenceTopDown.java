package practice.palindromicsubsequence;

import java.util.*;

public class LargestPalindromicSubsequenceTopDown {
	public static int computeLargestPalindromicSubsequence(String s) {
		Map<String, Integer> lpsMap = new HashMap<>();
		int returnValue = computeLargestPalindromicSubsequenceRecursive(s, 0, s.length()-1, lpsMap);
		// System.out.println(lpsMap);
		return returnValue;
	}
	
	public static int computeLargestPalindromicSubsequenceRecursive(String s, int startIndex, int endIndex, Map<String, Integer> lpsMap) {
		String key = startIndex+"-"+endIndex;
		if(lpsMap.containsKey(key)) {
	//		System.out.println(" returned key from cache "+key );
			return lpsMap.get(key);
		}
		if(startIndex>endIndex) {
			lpsMap.put(key, 0);
			return 0;
		}
		if(startIndex==endIndex) {
			lpsMap.put(key, 1);
			return 1;
		}
		
		if(s.charAt(startIndex)==s.charAt(endIndex)) {
			return 2+computeLargestPalindromicSubsequenceRecursive(s, startIndex+1, endIndex-1, lpsMap);
		} 
		
		int lpsLengthLeavingStartElement = computeLargestPalindromicSubsequenceRecursive(s, startIndex+1, endIndex, lpsMap);
		int lpsLengthLeavingEndElement = computeLargestPalindromicSubsequenceRecursive(s, startIndex, endIndex-1, lpsMap);
		int maxLength = Math.max(lpsLengthLeavingStartElement, lpsLengthLeavingEndElement);
		lpsMap.put(key, maxLength);
		
		return maxLength;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(computeLargestPalindromicSubsequence("abdbca"));
		System.out.println(computeLargestPalindromicSubsequence("cddpd"));
		System.out.println(computeLargestPalindromicSubsequence("pqr"));
	}
 
}
