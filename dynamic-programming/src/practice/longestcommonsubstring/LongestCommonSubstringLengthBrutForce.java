package practice.longestcommonsubstring;

public class LongestCommonSubstringLengthBrutForce {
    
	public static int findLCSLength(String s1, String s2) {
		
	    return findLCSLength(s1, s2, 0,0,0);
	}
	public static int findLCSLength(String s1, String s2, int s1CurrentIndex, int s2CurrentIndex, int count) {
		int m = s1.length();
		int n = s2.length();
		
		if(s1CurrentIndex>=m || s2CurrentIndex>=n ) {
			return count;
		}
		
		if(s1.charAt(s1CurrentIndex) == s2.charAt(s2CurrentIndex)) {
			count = findLCSLength(s1, s2, s1CurrentIndex+1, s2CurrentIndex+1, count+1 );
		}
		int c1 = findLCSLength(s1, s2, s1CurrentIndex, s2CurrentIndex+1, 0);
		int c2 = findLCSLength(s1, s2, s1CurrentIndex+1, s2CurrentIndex, 0);
	    return Math.max(Math.max(count, c1), c2);
	}
	
    public static void main(String[] args) {
    	System.out.println(findLCSLength("abdca", "cbda"));
        System.out.println(findLCSLength("passport", "ppsspt"));
	}

}
