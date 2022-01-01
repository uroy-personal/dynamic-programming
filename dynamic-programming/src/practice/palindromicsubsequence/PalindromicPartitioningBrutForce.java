package practice.palindromicsubsequence;

public class PalindromicPartitioningBrutForce {
	
    public static int findMPPCuts(String st) {
	    return findMPPCutsRecursive(st, 0, st.length()-1);
	}
    public static int findMPPCutsRecursive(String st, int startIndex, int endIndex) {
    	// base case
    	if(startIndex>=endIndex || isPalindromic(st, startIndex, endIndex)) {
    	  return 0;	
    	}
    	
    	int minCuts = endIndex-startIndex;
    	
    	for(int i=startIndex;i<=endIndex;i++) {
    			if(isPalindromic(st, startIndex, i)) {
        			minCuts = Math.min(minCuts, 1+findMPPCutsRecursive(st, i+1, endIndex));
        		}
    	}
    	
	    return minCuts;
	}
    
    static boolean isPalindromic(String s, int start, int end) {
    	while(start<end) {
    		if(s.charAt(start++)!=s.charAt(end--)) {
    			return false;
    		}
    	}
    	return true;
    }
	public static void main(String[] args) {
	    System.out.println(findMPPCuts("abdbca"));
	    System.out.println(findMPPCuts("cdpdd"));
	    System.out.println(findMPPCuts("pqr"));
	    System.out.println(findMPPCuts("pp"));
	}

}
