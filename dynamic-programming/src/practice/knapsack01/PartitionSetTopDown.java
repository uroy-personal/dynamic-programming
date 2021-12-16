package practice.knapsack01;
import java.util.*;
public class PartitionSetTopDown {


	static boolean canPartition(int[] nums) {
		int sum = 0;
	    for(int element:nums) {
	    	sum+=element;
	    }
	    if(sum%2!=0) {
	    	return false;
	    }
	    Map<String, Boolean> partitionMap = new HashMap<String, Boolean>();
	    
	    
	    return canPartitionRecursive(nums, sum/2, 0, partitionMap);
	}
	
	static boolean canPartitionRecursive(int[] nums, int sum, int index, Map<String, Boolean> partitionMap) {
	    String key = sum+"-"+index;
	    
	    if(partitionMap.containsKey(key)) {
	    	return partitionMap.get(key);
	    }
	    
		if(index>=nums.length) {
			partitionMap.put(key, false);
	    	return false;
	    }
	    
	    if(nums[index] == sum) {
	    	partitionMap.put(key, true);
	    	return true;
	    }
	    boolean canPartitionWithItem = false;
	    boolean canPartitionWithoutItem = false;
	    
	    if(nums[index]<sum) {
	    	canPartitionWithItem = canPartitionRecursive(nums, sum-nums[index], index+1,partitionMap);
	    }
	    
	    canPartitionWithoutItem = canPartitionRecursive(nums, sum, index+1,partitionMap);
	    partitionMap.put(key, canPartitionWithItem ||canPartitionWithoutItem);
	    return (canPartitionWithItem ||canPartitionWithoutItem) ;
	}
	
	
	public static void main(String[]args) {
		System.out.println(canPartition(new int[]{1, 2, 3, 4}));
		System.out.println(canPartition(new int[]{1, 1, 3, 4, 7}));
		System.out.println(canPartition(new int[]{2, 3, 4, 6}));

	}


}
