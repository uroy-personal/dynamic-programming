package practice.knapsackunbounded;

public class CutRibbonBrutForce {
	public static int countRibbonPieces(int[] ribbonLengths, int total) {
		return countRibbonPiecesRecursive(ribbonLengths,total, 0 );
	}

	public static int countRibbonPiecesRecursive(int[] ribbonLengths, int total, int currentIndex) {

		if (total == 0) {
			return 0;
		}

		if (currentIndex >= ribbonLengths.length) {
			return Integer.MIN_VALUE;
		}

		int noOfPiecesWithCurrentItem = Integer.MIN_VALUE;

		if (ribbonLengths[currentIndex] <= total) {
			int res = countRibbonPiecesRecursive(ribbonLengths, total - ribbonLengths[currentIndex], currentIndex);
			if (res != Integer.MIN_VALUE) {
				noOfPiecesWithCurrentItem = 1 + res;
			}
		}

		int noOfPiecesWithoutCurrentItem = countRibbonPiecesRecursive(ribbonLengths, total, currentIndex + 1);
		return Math.max(noOfPiecesWithCurrentItem, noOfPiecesWithoutCurrentItem);
	}

	public static void main(String[] args) {
		System.out.println(countRibbonPieces(new int[]{3,5,7}, 13));
		System.out.println(countRibbonPieces(new int[]{2,3}, 7));
	}

}
