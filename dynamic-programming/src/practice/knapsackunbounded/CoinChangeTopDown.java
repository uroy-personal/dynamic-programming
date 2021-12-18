package practice.knapsackunbounded;
import java.util.*;
public class CoinChangeTopDown {
	public static int countChange(int[] denominations, int total) {
		Map<String, Integer> keyValueMap = new HashMap<String, Integer>();
	    return countChangeRecursive(denominations, total, 0, keyValueMap);
	  }
	public static int countChangeRecursive(int[] denominations, int total, int currentIndex, Map<String, Integer> keyValueMap) {
		String key = total + "-"+currentIndex;
		if(total==0) {
			keyValueMap.put(key, 1);
			return 1;
		}
		if(denominations.length ==0 ||  currentIndex>=denominations.length) {
			keyValueMap.put(key, 0);
			return 0;
		}
		int countWithCurrentElement =0;
		int countWithoutCurrentElement =0;
		
		if(denominations[currentIndex]<=total) {
			countWithCurrentElement = countChangeRecursive(denominations, total-denominations[currentIndex], currentIndex, keyValueMap);
		}
		countWithoutCurrentElement = countChangeRecursive(denominations, total, currentIndex+1, keyValueMap);
	    int totalways =0;
	    totalways = countWithCurrentElement+countWithoutCurrentElement;
	    keyValueMap.put(key, totalways);
		return totalways;
	  }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(countChange(new int[] {1, 2, 3}, 5));
	}

}
