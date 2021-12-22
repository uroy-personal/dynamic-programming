package practice.knapsackunbounded;

public class CoinChangeBrutForce {
	public static int countChange(int[] denominations, int total) {
	    return countChangeRecursive(denominations, total, 0);
	  }
	public static int countChangeRecursive(int[] denominations, int total, int currentIndex) {
		if(total==0) {
			return 1;
		}
		if(denominations.length ==0 ||  currentIndex>=denominations.length) {
			return 0;
		}
		int countWithCurrentElement =0;
		int countWithoutCurrentElement =0;
		
		if(denominations[currentIndex]<=total) {
			countWithCurrentElement = countChangeRecursive(denominations, total-denominations[currentIndex], currentIndex);
		}
		countWithoutCurrentElement = countChangeRecursive(denominations, total, currentIndex+1);
	    
		int totalways =0;
	    totalways = countWithCurrentElement+countWithoutCurrentElement;
	    
		return totalways;
	  }
	public static void main(String[] args) {
		System.out.println(countChange(new int[] {1, 2, 3}, 5));
	}

}
