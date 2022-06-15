package grid;

import java.util.Arrays;

// https://www.youtube.com/watch?v=TmhpgXScLyY&list=PLgUwDviBIf0qUlt5H_kiKYaNSqJ81PMMY&index=10


// https://takeuforward.org/data-structure/grid-unique-paths-2-dp-9/


public class MazeObstacles {
	
	public static void main(String[] args) {
		
		 int[][] maze = { {0,0,0},
                 {0,-1,0},
                 {0,0,0}};
                          
int n = maze.length;
int m = maze.length;

System.out.println(countPaths(n,m,maze));

System.out.println(spaceoptim(n,m,maze));

System.out.println(countWaysTabulation(n, m, maze));
		
		
	}
	
	public static int countPaths(int m , int n,int[][] maze)
	{
		
		int[][]dp = new int[m][n];
		
		for(int[] row : dp)
		{
			Arrays.fill(row, -1);
			
			
		}
		
		
		
		return countWaysUtil(m-1, n-1, maze,dp);
		
		
	
		
	}

	private static int countWaysUtil(int i, int j, int[][] maze,int[][] dp) {


		if(i>=0 && j>=0 && maze[i][j]==-1)
			return 0;
		
		if(i==0 && j==0)
			return 1;
		
		if(i<0 || j<0)
		    return 0;
		
		if(dp[i][j]!=-1)
			return dp[i][j];
		
		
		int up = countWaysUtil(i-1,j,maze,dp);
		
		int left = countWaysUtil(i,j-1,maze,dp);
		
		int sum = up + left;
		
		dp[i][j] = sum;
		
		
		
		// TODO Auto-generated method stub
		return sum;
	}

	
	private static int countWaysTabulation(int m, int n, int[][]maze) {

		
	    int[][] dp = new int[m][n];
		
	    
	    dp[0][0] = 1;

	    
	    
	    
	    int count=0;
	    
		
		for(int i=0; i<m;i++)
		{
			for(int j=0;j<n; j++)
			{	
				if(i==0 && j==0)
				{
					dp[i][j]=1;
					continue;
				}
				
				
				//base conditions
		          if(i>0 && j>0 && maze[i][j]==-1){
		            dp[i][j]=0;
		            continue;
		          }
				
		          int up  = 0;
		          
		          int left  = 0;
		          
		          
				if(i>=1)
				
					 up = dp[i-1][j];

				if(j>=1)
					 left = dp[i][j-1];

					
					
					dp[i][j] = up + left;

					
					
					
				

				
				
			}
			
			
		}
	    
		
		
		
		
		// TODO Auto-generated method stub
		return   dp[m-1][n-1];
	}

	

	
	private static int spaceoptim(int m, int n, int[][]maze) {

		
	    int[]previous = new int[n];

	    
	    
	    
	    previous[0] = 1;

	    
	    
	    
	    int count=0;
	    
		
		for(int i=0; i<m;i++)
		{
			int[] current = new int[n];
			
			for(int j=0;j<n; j++)
			{	
				if(i==0 && j==0)
				{
					current[j]=1;
					continue;
				}
				
				
				//base conditions
		          if(i>0 && j>0 && maze[i][j]==-1){
		        	  current[j]=0;
		            continue;
		          }
				
		          int up  = 0;
		          
		          int left  = 0;
		          
		          
				if(i>=1)
				
					 up = previous[j];

				if(j>=1)
					 left = current[j-1];

					
					
				current[j] = up + left;

					
					
					
				

				
				
			}
			
			previous = current;
		}
	    
		
		
		
		
		// TODO Auto-generated method stub
		return  previous[n-1];
	}

	
	
	
	
	
	
	
	
	
}
