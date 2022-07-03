package stocks;

import java.util.Arrays;

// https://www.youtube.com/watch?v=IV1dHbk5CDc&list=PLgUwDviBIf0qUlt5H_kiKYaNSqJ81PMMY&index=39
// https://takeuforward.org/data-structure/buy-and-sell-stocks-with-cooldown-dp-39/



public class Buy_and_Stock_Sell_With_CoolDown {

	public static void main(String[] args) {

		int[] arr = { 4, 9, 0, 4, 10};

		System.out.println(" The maximum profit that can be generated is " + getMaximumProfit(arr));

		System.out.println(" The maximum profit that can be generated is " + tabulate(arr, 1));

		//System.out.println(" The maximum profit that can be generated is " + optimise(arr, 2));

	}

	private static int getMaximumProfit(int[] arr) {

		if (arr.length == 0)
			return 0;

		int index = 0;
		int[][] dp = new int[arr.length][2];
		
		
		for(int[] dprow: dp)
		{
			Arrays.fill(dprow, -1);
			
		}
		
		return recurse(index, arr, 1,dp);

	}

	private static int recurse(int index, int[] arr, int buy,int[][]dp) {


		if(index>=arr.length)
		{
			return 0;
		}
		
		if(dp[index][buy]!=-1)
		{
			return dp[index][buy];
		}
		
		
		if (buy == 1) {
			int ProfitNotBuy = 0 + recurse(index + 1, arr, 1,dp);

			int ProfitBuy = -arr[index] + recurse(index + 1, arr, 0,dp);

			dp[index][buy] = Math.max(ProfitNotBuy, ProfitBuy);

		} else if (buy == 0) {
			int ProfitNotSell = 0 + recurse(index + 1, arr, 0,dp);

			int ProfitSell = arr[index] + recurse(index + 2, arr, 1,dp);

			dp[index][buy] = Math.max(ProfitNotSell, ProfitSell);

		}

		// TODO Auto-generated method stub
		return dp[index][buy];
	}


	
	private static int tabulate( int[] arr, int buy) {

		int[][]dp = new int[arr.length+2][2];

		dp[arr.length][0] = 0;
		dp[arr.length][1] = 0;
		
		
		for(int index = arr.length-1; index>=0; index--)
		{
			for(int j=0; j<=1; j++)
			{
				
				if (j == 1) {
					int ProfitNotBuy = 0 + dp[index + 1][1];

					int ProfitBuy = -arr[index] + dp[index + 1][0];

					dp[index][j] = Math.max(ProfitNotBuy, ProfitBuy);

				} else if (j == 0) {
					
					int ProfitNotSell = 0 + dp[index + 1][0];

					int ProfitSell = arr[index] + dp[index + 2][1];

					dp[index][j] = Math.max(ProfitNotSell, ProfitSell);

				}

				
			}
			
			
		}		
		
		// TODO Auto-generated method stub
		return dp[0][1];
	}

	
}
