package practice.fibonacynumbers;
/*
 * Express with 1, 3 & 4
 */
import java.util.*;
public class NumberFactorTopDown {
	public static int countWays(int n) {
		Map<Integer, Integer> map = new HashMap<>(); 
		return countWaysRecursive(n, map);
	}
	public static int countWaysRecursive(int n, Map<Integer, Integer> map) {
		if(map.get(n)!=null) {
			return map.get(n);
		}
		if(n==0) {
			map.put(n, 1);
			return 1;
		}
		// base case 1 , {1}
		if(n==1) {
			map.put(n, 1);
			return 1;
		}
		// base case 2 ,  {1,1}
		if(n==2) {
			map.put(n, 1);
			return 1;
		}
		// base case 3 {1,1,1}, {3}
		if(n==3) {
			map.put(n, 2);
			return 2;
		}
		
		int countWithOne = countWays(n-1);
		int countWithThree = countWays(n-3);
		int countWithFour = countWays(n-4);
		int totalCount = countWithOne+countWithThree+countWithFour;
		map.put(n, totalCount);
		return totalCount;
		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
	    System.out.println(countWays(4));
	    System.out.println(countWays(5));
	    System.out.println(countWays(6));
	}

}
