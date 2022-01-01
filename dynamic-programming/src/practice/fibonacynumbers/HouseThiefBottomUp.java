package practice.fibonacynumbers;

import java.util.Arrays;

public class HouseThiefBottomUp {
	public static int maxStealing(int amounts[]) {
		int l = amounts.length;
		int dp[] = new int[l+1];
		
		dp[0] = 0;
		dp[1] = amounts[0];
		
		for(int i=1;i<l;i++) {
			dp[i+1] = Math.max(dp[i], amounts[i]+dp[i-1]);
		}
		// System.out.println(Arrays.toString(dp));
		return dp[l];
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
