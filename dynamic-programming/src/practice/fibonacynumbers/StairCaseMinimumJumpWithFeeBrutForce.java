package practice.fibonacynumbers;

public class StairCaseMinimumJumpWithFeeBrutForce {
	public static int findMinFee(int[] fee) {
		    // TODO: Write your code here
		    return findMinFeeRecursive(fee,0);
    }
	
	public static int findMinFeeRecursive(int[] fee, int currentIndex) {
	    
		if(currentIndex>=fee.length) {
			return 0;
		}
		
		int costWithOneStep = fee[currentIndex]+findMinFeeRecursive(fee, currentIndex+1);
		int costWithTwoStep = fee[currentIndex]+findMinFeeRecursive(fee, currentIndex+2);
		int costWithThreeStep = fee[currentIndex]+findMinFeeRecursive(fee, currentIndex+3);
		
	    return Math.min(Math.min(costWithOneStep, costWithTwoStep), costWithThreeStep);
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(findMinFee(new int[] {1,2,5,2,1,2}));
		System.out.println(findMinFee(new int[] {2,3,4,5}));
	}

}
