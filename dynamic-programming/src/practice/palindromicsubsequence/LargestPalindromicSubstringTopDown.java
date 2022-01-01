package practice.palindromicsubsequence;
import java.util.*;
public class LargestPalindromicSubstringTopDown {
	public static int computeLargestPalindromicSubstringLength(String s) {
		Map<String, Integer> map =  new HashMap<String, Integer>();
		return computeLargestPalindromicSubstringLengthRecursive(s, 0, s.length()-1, map);
	}
	public static int computeLargestPalindromicSubstringLengthRecursive(String s, int startIndex, int endIndex, Map<String, Integer> map) {
		String key = startIndex+"-"+endIndex;
		if(map.containsKey(key)) {
			// System.err.println("return from cache");
			return map.get(key);
		}
		// base case 1
		if(startIndex>endIndex) {
			map.put(key, 0);
			return 0;
		}
		
		// base case 2
		if(startIndex==endIndex) {
			map.put(key, 1);
			return 1;
		}
		// if start and end character are same and they enclose another palindrome
		if(s.charAt(startIndex) == s.charAt(endIndex)) {
			int remainingLength = endIndex-startIndex-1;
			if(remainingLength == computeLargestPalindromicSubstringLengthRecursive(s, startIndex+1, endIndex-1, map)) {
				map.put(key, 2+ remainingLength);
				return 2+ remainingLength;
			}
		}
		// length including currentElement
		int lengthWithCurrentElement = computeLargestPalindromicSubstringLengthRecursive(s, startIndex, endIndex-1, map );
		int lengthWithoutCurrentElement = computeLargestPalindromicSubstringLengthRecursive(s, startIndex+1, endIndex,  map);
		int maxLength = Math.max(lengthWithCurrentElement, lengthWithoutCurrentElement);
		map.put(key, maxLength);
		return maxLength;
	}
	public static void main(String[] args) {
		System.out.println(computeLargestPalindromicSubstringLength("abdbca"));
	    System.out.println(computeLargestPalindromicSubstringLength("cddpd"));
	    System.out.println(computeLargestPalindromicSubstringLength("pqr"));
	}

}
