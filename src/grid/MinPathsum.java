package grid;

import java.util.Arrays;
import java.util.Currency;

// https://takeuforward.org/data-structure/minimum-path-sum-in-a-grid-dp-10/

// https://www.youtube.com/watch?v=_rgTlyky1uQ&list=PLgUwDviBIf0qUlt5H_kiKYaNSqJ81PMMY&index=11


// https://takeuforward.org/data-structure/minimum-path-sum-in-a-grid-dp-10/




public class MinPathsum {

	
	static int minPathSum(int m, int n,int[][]matrix)
	{
		int[][]dp = new int[m][n];
		
		for(int[] row : dp)
		{
			Arrays.fill(row, -1);
			
			
		}
		
		
		
		
		return minPathSumUtil(m-1, n-1,matrix,dp);
		
		
		
		
	}

	private static int minPathSumUtil(int i, int j, int[][] matrix, int[][] dp) {
	
		if(i==0 && j==0)
			return matrix[0][0];
		
		if(i<0 || j< 0)
		{
			return (int)Math.pow(10, 9);
			
		}
		
		if(dp[i][j]!=-1)
		{
			return dp[i][j];
			
		}
		
		
		int up = matrix[i][j]+minPathSumUtil(i-1, j, matrix, dp);
		
		int left = matrix[i][j]+minPathSumUtil(i, j-1, matrix, dp);
		
		
		// TODO Auto-generated method stub
		return dp[i][j]=Math.min(up, left);
	}

	
	
	private static int tabulate(int m, int n, int[][] matrix) {
		
		int[][] dp = new int[m][n];
				
		
		for(int i=0; i<m; i++)
		{

			for(int j=0; j<n; j++)
			{
				
				if(i==0 && j==0)
				{
					dp[0][0] = matrix[0][0];
				
					continue;
				}
				
				
				int up = 0;
				
				int left = 0;
				
				
				if(i>=1)
				up = matrix[i][j]+ dp[i-1][j];
				else
					up+=(int)Math.pow(10, 9);
				
				
				
				if(j>=1)
				left = matrix[i][j]+ dp[i][j-1];
				
				else
					left+=(int)Math.pow(10, 9);
				
				dp[i][j]=Math.min(up, left);
				
			}
				
			
			
		}
		
		
		
		
		// TODO Auto-generated method stub
		return dp[m-1][n-1];
	}


	
	
	
	private static int optimise(int m, int n, int[][] matrix) {
		
		int[] previous = new int[n];
				
		
		for(int i=0; i<m; i++)
		{
			int[]current = new int[n];

			for(int j=0; j<n; j++)
			{
				
				if(i==0 && j==0)
				{
					current[0] = matrix[0][0];
				
					continue;
				}
				
				
				int up = 0;
				
				int left = 0;
				
				
				if(i>=1)
				up = matrix[i][j]+ previous[j];
				else
					up+=(int)Math.pow(10, 9);
				
				
				
				if(j>=1)
				left = matrix[i][j]+ current[j-1];
				
				else
					left+=(int)Math.pow(10, 9);
				
				current[j]=Math.min(up, left);
				
			}
				
			previous = current;
			
		}
		
		
		
		
		// TODO Auto-generated method stub
		return previous[n-1];
	}
	

	
	public static void main(String[] args) {
		
		  int matrix[][] = {{5,9,6},{11,5,2}};
         
		  int m = matrix.length;
		  int n = matrix[0].length;
		  
		  System.out.println(minPathSum(m,n,matrix));
		  
		  System.out.println(tabulate(m, n, matrix));
		  
		  System.out.println(optimise(m, n, matrix));
		  
		  
	}
}
