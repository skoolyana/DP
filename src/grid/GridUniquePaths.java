package grid;

import java.util.Arrays;

// https://www.youtube.com/watch?v=sdE0A2Oxofw&list=PLgUwDviBIf0qUlt5H_kiKYaNSqJ81PMMY&index=9

// https://takeuforward.org/data-structure/grid-unique-paths-dp-on-grids-dp8/

public class GridUniquePaths {

	public static void main(String[] args) {

		int m = 3;
		int n = 2;

		System.out.println(countPaths(m, n));
		
		System.out.println(	countWaysTabulation(m, n));
	
	}

	public static int countPaths(int m, int n) {

		int[][] dp = new int[m][n];

		for (int[] row : dp) {
			Arrays.fill(row, -1);

		}

		return countWaysUtil(m - 1, n - 1, dp);

	}

	private static int countWaysUtil(int i, int j, int[][] dp) {

		if (i == 0 && j == 0)
			return 1;

		if (i < 0 || j < 0)
			return 0;

		if (dp[i][j] != -1)
			return dp[i][j];

		int up = countWaysUtil(i - 1, j, dp);

		int left = countWaysUtil(i, j - 1, dp);

		int sum = up + left;

		dp[i][j] = sum;

		// TODO Auto-generated method stub
		return sum;
	}

	private static int countWaysTabulation(int m, int n) {

		int[][] dp = new int[m][n];

		dp[0][0] = 1;

		int count = 0;

		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if (i == 0 && j == 0)
					continue;

				int up = 0;

				int left = 0;

				if (i >= 1)

					up = dp[i - 1][j];

				if (j >= 1)
					left = dp[i][j - 1];

				dp[i][j] = up + left;

			}

		}

		// TODO Auto-generated method stub
		return dp[m - 1][n - 1];
	}

}
