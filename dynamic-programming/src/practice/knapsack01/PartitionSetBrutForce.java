package practice.knapsack01;

public class PartitionSetBrutForce {
	static boolean canPartition(int[] nums) {
		int sum = 0;
	    for(int element:nums) {
	    	sum+=element;
	    }
	    if(sum%2!=0) {
	    	return false;
	    }
	    return canPartitionRecursive(nums, sum/2, 0);
	}
	
	static boolean canPartitionRecursive(int[] nums, int sum, int index) {
	    if(index>=nums.length) {
	    	return false;
	    }
	    
	    if(nums[index] == sum) {
	    	return true;
	    }
	    boolean canPartitionWithItem = false;
	    boolean canPartitionWithoutItem = false;
	    
	    if(nums[index]<sum) {
	    	canPartitionWithItem = canPartitionRecursive(nums, sum-nums[index], index+1);
	    }
	    
	    canPartitionWithoutItem = canPartitionRecursive(nums, sum, index+1);
	    
	    return (canPartitionWithItem ||canPartitionWithoutItem) ;
	}
	
	
	public static void main(String[]args) {
		System.out.println(canPartition(new int[]{1, 2, 3, 4}));
		System.out.println(canPartition(new int[]{1, 1, 3, 4, 7}));
		System.out.println(canPartition(new int[]{2, 3, 4, 6}));

	}
}
