package practice.palindromicsubsequence;

public class LargestPalindromicSubstringBrutForce {
	public static int computeLargestPalindromicSubstringLength(String s) {
		return computeLargestPalindromicSubstringLengthRecursive(s, 0, s.length()-1);
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
