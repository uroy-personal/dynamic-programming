package practice.knapsackunbounded;
import java.util.*;
public class MinimumCoinChangeTopDown {
	public static int minChangeCount(int[] denominations, int total) {
		Map<String, Integer> valueMap = new HashMap<String, Integer>();
		return minChangeCountRecursive(denominations, total, 0, valueMap); 
	  }
	
	public static int minChangeCountRecursive(int[] denominations, int total, int currentIndex, Map<String, Integer> valueMap) {
	    String key = total+"-"+currentIndex;
	    if(valueMap.containsKey(key)) {
	    	return valueMap.get(key);
	    }
		if(total==0) {
			valueMap.put(key, 0);
			return 0;
		}
		
		if(currentIndex>=denominations.length) {
			valueMap.put(key, Integer.MAX_VALUE);
			return Integer.MAX_VALUE;
		}
		int numberWithAddedCurrentIndex = Integer.MAX_VALUE;
		
		
		if(denominations[currentIndex]<=total) {
			
			// addedNumbers.add(denominations[currentIndex]);
			
			int res = minChangeCountRecursive(denominations, total-denominations[currentIndex], currentIndex, valueMap);
			if(res !=Integer.MAX_VALUE) {
				numberWithAddedCurrentIndex = res+1;
			}
		}
		int numberWithoutCurrentIndex =  minChangeCountRecursive(denominations, total, currentIndex+1, valueMap);
		// System.out.println("countWithCurrentElement --> "+numberWithAddedCurrentIndex + " countWithoutCurrentElement --> "+numberWithoutCurrentIndex+" currentIndex --> "+currentIndex);
		int minValue = Math.min(numberWithAddedCurrentIndex, numberWithoutCurrentIndex);
		valueMap.put(key, minValue);
	    return minValue;
	  }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] denominations = {1, 2, 3};
	    System.out.println(minChangeCount(denominations, 5));
	}

}
