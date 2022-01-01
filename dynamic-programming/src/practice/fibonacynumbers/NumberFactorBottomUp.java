package practice.fibonacynumbers;

/*
 * Express with 1, 3 & 4
 */
public class NumberFactorBottomUp {
	public static int countWays(int n) {

		int[] dp = new int[n + 1];
		dp[0] = 1;
		dp[1] = 1;
		dp[2] = 1;
		dp[3] = 2;

		for (int j = 4; j <= n; j++) {
			dp[j] = dp[j - 1] + dp[j - 3] + dp[j - 4];
		}

		return dp[n];

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(countWays(4));
		System.out.println(countWays(5));
		System.out.println(countWays(6));
	}

}
