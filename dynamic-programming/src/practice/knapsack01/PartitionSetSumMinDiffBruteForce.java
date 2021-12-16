package practice.knapsack01;

public class PartitionSetSumMinDiffBruteForce {
	static int canPartition(int[] num) {
		return canPartitionRecursive(num, 0,0, 0);
	}
	
	static int canPartitionRecursive(int[] num, int sum1, int sum2, int index) {
		if(index>=num.length) {
			return Math.abs(sum1-sum2);
		}
		
		int sum1IncludingNumber = canPartitionRecursive(num, sum1+num[index], sum2, index+1);
		int sum2IncludingNumber = canPartitionRecursive(num, sum1, sum2+num[index], index+1);
		
		return Math.min(sum1IncludingNumber,sum2IncludingNumber);
	}
	
	
	
	public static void main(String[] args) {
		System.out.println(canPartition(new int[]{1, 2, 3, 9}));
		System.out.println(canPartition(new int[]{1, 2, 7, 1, 5}));
		System.out.println(canPartition(new int[]{1, 3, 100, 4}));
	}

}
