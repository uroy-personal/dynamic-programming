package practice.longestcommonsubstring;

import java.util.*;

public class LargestCommonSubsequenceTopDown {
	public static int findLCSLength(String s1, String s2) {
		Map<String, Integer> clsMap = new HashMap<String, Integer>();
		return findLCSLengthRecursive(s1, s2, 0, 0, clsMap);
	}

	public static int findLCSLengthRecursive(String s1, String s2, int s1CurrentIndex, int s2CurrentIndex,
			Map<String, Integer> clsMap) {
		String key = s1CurrentIndex + "-" + s2CurrentIndex;
		if (clsMap.containsKey(key)) {
			return clsMap.get(key);
		}
		if (s1CurrentIndex >= s1.length() || s2CurrentIndex >= s2.length()) {
			clsMap.put(key, 0);
			return 0;
		}
		if (s1.charAt(s1CurrentIndex) == s2.charAt(s2CurrentIndex)) {
			return 1 + findLCSLengthRecursive(s1, s2, s1CurrentIndex + 1, s2CurrentIndex + 1, clsMap);
		}

		int c1 = findLCSLengthRecursive(s1, s2, s1CurrentIndex + 1, s2CurrentIndex, clsMap);
		int c2 = findLCSLengthRecursive(s1, s2, s1CurrentIndex, s2CurrentIndex + 1, clsMap);
		int maxCount = Math.max(c1, c2);
		clsMap.put(key, maxCount);
		return maxCount;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(findLCSLength("abdca", "cbda"));
		System.out.println(findLCSLength("passport", "ppsspt"));
	}

}
