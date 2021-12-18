package practice.knapsackunbounded;

public class RodCuttingBrutForce {
    public static int solveRodCutting(int[] lengths, int[] prices, int n) {
		    return solveRodCuttingRecursive(lengths, prices, n, 0 );
		    
    }
    public static int solveRodCuttingRecursive(int[] lengths, int[] prices, int totalLength, int currentIndex) {
    	if(currentIndex>=lengths.length || lengths.length != prices.length || totalLength ==0) {
    		return 0;
    	}
    	int priceWithElementInCurrentIndex=0;
    	int priceWithoutElementInCurrentIndex=0;
    	if(lengths[currentIndex]<=totalLength) {
    		priceWithElementInCurrentIndex = prices[currentIndex]+solveRodCuttingRecursive(lengths, prices, totalLength-lengths[currentIndex], currentIndex);
    	}
    	
    	priceWithoutElementInCurrentIndex = solveRodCuttingRecursive(lengths, prices, totalLength, currentIndex+1);
    	
    	return Math.max(priceWithElementInCurrentIndex, priceWithoutElementInCurrentIndex);
    }
	public static void main(String[] args) {
		System.out.println(solveRodCutting(new int[] {1,2,3,4,5},new int[] {2, 6, 7, 10, 13} , 5));
	}

}
