package subsequences;

import java.util.Arrays;

// https://takeuforward.org/data-structure/0-1-knapsack-dp-19/

// https://www.youtube.com/watch?v=GqOmJHQZivw&list=PLgUwDviBIf0qUlt5H_kiKYaNSqJ81PMMY&index=20

// Check how optimise single row


public class KnapSack {

	public static void main(String[] args) {
	
		  int wt[] = {1,2,4,5};
		  int val[] = {5,4,8,6};
		  int target=5;
		  
		  int n = wt.length;
		  
		  int[][]dp = new int[n][target+1];

		  
		  for(int[] dprow: dp )
		  {
			  Arrays.fill(dprow, -1);
			  
		  }
		  
		  
		  System.out.println("The Maximum value of items, thief can steal is "+
		  knapsack(wt.length-1,wt,val,target,dp));
	
		  System.out.println("The Maximum value of items, thief can steal through tabulation  is "+
					
		  tabulate(wt, val, target));
		  

		  System.out.println("The Maximum value of items, thief can steal through optimisation  is "+
					
		  optimise(wt, val, target));

	
	
	}

	private static int knapsack(int index,int[] wt, int[] val, int target, int[][] dp) {

		if(index==0)
		{
			if(wt[index]<=target)
			{
				return val[index];
			}
			else
				return 0;
			
		}

		if(dp[index][target]!=-1)
		{
			return dp[index][target];
		}
		
		
		
		int notSteal = 0 + knapsack(index-1,wt,val,target,dp);
		
		int steal = Integer.MIN_VALUE;
		
		
		if(wt[index]<=target)
		{
			steal =  val[index] + knapsack(index-1,wt,val,target-wt[index],dp);
			
		}
		
		
		
		// TODO Auto-generated method stub
		return dp[index][target] = Math.max(notSteal, steal);
	}
	
	

	private static int tabulate(int[] wt, int[] val, int target) {


		int[][]dp = new int[wt.length][target+1];
		
		
		
		//Base Condition
	    
	    for(int i=wt[0]; i<=target; i++){
	        dp[0][i] = val[0];
	    }
		
		
		for(int index = 1; index< wt.length; index++)
		{
			for(int trgt = 0; trgt<=target; trgt++)
			{
				int notSteal = 0 + dp[index-1][trgt];
				
				int steal = Integer.MIN_VALUE;
				
				
				if(wt[index]<=trgt)
				{
					steal =  val[index] + dp[index-1][trgt-wt[index]];
					
				}
				
			
				dp[index][trgt] = Math.max(notSteal, steal);
			}
				
			
			
		}
		
		
		// TODO Auto-generated method stub
		return dp[wt.length-1][target];
	}


	
	
	private static int optimise(int[] wt, int[] val, int target) {


		int[]previous = new int[target+1];
		
		//int[]current = new int[target+1];
		
		
		
		//Base Condition
	    
	    for(int i=wt[0]; i<=target; i++){
	    	previous[i] = val[0];
	    }
		
		
		for(int index = 1; index< wt.length; index++)
		{
			for(int trgt = target; trgt>=0; trgt--)
			{
				int notSteal = 0 + previous[trgt];
				
				int steal = Integer.MIN_VALUE;
				
				
				if(wt[index]<=trgt)
				{
					steal =  val[index] + previous[trgt-wt[index]];
					
				}
				
			
				previous[trgt] = Math.max(notSteal, steal);
			}
				
			
		}
		
		
		// TODO Auto-generated method stub
		return previous[target];
	}
	
	
	
	 
}
