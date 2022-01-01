package practice.palindromicsubsequence;

public class PalindromicPartitioningBottomUp {
	
    public static int findMPPCuts(String st) {
    	
    	int [][] dp = new int[st.length()][st.length()];
    	
    	
	    return findMPPCutsRecursive(st, 0, st.length()-1);
	}
    public static int findMPPCutsRecursive(String st, int startIndex, int endIndex) {
	    return findMPPCutsRecursive(st, 0, st.length()-1);
	}
	public static void main(String[] args) {
	
	}

}
