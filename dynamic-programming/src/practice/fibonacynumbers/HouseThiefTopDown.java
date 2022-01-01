package practice.fibonacynumbers;
import java.util.*;
public class HouseThiefTopDown {
	public static int maxStealing(int amounts[]) {
		Map<Integer, Integer> stealMap =  new HashMap<Integer, Integer>();
		return maxStealingRecursive(amounts, 0, stealMap);
	}
	public static int maxStealingRecursive(int amounts[], int currentIndex, Map<Integer, Integer> stealMap) {
		if(stealMap.get(currentIndex)!=null) {
			return stealMap.get(currentIndex);
		}
		if(currentIndex>=amounts.length) {
			stealMap.put(currentIndex, 0);
			return 0;
		}
		
		int stealFromCurrent = amounts[currentIndex]+maxStealingRecursive(amounts, currentIndex+2, stealMap);
		int skipStealFromCurrent =maxStealingRecursive(amounts, currentIndex+1, stealMap);
		
		int maxSteal = Math.max(stealFromCurrent, skipStealFromCurrent);
		
		stealMap.put(currentIndex, maxSteal);
		
		return maxSteal;
	}
	public static void main(String[] args) {
		System.out.println(maxStealing(new int[]{2, 5, 1, 3, 6, 2, 4}));
		System.out.println(maxStealing(new int[]{2, 10, 14, 8, 1}));
		
	}

}
