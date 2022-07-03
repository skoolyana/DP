package stocks;

import java.util.Arrays;

// https://www.youtube.com/watch?v=-uQGzhYj8BQ&list=PLgUwDviBIf0qUlt5H_kiKYaNSqJ81PMMY&index=38

// https://takeuforward.org/data-structure/buy-and-sell-stock-iii-dp-37/



public class Buy_and_Sell_Stocks_III {

	public static void main(String[] args) {
		
		
		  int[] arr= {3,3,5,0,0,3,1,4};

		  System.out.println(" The maximum profit that can be generated is "+getMaximumProfit(arr));
		  
		  System.out.println(" The maximum profit that can be generated is "+tabulate(arr,2));

		  
		  System.out.println(" The maximum profit that can be generated is "+optimise(arr,2));

	}

	private static int getMaximumProfit(int[] arr) {
			
		if(arr.length==0)
			return 0;
		
		int index = 0;
		
		int capacity = 2;

		int[][][] dp = new int[arr.length][2][capacity+1];
		
		
		for(int[][]dpblock : dp)
		{
			for(int[] dprow : dpblock)
			{
				Arrays.fill(dprow, -1);
				
			}	
		}
		
		return recurse(index,arr,1,2,dp);

	
	
	}

	private static int recurse(int index, int[] arr, int buy, int capacity, int[][][] dp) {


		if(index==arr.length)
			return 0;
		
		if(capacity==0)
			return 0;
				
		
		if(dp[index][buy][capacity]!=-1)
		{
			return dp[index][buy][capacity]; 
		}
		
		int profit = Integer.MIN_VALUE;
		
		
		
		if(buy==1)
		{
			
			int profitNotBuy = 0 + recurse(index+1,arr,1,capacity,dp);
		
			int profitBuy = - arr[index] + recurse(index+1,arr,0,capacity,dp);
		
			profit = Math.max(profitNotBuy, profitBuy);
			
		}
		else if(buy==0)
		{
			int profitNotSell = 0 + recurse(index+1,arr,0,capacity,dp);
			
			int profitSell =  arr[index] + recurse(index+1,arr,1,capacity-1,dp);
		
			profit = Math.max(profitNotSell, profitSell);
			
		}
				
		
		// TODO Auto-generated method stub
		return dp[index][buy][capacity]=profit;
	}
	

	
	
	private static int tabulate(int[] arr, int capacity) {

		int[][][] dp = new int[arr.length+1][2][capacity+1];


		for(int i=0;i<=capacity; i++)
		{
			dp[arr.length][0][i]=0;
			dp[arr.length][1][i]=0;
			
		}
		
		for(int i=0;i<=arr.length; i++)
		{
			dp[i][0][0]=0;
			dp[i][1][0]=0;
			
		}
		
				
		
		
		int profit = Integer.MIN_VALUE;
		
		
		
		for(int index=arr.length-1;index>=0; index--)
		{
			for(int buy =0; buy<=1; buy++)
			{
				for(int cap=1; cap<=capacity; cap++)
				{
					if(buy==1)
					{
						int profitNotBuy = 0 + dp[index+1][1][cap];
						
						int profitBuy = - arr[index] + dp[index+1][0][cap];
					
						dp[index][buy][cap] = Math.max(profitNotBuy, profitBuy);
					
					}
					else if(buy==0)
					{
						int profitNotSell = 0 + dp[index+1][0][cap];
						
						int profitSell =  arr[index] + dp[index+1][1][cap-1];
					
						dp[index][buy][cap] = Math.max(profitNotSell, profitSell);
					
					}
					
					
				}
					
			}
			
			
		}
		
				
		// TODO Auto-generated method stub
		return dp[0][1][capacity];
	}


	
	
	
	private static int optimise(int[] arr, int capacity) {

		int[][] next = new int[2][capacity+1];
		int[][] current = new int[2][capacity+1];


		for(int i=0;i<=capacity; i++)
		{
			next[0][i]=0;
			next[1][i]=0;
			
		}
		
		for(int i=0;i<=arr.length; i++)
		{
			next[0][0]=0;
			next[1][0]=0;
			
		}
		
				
		
		
		int profit = Integer.MIN_VALUE;
		
		
		
		for(int index=arr.length-1;index>=0; index--)
		{
			for(int buy =0; buy<=1; buy++)
			{
				for(int cap=1; cap<=capacity; cap++)
				{
					if(buy==1)
					{
						int profitNotBuy = 0 + next[1][cap];
						
						int profitBuy = - arr[index] + next[0][cap];
					
						current[buy][cap] = Math.max(profitNotBuy, profitBuy);
					
					}
					else if(buy==0)
					{
						int profitNotSell = 0 + next[0][cap];
						
						int profitSell =  arr[index] + next[1][cap-1];
					
						current[buy][cap] = Math.max(profitNotSell, profitSell);
					
					}
					
					
				}
					
			}
			
			next = current;
		}
		
				
		// TODO Auto-generated method stub
		return next[1][capacity];
	}

	
}
