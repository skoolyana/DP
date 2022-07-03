package subsequences;

import java.util.Arrays;

// https://www.youtube.com/watch?v=HgyouUi11zk&list=PLgUwDviBIf0qUlt5H_kiKYaNSqJ81PMMY&index=23

// https://takeuforward.org/data-structure/coin-change-2-dp-22/



public class Coin_Change {

	
	public static void main(String args[]) {
		
		 int arr[] ={1,2,3};
		 int target=4;
		 
		 
		  
		 System.out.println("The total number of ways is "+coinChange(arr,
				  target));

		 System.out.println("The total number of ways is "+tabulate(arr,
				  target));


		 System.out.println("The total number of ways is "+optimise(arr,
				  target));

		
	}

	private static int coinChange(int[] arr, int target) {

		
		int index = arr.length -1;
		
		
		int[][] dp = new int[arr.length][target+1];

		for(int[] dprow: dp)
		{
			Arrays.fill(dprow, -1);
			
		}
		
		// TODO Auto-generated method stub
		return recurse(index,arr,target,dp);
	
	
	}

	private static int recurse(int index, int[] arr, int target, int[][] dp) {
		
		
		if(index==0)
		{
			if(target%arr[0]==0)
				return 1;
			else
				return 0;
		}
		
		if(dp[index][target]!=-1)
			return dp[index][target];
		
		int notPick = recurse(index-1,arr,target,dp);

		int pick = 0;
		
		if(arr[index]<=target)
		{
			pick = recurse(index,arr,target-arr[index],dp);
						
		}
		
		
		// TODO Auto-generated method stub
		return dp[index][target]= pick + notPick;	
	}

	
	private static int tabulate (int[] arr, int target) {
		
		int[][] dp = new int[arr.length][target+1];
		

		for(int trgt=0; trgt<=target; trgt++)
		{
			if(trgt%arr[0]==0)
				dp[0][trgt]= 1;
		
			else
				dp[0][trgt]= 0;
		
		}
		
		
		
		for(int index=1; index<arr.length; index++)
		{

			for(int trgt=0; trgt<=target; trgt++)
			{
				int notPick = dp[index-1][trgt];

				int pick = 0;
				
				if(arr[index]<=trgt)
				{
					pick = dp[index][trgt-arr[index]];
								
				}

				// TODO Auto-generated method stub
				dp[index][trgt]= pick + notPick;	

			}
			
		}
		

		return dp[arr.length-1][target]; 
		
	}

	
	
	private static int optimise (int[] arr, int target) {
		
		int[] previous = new int[target+1];
		int[] current = new int[target+1];
		

		for(int trgt=0; trgt<=target; trgt++)
		{
			if(trgt%arr[0]==0)
				previous[trgt]= 1;
		
			else
				previous[trgt]= 0;
		
		}
		
		
		
		for(int index=1; index<arr.length; index++)
		{

			for(int trgt=0; trgt<=target; trgt++)
			{
				int notPick = previous[trgt];

				int pick = 0;
				
				if(arr[index]<=trgt)
				{
					pick = current[trgt-arr[index]];
								
				}

				// TODO Auto-generated method stub
				current[trgt]= pick + notPick;	

			}

			
			previous = current;
			
		}
		

		return previous[target]; 
		
	}
	

	
	
}
