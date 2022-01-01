package practice.fibonacynumbers;

public class ArrayJumpBrutForce {
	public static int calculateMinimumJump(int[] jumps) {
		return calculateMinimumJumpRecursive(jumps, 0);
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
			int nextMinimumJump = calculateMinimumJumpRecursive(jumps, currentIndex + i) ;
			if ( nextMinimumJump != Integer.MAX_VALUE) {
				minimumJump = Math.min(minimumJump, 1 + nextMinimumJump);
			}
		}

		return minimumJump;
	}
	public static void main(String[] args) {
		System.out.println(calculateMinimumJump(new int[]{2,1,1,1,4}));
		System.out.println(calculateMinimumJump(new int[]{1, 1, 3, 6, 9, 3, 0, 1, 3}));
	}

}
