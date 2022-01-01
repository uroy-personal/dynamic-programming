package practice.palindromicsubsequence;
import java.util.*;
public class PalindromicPartitioningTopDown {
	
    public static int findMPPCuts(String st) {
    	Map<Integer, Integer> mppMap = new HashMap<Integer, Integer>(); 
	    return findMPPCutsRecursive(st, 0, st.length()-1, mppMap);
	}
    public static int findMPPCutsRecursive(String st, int startIndex, int endIndex, Map<Integer, Integer> mppMap) {
    	// base case
    	if(mppMap.get(startIndex)!=null) {
    		System.out.println("Cache used");
    		return mppMap.get(startIndex);
    	}
    	if(startIndex>=endIndex || isPalindromic(st, startIndex, endIndex)) {
    		mppMap.put(startIndex, 0);
    	  return 0;	
    	}
    	
    	int minCuts = endIndex-startIndex;
    	
    	for(int i=startIndex;i<=endIndex;i++) {
    			if(isPalindromic(st, startIndex, i)) {
        			minCuts = Math.min(minCuts, 1+findMPPCutsRecursive(st, i+1, endIndex,mppMap));
        		}
    	}
    	mppMap.put(startIndex, minCuts);
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
