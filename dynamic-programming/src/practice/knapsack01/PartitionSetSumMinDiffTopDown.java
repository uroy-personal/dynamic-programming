package practice.knapsack01;
import java.util.*;
public class PartitionSetSumMinDiffTopDown {
	static int canPartition(int[] num) {
		Map<String, Integer>  partitionSetMap = new HashMap<String, Integer>();
		return canPartitionRecursive(num, 0,0, 0, partitionSetMap);
	}
	
	static int canPartitionRecursive(int[] num, int sum1, int sum2, int index, Map<String, Integer>  partitionSetMap) {
		String key = index+"-"+sum1;
		if(partitionSetMap.containsKey(key)) {
			return partitionSetMap.get(key);
		}
		if(index>=num.length) {
			partitionSetMap.put(key, Math.abs(sum1-sum2));
			return Math.abs(sum1-sum2);
		}
		
		int sum1IncludingNumber = canPartitionRecursive(num, sum1+num[index], sum2, index+1,partitionSetMap);
		int sum2IncludingNumber = canPartitionRecursive(num, sum1, sum2+num[index], index+1,partitionSetMap);
		partitionSetMap.put(key, Math.min(sum1IncludingNumber,sum2IncludingNumber));
		return Math.min(sum1IncludingNumber,sum2IncludingNumber);
	}
	
	
	
	public static void main(String[] args) {
		System.out.println(canPartition(new int[]{1, 2, 3, 9}));
		System.out.println(canPartition(new int[]{1, 2, 7, 1, 5}));
		System.out.println(canPartition(new int[]{1, 3, 100, 4}));
	}

}
