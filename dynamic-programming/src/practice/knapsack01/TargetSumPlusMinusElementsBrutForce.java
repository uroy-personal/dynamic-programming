package practice.knapsack01;

import java.util.Date;

public class TargetSumPlusMinusElementsBrutForce {
	public static int findTargetSubsets(int[] num, int s) {
			int totalSum = 0;
			int negativeSum =0;
			for(int n:num) {
				totalSum+=n;
			}
			negativeSum = (totalSum-s)/2;
		    
			return findTargetSubsetsRecursive(num, negativeSum,0);
		  }
	
	public static int findTargetSubsetsRecursive(int[] num, int negativeSum, int currentIndex) {
		
		if(negativeSum==0) {
			return 1;
		}
		
		if(currentIndex>=num.length) {
			return 0;
		}
		
		int countUsingCurrentElement =0;
		int countExcludingCurrentElement =0;
		
		if(num[currentIndex]<=negativeSum) {
			countUsingCurrentElement = findTargetSubsetsRecursive(num, negativeSum-num[currentIndex], currentIndex+1);
		}
		countExcludingCurrentElement = findTargetSubsetsRecursive(num, negativeSum, currentIndex+1);
		
		return countUsingCurrentElement+countExcludingCurrentElement;
		
	  }
	public static void main(String[] args) {
		long startTime = new Date().getTime();
		System.out.println(findTargetSubsets(new int[] {1, 1, 2, 3}, 1));
		System.out.println(findTargetSubsets(new int[] {1, 2, 7, 1}, 9));
		long endTime = new Date().getTime();
		System.out.println(" ::: Execution time ::: "+(endTime-startTime));
	}

}
