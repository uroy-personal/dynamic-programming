package practice.knapsack01;
import java.util.*;
public class CountSubsetSumTopDown {
    static int countSubsets(int[] num, int sum) {
        Map<String, Integer> subsetCountMap =  new HashMap<String, Integer>();
		return countSubsetsRecursive(num, sum, 0, subsetCountMap);
    }
    static int countSubsetsRecursive(int[] num, int sum, int index, Map<String, Integer> subsetCountMap) {
    	String key = index+"-"+sum;
    	if(subsetCountMap.containsKey(key)) {
    		return subsetCountMap.get(key);
    	}
    	int subsetCount = 0;
    	if(sum==0) {
    		subsetCountMap.put(key, 1);
    		return 1;
    	}
    	if(index>=num.length || num.length==0) {
    		subsetCountMap.put(key, 0);
    		return 0;
    	}
    	
    	int countWithCurrentIndex =  0 ;
    	if(num[index]<=sum) {
    		countWithCurrentIndex = countSubsetsRecursive(num, sum-num[index], index+1,subsetCountMap );
    	}
    	int countWithOutCurrentIndex = countSubsetsRecursive(num, sum, index+1, subsetCountMap);
    	
    	subsetCount = countWithOutCurrentIndex+countWithCurrentIndex;
    	subsetCountMap.put(key, subsetCount);
    	return subsetCount;
    }
    private static int countSubsetsRecursive2(int[] num, int sum, int currentIndex) {
        // base checks
        if (sum == 0)
          return 1;

        if(num.length == 0 || currentIndex >= num.length)
          return 0;

        // recursive call after selecting the number at the currentIndex
        // if the number at currentIndex exceeds the sum, we shouldn't process this
        int sum1 = 0;
        if( num[currentIndex] <= sum )
          sum1 = countSubsetsRecursive2(num, sum - num[currentIndex], currentIndex + 1);

        // recursive call after excluding the number at the currentIndex
        int sum2 = countSubsetsRecursive2(num, sum, currentIndex + 1);

        return sum1 + sum2;
      }
	public static void main(String[] args) {
		System.out.println(countSubsets(new int[] {1, 1, 2, 3}, 4));
		System.out.println(countSubsets(new int[] {1, 2, 7, 1, 5}, 9));
	}

}
