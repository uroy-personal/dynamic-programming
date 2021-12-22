package practice.knapsackunbounded;
import java.util.*;
public class CutRibbonTopDown {
	public static int countRibbonPieces(int[] ribbonLengths, int total) {
		Map<String, Integer> valueMap =  new HashMap<String,Integer>();
		return countRibbonPiecesRecursive(ribbonLengths,total, 0, valueMap );
	}

	public static int countRibbonPiecesRecursive(int[] ribbonLengths, int total, int currentIndex, Map<String, Integer> valueMap) {
		String key = total+"-"+currentIndex;
		if(valueMap.containsKey(key)) {
			return valueMap.get(key);
		}
		if (total == 0) {
			valueMap.put(key, 0);
			return 0;
		}

		if (currentIndex >= ribbonLengths.length) {
			valueMap.put(key, Integer.MIN_VALUE);
			return Integer.MIN_VALUE;
		}

		int noOfPiecesWithCurrentItem = Integer.MIN_VALUE;

		if (ribbonLengths[currentIndex] <= total) {
			int res = countRibbonPiecesRecursive(ribbonLengths, total - ribbonLengths[currentIndex], currentIndex, valueMap);
			if (res != Integer.MIN_VALUE) {
				noOfPiecesWithCurrentItem = 1 + res;
			}
		}

		int noOfPiecesWithoutCurrentItem = countRibbonPiecesRecursive(ribbonLengths, total, currentIndex + 1, valueMap);
		int maxPieces = Math.max(noOfPiecesWithCurrentItem, noOfPiecesWithoutCurrentItem);
		valueMap.put(key, maxPieces);
		return maxPieces;
	}

	public static void main(String[] args) {
		System.out.println(countRibbonPieces(new int[]{3,5,7}, 13));
		System.out.println(countRibbonPieces(new int[]{2,3}, 7));
	}

}
