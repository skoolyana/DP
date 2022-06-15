package grid;

import java.util.Arrays;

// https://www.youtube.com/watch?v=SrP-PiLSYC0&list=PLgUwDviBIf0qUlt5H_kiKYaNSqJ81PMMY&index=12

// https://takeuforward.org/data-structure/minimum-path-sum-in-triangular-grid-dp-11/



public class Triangle {
	
	
	public static void main(String[] args) {
		
		int triangle [][] = {{1},
                {2,3},
                {3,6,7},
                {8,9,6,10}};
                     
		int n = triangle.length;

		System.out.println(minimumPathSum(triangle,n));

		System.out.println(tabulate(triangle, n));
		
		System.out.println(optimise(triangle, n));

	}
	
	static int minimumPathSum(int[][] triangle, int n){
		
		int[][] dp = new int[n][n];
		
		
		for(int[] row: dp)
		{
			Arrays.fill(row,-1);
			
		}
		
		 return minimumPathSumUtil(0,0,triangle,n,dp);
		
		
		
		
	}

	private static int minimumPathSumUtil(int i, int j, int[][] triangle, int n, int[][] dp) {
		
		if(dp[i][j]!=-1)
		{
			return dp[i][j];
		}
		
		
		
		if(i==n-1)
			return triangle[i][j];
		
		

		int down = triangle[i][j] + minimumPathSumUtil(i+1, j, triangle, n, dp);


		int diagonal = triangle[i][j] + minimumPathSumUtil(i+1, j+1, triangle, n, dp);
		
		// TODO Auto-generated method stub
		return Math.min(down, diagonal);
	}
	
	
	
	private static int tabulate(int[][] triangle, int n) {
		
		
		int[][] dp = new int[n][n];
		
		for(int j=0;j<n;j++){
	        dp[n-1][j] = triangle[n-1][j];
	    }
		
		for(int i=n-2; i>=0; i--){
	        for(int j=i; j>=0; j--){

				int down = triangle[i][j] + dp[i+1][j];
				
				int diagonal = triangle[i][j] + dp[i+1][j+1];


				dp[i][j] = Math.min(down, diagonal);

	        }
		
		}
		return dp[0][0];
	}

	

	private static int optimise(int[][] triangle, int n) {
		
		
		int[] next = new int[n];
		int[] current = new int[n];
		
		
		for(int j=0;j<n;j++){
			next[j] = triangle[n-1][j];
	    }
		
		for(int i=n-2; i>=0; i--){
		
			
			
	        for(int j=i; j>=0; j--){

				int down = triangle[i][j] + next[j];
				
				int diagonal = triangle[i][j] + next[j+1];


				current[j] = Math.min(down, diagonal);

	        }
		
	        
	        next = current;
	        
	        
		}
		return next[0];
	}

	
	
	
}
