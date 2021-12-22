package practice.knapsackunbounded;

public class MinimumCoinChangeBrutForce {
	public static int minChangeCount(int[] denominations, int total) {
		return minChangeCountRecursive(denominations, total, 0);
	  }
	
	public static int minChangeCountRecursive(int[] denominations, int total, int currentIndex) {
	    
		if(total==0) {
			return 0;
		}
		
		if(currentIndex>=denominations.length) {
			return Integer.MAX_VALUE;
		}
		int numberWithAddedCurrentIndex = Integer.MAX_VALUE;
		
		
		if(denominations[currentIndex]<=total) {
			
			// addedNumbers.add(denominations[currentIndex]);
			
			int res = minChangeCountRecursive(denominations, total-denominations[currentIndex], currentIndex);
			if(res !=Integer.MAX_VALUE) {
				numberWithAddedCurrentIndex = res+1;
			}
		}
		int numberWithoutCurrentIndex =  minChangeCountRecursive(denominations, total, currentIndex+1);
		// System.out.println("countWithCurrentElement --> "+numberWithAddedCurrentIndex + " countWithoutCurrentElement --> "+numberWithoutCurrentIndex+" currentIndex --> "+currentIndex);
		
	    return Math.min(numberWithAddedCurrentIndex, numberWithoutCurrentIndex);
	  }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] denominations = {1, 2, 3};
	    System.out.println(minChangeCount(denominations, 5));
	}

}
