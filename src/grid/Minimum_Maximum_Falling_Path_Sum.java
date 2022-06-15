package grid;

import java.util.Arrays;

// https://takeuforward.org/data-structure/minimum-maximum-falling-path-sum-dp-12/

// https://www.youtube.com/watch?v=N_aJ5qQbYA0&list=PLgUwDviBIf0qUlt5H_kiKYaNSqJ81PMMY&index=13



public class Minimum_Maximum_Falling_Path_Sum {
	
	public static void main(String[] args) {
		
		 int matrix[][] = {{1,2,10,4},
                 {100,3,2,1},
                 {1,1,20,2},
                 {1,2,2,1}};

		 System.out.println(getMaxPathSum(matrix));
		 
		 System.out.println(tabulate(matrix, matrix.length, matrix[0].length));

		 System.out.println(optimise(matrix, matrix.length, matrix[0].length));

	
	
	}

	
	static int getMaxPathSum(int[][] matrix){
		
		int m = matrix.length;
		
		int n = matrix[0].length;
		
		
		int[][] dp = new int[m][n];
		
		for(int row[] : dp)
		{
			Arrays.fill(row,-1);
			
		}
		
		int maxi = Integer.MIN_VALUE;
		
		
		for(int j=0; j<n; j++)
		{
			int ans = getMaxPathUtil(m-1,j,n,matrix,dp);
		
			maxi = Math.max(maxi, ans);
			
			
		}
		
		
		
		return maxi;
		
		
	}

	private static int getMaxPathUtil(int i, int j, int n, int[][] matrix, int[][] dp) {
		
		
		// Base Conditions
		

		if(j<0 || j>=n)
			return Integer.MIN_VALUE;
		
		if(i==0)
			return matrix[0][j];
			
		
		if(dp[i][j]!=-1) return dp[i][j];
			
		
		
		int up = matrix[i][j] + getMaxPathUtil(i-1,j,n,matrix,dp);
		
		int leftDiagonal = matrix[i][j] + getMaxPathUtil(i-1,j-1,n,matrix,dp);
		
		int rightDiagonal = matrix[i][j] + getMaxPathUtil(i-1,j+1,n,matrix,dp);
		
		return dp[i][j]= Math.max(up,Math.max(leftDiagonal,rightDiagonal));
		
		
	}

	
	
	private static int tabulate(int[][] matrix,int m,int n) {
		
		int[][] dp = new int[m][n];

		
		for(int j=0;j<n; j++)
		{
			dp[0][j]=matrix[0][j];
		}
		
		
		for(int i=1; i< m; i++)
		{

			for(int j=0; j< n; j++)
			{
				
				
				int leftDiagonal =matrix[i][j] ;
				
				int rightDiagonal = matrix[i][j];
				
				
				int up = matrix[i][j] + dp[i-1][j];
				
				if(j>=1)
				 leftDiagonal = leftDiagonal +  dp[i-1][j-1];
				
				 
					else leftDiagonal += (int)Math.pow(-10,9);
				
				if(j+1<n)
				
				 rightDiagonal = rightDiagonal+  dp[i-1][j+1];
				
				else rightDiagonal += (int)Math.pow(-10,9);
				
				dp[i][j]= Math.max(up,Math.max(leftDiagonal,rightDiagonal));
				
			}
				
			
			
		}

		
		int maxi = Integer.MIN_VALUE;
	    
	    for(int j=0; j<n;j++){
	        maxi = Math.max(maxi,dp[m-1][j]);
	    }
	    
	    return maxi;
		
		
		
	}

	

	
	private static int optimise(int[][] matrix,int m,int n) {
		
		int[] previous = new int[n];
		
		int[] current = new int[n];

		
		for(int j=0;j<n; j++)
		{
			previous[j]=matrix[0][j];
		}
		
		
		for(int i=1; i< m; i++)
		{

			for(int j=0; j< n; j++)
			{
				
				
				int leftDiagonal =matrix[i][j] ;
				
				int rightDiagonal = matrix[i][j];
				
				
				int up = matrix[i][j] + previous[j];
				
				if(j>=1)
				 leftDiagonal = leftDiagonal +  previous[j-1];
				
				 
					else leftDiagonal += (int)Math.pow(-10,9);
				
				if(j+1<n)
				
				 rightDiagonal = rightDiagonal+  previous[j+1];
				
				else rightDiagonal += (int)Math.pow(-10,9);
				
				current[j]= Math.max(up,Math.max(leftDiagonal,rightDiagonal));
				
			}
				
			
			previous = current;
			
		}

		
		int maxi = Integer.MIN_VALUE;
	    
	    for(int j=0; j<n;j++){
	        maxi = Math.max(maxi,previous[j]);
	    }
	    
	    return maxi;
		
		
		
	}


	
	
	
	
	
	
	
}
