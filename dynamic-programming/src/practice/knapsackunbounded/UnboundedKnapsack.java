package practice.knapsackunbounded;

public class UnboundedKnapsack {
	public static  int solveKnapsack(int[] profits, int[] weights, int capacity) {
	    return knapsackRecursive( profits, weights, capacity, 0);
	  }
	public static int knapsackRecursive(int[] profits, int[] weights, int capacity, int currentIndex) {
		if(currentIndex>=profits.length || capacity==0 || profits.length!=weights.length) {
			return 0;
		}
		
		int profitIncludingCurrentIndex=0;
		int profitExcludingCurrentIndex=0;
		
		if(weights[currentIndex]<=capacity) {
			profitIncludingCurrentIndex = profits[currentIndex]+knapsackRecursive(profits, weights, capacity-weights[currentIndex], currentIndex);
		}
		profitExcludingCurrentIndex = 	knapsackRecursive(profits, weights, capacity, currentIndex+1);
	    
		return Math.max(profitIncludingCurrentIndex, profitExcludingCurrentIndex);
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(solveKnapsack(new int[] {15,20,50}, new int[] {1,2,3},  5));
	}

}
