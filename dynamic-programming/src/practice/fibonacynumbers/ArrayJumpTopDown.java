package practice.fibonacynumbers;
import java.util.*;
public class ArrayJumpTopDown {
	public static int calculateMinimumJump(int[] jumps) {
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		return calculateMinimumJumpRecursive(jumps, 0, map);
	}

	public static int calculateMinimumJumpRecursive(int[] jumps, int currentIndex, Map<Integer, Integer> map) {
		if(map.containsKey(currentIndex)) {
			return map.get(currentIndex);
		}
		int minimumJump = Integer.MAX_VALUE;
		if (currentIndex >= jumps.length - 1) {
			map.put(currentIndex, 0);
			return 0;
		}
		if (jumps[currentIndex] == 0) {
			map.put(currentIndex, Integer.MAX_VALUE);
			return Integer.MAX_VALUE;
		}

		for (int i = 1; i <= jumps[currentIndex]; i++) {
			
			int nextMinimumJump = calculateMinimumJumpRecursive(jumps, currentIndex + i, map) ;
			if ( nextMinimumJump != Integer.MAX_VALUE) {
				minimumJump = Math.min(minimumJump, 1 + nextMinimumJump);
			}
		}
		map.put(currentIndex, minimumJump);
		return minimumJump;
	}
	public static void main(String[] args) {
		System.out.println(calculateMinimumJump(new int[]{2,1,1,1,4}));
		System.out.println(calculateMinimumJump(new int[]{1, 1, 3, 6, 9, 3, 0, 1, 3}));
	}

}
