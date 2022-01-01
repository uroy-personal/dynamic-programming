package practice.fibonacynumbers;

import java.util.*;

public class StairCaseMinimumJumpWithFeeTopDown {
	public static int findMinFee(int[] fee) {
		// TODO: Write your code here
		Map<Integer, Integer> minJumpMap = new HashMap<Integer, Integer>();
		return findMinFeeRecursive(fee, 0, minJumpMap);
	}

	public static int findMinFeeRecursive(int[] fee, int currentIndex, Map<Integer, Integer> minJumpMap) {

		if (minJumpMap.get(currentIndex) != null) {
			return minJumpMap.get(currentIndex);
		}

		if (currentIndex >= fee.length) {
			minJumpMap.put(currentIndex, 0);
			return 0;
		}

		int costWithOneStep = fee[currentIndex] + findMinFeeRecursive(fee, currentIndex + 1, minJumpMap);
		int costWithTwoStep = fee[currentIndex] + findMinFeeRecursive(fee, currentIndex + 2, minJumpMap);
		int costWithThreeStep = fee[currentIndex] + findMinFeeRecursive(fee, currentIndex + 3, minJumpMap);
		int minCost = Math.min(Math.min(costWithOneStep, costWithTwoStep), costWithThreeStep);
		minJumpMap.put(currentIndex, minCost);
		return minCost;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(findMinFee(new int[] { 1, 2, 5, 2, 1, 2 }));
		System.out.println(findMinFee(new int[] { 2, 3, 4, 5 }));
	}

}
