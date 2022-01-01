package practice.fibonacynumbers;

public class ArrayJumpBottomUp {
	public static int calculateMinimumJump(int[] jumps) {
		int l = jumps.length;
		int[] dp = new int[l];
		
		dp[0] =0;
		for(int i=1; i<jumps.length;i++) {
			dp[i] = Integer.MAX_VALUE;
		}
		for(int start=0; start<jumps.length;start++ ) {
			for(int end=start+1;end<=start+jumps[start] && end <jumps.length;end++) {
				dp[end] = Math.min(dp[end], 1+dp[start]);
			}
		}
		return dp[l-1];
	}

	public static int calculateMinimumJumpRecursive(int[] jumps, int currentIndex) {
		int minimumJump = Integer.MAX_VALUE;
		if (currentIndex >= jumps.length - 1) {
			return 0;
		}
		if (jumps[currentIndex] == 0) {
			return Integer.MAX_VALUE;
		}

		for (int i = 1; i <= jumps[currentIndex]; i++) {
			if (calculateMinimumJumpRecursive(jumps, currentIndex + i) != Integer.MAX_VALUE) {
				minimumJump = Math.min(minimumJump, 1 + calculateMinimumJumpRecursive(jumps, currentIndex + i));
			}
		}

		return minimumJump;
	}
	public static void main(String[] args) {
		System.out.println(calculateMinimumJump(new int[]{2,1,1,1,4}));
		System.out.println(calculateMinimumJump(new int[]{1, 1, 3, 6, 9, 3, 0, 1, 3}));
	}

}
