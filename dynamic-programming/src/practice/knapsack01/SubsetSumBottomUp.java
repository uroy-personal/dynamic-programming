package practice.knapsack01;

public class SubsetSumBottomUp {
	static boolean canPartition(int[] num, int sum) {
	    return canPartitionRecursive(num, sum, 0);
	  }
	static boolean canPartitionRecursive(int[] num, int sum, int index) {
		
		if(index>=num.length) {
			return false;
		}
	    if(sum==num[index]) {
	    	return true;
	    }
		boolean canPartitionWithCurrentElement =false;
		boolean canPartitonWithoutCurrentElement = false;
		if(num[index]<sum) {
			canPartitionWithCurrentElement = canPartitionRecursive(num, sum-num[index], index+1);
		}
		canPartitonWithoutCurrentElement = canPartitionRecursive(num, sum, index+1);
		
	    return canPartitionWithCurrentElement||canPartitonWithoutCurrentElement;
	  }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(canPartition(new int[] {1, 2, 3, 7}, 6));
		System.out.println(canPartition(new int[] {1, 2, 7, 1, 5}, 10));
		System.out.println(canPartition(new int[] {1, 3, 4, 8}, 6));
		
	}

}
