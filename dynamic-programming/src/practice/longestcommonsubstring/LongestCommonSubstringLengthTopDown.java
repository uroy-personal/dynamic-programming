package practice.longestcommonsubstring;
import java.util.*;
public class LongestCommonSubstringLengthTopDown {
    
	public static int findLCSLength(String s1, String s2) {
		Map<String, Integer> map = new HashMap<String, Integer>();
	    return findLCSLength(s1, s2, 0,0,0, map);
	}
	public static int findLCSLength(String s1, String s2, int s1CurrentIndex, int s2CurrentIndex, int count, Map<String, Integer> map) {
		
		String key = s1CurrentIndex+"-"+s2CurrentIndex+"-"+count;
		
		if(map.containsKey(key)) {
			return map.get(key);
		}
		
		int m = s1.length();
		
		int n = s2.length();
		
		if(s1CurrentIndex>=m || s2CurrentIndex>=n ) {
			map.put(key, count);
			return count;
		}
		
		if(s1.charAt(s1CurrentIndex) == s2.charAt(s2CurrentIndex)) {
			count = findLCSLength(s1, s2, s1CurrentIndex+1, s2CurrentIndex+1, count+1, map );
		}
		int c1 = findLCSLength(s1, s2, s1CurrentIndex, s2CurrentIndex+1, 0, map);
		int c2 = findLCSLength(s1, s2, s1CurrentIndex+1, s2CurrentIndex, 0, map);
	    int maxLength = Math.max(Math.max(count, c1), c2);
	    map.put(key, maxLength);
		return maxLength;
	}
	
    public static void main(String[] args) {
    	System.out.println(findLCSLength("abdca", "cbda"));
        System.out.println(findLCSLength("passport", "ppsspt"));
	}

}
