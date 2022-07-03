package stocks;

import java.util.Arrays;

// https://www.youtube.com/watch?v=nGJmxkUJQGs&list=PLgUwDviBIf0qUlt5H_kiKYaNSqJ81PMMY&index=37

// https://takeuforward.org/data-structure/buy-and-sell-stock-ii-dp-36/



public class Buy_and_Sell_Stock_II {

	
	public static void main(String[] args) {
		
		  int[] arr= {7,1,5,3,6,4};
		    
		  System.out.println(" The maximum profit that can be generated is "+getMaximumProfit(arr));
		  
		  System.out.println(" The maximum profit that can be generated is "+tabulate(arr));
		  

		  System.out.println(" The maximum profit that can be generated is "+optimise(arr));

		  
	}

	private static int getMaximumProfit(int[] arr) {
	
		if(arr.length==0)
			return 0;
		
		
		int index = 0;
		
		
		int[][] dp = new int[arr.length][2]; 
		
		for(int[] dprow: dp)
		{
			Arrays.fill(dprow, -1);
			
		}
		
		// TODO Auto-generated method stub
		return recurse(index,arr,1,dp);
	}

	private static int recurse(int index, int[] arr, int buy,int[][] dp) {
		
		
		if(index==arr.length)
			return 0;
		
		int profit = 0;
		
		if(	dp[index][buy]!=-1)
			return 	dp[index][buy];
		
		if(buy==1) // We can buy the stock
		{
			
			int profitNotBuy = 0 + recurse(index+1,arr,1,dp);
			
			int profitBuy = -arr[index] + recurse(index+1,arr,0,dp);
			
		
			dp[index][buy] = profit = Math.max(profitNotBuy,profitBuy);
			
			
		}
		
		if(buy==0) // We can sell the stock
		{
			int profitNotSell = 0 + recurse(index+1,arr,0,dp);
			
			int profitSell = arr[index] + recurse(index+1,arr,1,dp);
			
		
			dp[index][buy]=	profit = Math.max(profitNotSell,profitSell);
		
			
			
		}
			
		
		
		
		
		// TODO Auto-generated method stub
		return dp[index][buy];

	
	
	
	}

	
	
	
	private static int tabulate(int[] arr) {
		
		int[][] dp = new int[arr.length+1][2];
		
		for(int[]dprow : dp)
		{
			Arrays.fill(dprow, -1);
			
		}
		
		dp[arr.length][0]=0;
		dp[arr.length][1]=0;
		
		
		for(int  index=arr.length-1; index>=0; index--)
		{
			for(int  j=0; j<=1; j++)
			{
				
				if(j==1)
				{
					int profitNotBuy = 0 + dp[index+1][1];
					
					int profitBuy = -arr[index] + dp[index+1][0];
					
				
					dp[index][j] = Math.max(profitNotBuy,profitBuy);
					
				
				}
				else if(j==0)
				{
					int profitNotSell = 0 + dp[index+1][0];
					
					int profitSell = arr[index] + dp[index+1][1];
					
				
					dp[index][j] = Math.max(profitNotSell,profitSell);
				
				}
				
			}
				
			
		}
				
		
		// TODO Auto-generated method stub
		return dp[0][1];

	}


	
	private static int optimise(int[] arr) {
		
		int[] next = new int[2];
		int[] current = new int[2];
		
		
		next[0]=0;
		next[1]=0;
		
		
		for(int  index=arr.length-1; index>=0; index--)
		{
			for(int  j=0; j<=1; j++)
			{
				
				if(j==1)
				{
					int profitNotBuy = 0 + next[1];
					
					int profitBuy = -arr[index] + next[0];
					
				
					current[j] = Math.max(profitNotBuy,profitBuy);
					
				
				}
				else if(j==0)
				{
					int profitNotSell = 0 + next[0];
					
					int profitSell = arr[index] + next[1];
					
				
					current[j] = Math.max(profitNotSell,profitSell);
				
				}
				
				next = current;
			}
				
			
		}
				
		
		// TODO Auto-generated method stub
		return next[1];

	}

	
	
}
