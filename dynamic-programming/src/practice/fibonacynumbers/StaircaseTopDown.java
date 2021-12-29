package practice.fibonacynumbers;
import java.util.*;
public class StaircaseTopDown {
	
	public static int countWays(int n) {
		// there is only one way for no steps
		Map<Integer, Integer> countMap = new HashMap<Integer, Integer>();
        return countWaysRecursive(n,countMap );
		
	}
	public static int countWaysRecursive(int n, Map<Integer, Integer> countMap) {
		// there is only one way for no steps
		
		if(n==0) {
			countMap.put(n, 1);
			return 1;
		}
		// we can take one step to reach and that is the only way
		if(n==1) {
			countMap.put(n, 1);
			return 1;
		}
		// we can take one step twice or jump two steps to reach the top
		if(n==2) {
			countMap.put(n, 2);
			return 2;
		}
		
		int countWithOneStep = countWays(n-1);
		int countWithTwoSteps = countWays(n-2);
		int countWithThreeSteps =  countWays(n-3);
		
		int totalWays = countWithOneStep+countWithTwoSteps+countWithThreeSteps;
		
		countMap.put(n, totalWays);
		
		return totalWays;
		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(countWays(3));
		System.out.println(countWays(4));
	}

}
