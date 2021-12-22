package practice.knapsackunbounded;
public class CutRibbonBottomUp {
	public static int countRibbonPieces(int[] ribbonLengths, int total) {
		
		int n = ribbonLengths.length;
		int[][] dp = new int[n][total+1];
		
		for(int i=0;i<n;i++) {
			for(int j=0;j<=total;j++) {
				dp[i][j] = Integer.MIN_VALUE;
			}
		}
		// populate the first column corresponding to 0 total, maximum number of pieces are 0 for 0 total length
		for(int i=0;i<n;i++) {
			dp[i][0] =0;
		}
		for(int i=0;i<n;i++) {
			for(int j=0;j<=total;j++) {
				if(i>0) {
					// exclude the current element
					dp[i][j] = dp[i-1][j];
				}
				// include the current element
				if(ribbonLengths[i]<=j) {
					if(dp[i][j-ribbonLengths[i]]!=Integer.MIN_VALUE) {
						dp[i][j] = Math.max(dp[i][j], 1+dp[i][j-ribbonLengths[i]]);
					}
				}
			}
		}
		return dp[n-1][total];
	}

	

	public static void main(String[] args) {
		System.out.println(countRibbonPieces(new int[]{3,5,7}, 13));
		System.out.println(countRibbonPieces(new int[]{2,3}, 7));
	}

}
