package practice.longestcommonsubstring;

public class LargestCommonSubsequenceBottomUp {
    public static int findLCSLength(String s1, String s2) {
	      // TODO: Write your code here
    	  int[][] dp = new int[s1.length()+1][s2.length()+1];
    	  for() {
    		  
    	  }
	      return findLCSLengthRecursive(s1, s2,0,0);
	  }
    
    public static int findLCSLengthRecursive(String s1, String s2, int s1CurrentIndex, int s2CurrentIndex) {
	      // TODO: Write your code here
    	if(s1CurrentIndex >= s1.length() || s2CurrentIndex>=s2.length()) {
    		return 0;
    	}
    	if(s1.charAt(s1CurrentIndex) == s2.charAt(s2CurrentIndex)) {
    		return 1+findLCSLengthRecursive(s1, s2, s1CurrentIndex+1, s2CurrentIndex+1);
    	}
    	
    	int c1 = findLCSLengthRecursive(s1, s2, s1CurrentIndex+1, s2CurrentIndex);
    	int c2 = findLCSLengthRecursive(s1, s2, s1CurrentIndex, s2CurrentIndex+1);
	      return Math.max(c1, c2);
	  } 
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(findLCSLength("abdca", "cbda"));
	    System.out.println(findLCSLength("passport", "ppsspt"));
	}

}
