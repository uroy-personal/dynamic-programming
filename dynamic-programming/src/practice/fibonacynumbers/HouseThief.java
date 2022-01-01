package practice.fibonacynumbers;

public class HouseThief {
	public static int maxStealing(int amounts[]) {
		
		return maxStealingRecursive(amounts, 0);
	}
	public static int maxStealingRecursive(int amounts[], int currentIndex) {
		if(currentIndex>=amounts.length) {
			return 0;
		}
		
		int stealFromCurrent = amounts[currentIndex]+maxStealingRecursive(amounts, currentIndex+2);
		int skipStealFromCurrent =maxStealingRecursive(amounts, currentIndex+1);
		
		
		return Math.max(stealFromCurrent, skipStealFromCurrent);
	}
	public static void main(String[] args) {
		System.out.println(maxStealing(new int[]{2, 5, 1, 3, 6, 2, 4}));
		System.out.println(maxStealing(new int[]{2, 10, 14, 8, 1}));
	}

}
