package practice.knapsackunbounded;

public class RodCuttingBottomUp {
    
	public static int solveRodCutting(int[] lengths, int[] prices, int totalLength) {
		int count = lengths.length;
		int[][] dp = new int[count][totalLength+1];
		
		for(int i=0;i<count; i++) {
			dp[i][0] = 0;
		}
		for(int j=0;j<count;j++) {
			for(int k=1;k<=totalLength;k++) {
				/* price including the current element */
				int price1=0;
				/* price excluding the current element */
				int price2=0;
				
				if(lengths[j]<=k) {
					price1 = prices[j] + dp[j][k-lengths[j]];
				}
				if(j>0) {
				price2 = dp[j-1][k];
				}
				dp[j][k] = Math.max(price1, price2);
				
			}
		}
		return dp[count-1][totalLength];
    }
    
	public static void main(String[] args) {
		System.out.println(solveRodCutting(new int[] {1,2,3,4,5},new int[] {2, 6, 7, 10, 13} , 5));
	}

}
