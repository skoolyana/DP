package basics;

import java.util.Scanner;

// https://www.youtube.com/watch?v=Zobz9BXpwYE&list=PL-Jc9J83PIiG8fE6rj9F5a6uyQ5WPdqKy&index=5

// https://www.pepcoding.com/resources/online-java-foundation/dynamic-programming-and-greedy/climb-stairs-with-minimum-moves-official/ojquestion


// https://www.pepcoding.com/resources/online-java-foundation/dynamic-programming-and-greedy/climb_stairs_with_minimum_moves/topic



public class ClimbStairsWithMinMoves {

	public static void main(String[] args) {

		
		int[] arr = new int[]{3, 2, 4, 2, 0, 2, 3, 1, 2, 2};
		
		
		

		int n = 10;

		Integer[] dp = new Integer[n + 1];
		dp[n] = 0;

		for (int i = n - 1; i >= 0; i--) {
			if (arr[i] == 0)
				continue;
			int min = Integer.MAX_VALUE;
			for (int j = 1; j <= arr[i] && i + j < dp.length; j++) {
				if (dp[i + j] != null) {
					min = Math.min(min, dp[i + j]);
				}
			}
			if (min != Integer.MAX_VALUE)
				dp[i] = min + 1;
		}
		
		 System.out.println(dp[0]);
	

	}

}
