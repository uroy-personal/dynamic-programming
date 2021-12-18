package practice.knapsackunbounded;
import java.util.*;
public class UnboundedKnapsackTopDown {
	public static  int solveKnapsack(int[] profits, int[] weights, int capacity) {
		Map<String, Integer> keyValueMap = new HashMap<String, Integer>();
		
	    return knapsackRecursive( profits, weights, capacity, 0, keyValueMap);
	  }
	public static int knapsackRecursive(int[] profits, int[] weights, int capacity, int currentIndex, Map<String, Integer> keyValueMap) {
		String key = capacity+"-"+currentIndex;
		if(keyValueMap.containsKey(key)) {
			return keyValueMap.get(key);
		}
		if(currentIndex>=profits.length || capacity==0 || profits.length!=weights.length) {
			keyValueMap.put(key, 0);
			return 0;
		}
		
		int profitIncludingCurrentIndex=0;
		int profitExcludingCurrentIndex=0;
		
		if(weights[currentIndex]<=capacity) {
			profitIncludingCurrentIndex = profits[currentIndex]+knapsackRecursive(profits, weights, capacity-weights[currentIndex], currentIndex, keyValueMap);
		}
		profitExcludingCurrentIndex = 	knapsackRecursive(profits, weights, capacity, currentIndex+1, keyValueMap);
	    int maxProfit = Math.max(profitIncludingCurrentIndex, profitExcludingCurrentIndex);
	    keyValueMap.put(key, maxProfit);
		return maxProfit;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(solveKnapsack(new int[] {15,20,50}, new int[] {1,2,3},  5));
	}

}
