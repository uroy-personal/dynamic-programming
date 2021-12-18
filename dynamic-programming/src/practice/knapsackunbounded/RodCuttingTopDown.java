package practice.knapsackunbounded;
import java.util.*;
public class RodCuttingTopDown {
    public static int solveRodCutting(int[] lengths, int[] prices, int n) {
    	Map<String, Integer>  map = new HashMap<String,Integer>();
		return solveRodCuttingRecursive(lengths, prices, n, 0, map );
		    
    }
    public static int solveRodCuttingRecursive(int[] lengths, int[] prices, int totalLength, int currentIndex, Map<String, Integer>  map) {
    	String key = currentIndex+"-"+totalLength;
    	if(currentIndex>=lengths.length || lengths.length != prices.length || totalLength ==0) {
    		map.put(key, 0);
    		return 0;
    	}
    	int priceWithElementInCurrentIndex=0;
    	int priceWithoutElementInCurrentIndex=0;
    	if(lengths[currentIndex]<=totalLength) {
    		priceWithElementInCurrentIndex = prices[currentIndex]+solveRodCuttingRecursive(lengths, prices, totalLength-lengths[currentIndex], currentIndex, map);
    	}
    	
    	priceWithoutElementInCurrentIndex = solveRodCuttingRecursive(lengths, prices, totalLength, currentIndex+1, map);
    	
    	int maxPrice = Math.max(priceWithElementInCurrentIndex, priceWithoutElementInCurrentIndex);
    	map.put(key, maxPrice);
    	return maxPrice;
    }
	public static void main(String[] args) {
		System.out.println(solveRodCutting(new int[] {1,2,3,4,5},new int[] {2, 6, 7, 10, 13} , 5));
	}

}
