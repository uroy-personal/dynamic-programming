package practice.knapsack01;

public class TargetSumPlusMinusElementsBrutForce {
	public int findTargetSubsets(int[] num, int s) {
		    return -1;
		  }
	
	public int findTargetSubsetsRecursive(int[] num, int s, int index, int sum1, int sum2) {
		if(Math.abs(sum1-sum2)==s)
	    return 1;
		if(index>=num.length) {
			return 0;
		}
		return -1;
	  }
	public static void main(String[] args) {
	
	}

}
