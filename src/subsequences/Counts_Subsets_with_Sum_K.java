package subsequences;

import java.util.Arrays;

// https://www.youtube.com/watch?v=ZHyb-A2Mte4&list=PLgUwDviBIf0qUlt5H_kiKYaNSqJ81PMMY&index=18

// https://takeuforward.org/data-structure/count-partitions-with-given-difference-dp-18/


public class Counts_Subsets_with_Sum_K {

	
	public static void main(String[] args) {
		
		int[]arr = new int[] {1,2,3,4};
		
		int target = 5;
		
		System.out.println(findWays(arr,target));
		
		System.out.println(tabulate(arr, target));
		
		System.out.println(optimise(arr, target));
		
		arr = new int[] {0,0,1};
		
		target = 0;
		
	
		System.out.println(findWays(arr,target));
		
		
	}
	
	
	public static int findWays(int[] num, int target)
	{
		
		int length = num.length;
	
		int[][]dp = new int[num.length][target+1];
		

		for(int[] dprow: dp)
		{
			Arrays.fill(dprow, -1);
			
		}
		
		
		int counts = recurse(length-1, num, target,dp);
		
		
		
		return counts;
		
		
	}


	static int recurse(int index, int[]num, int target, int[][] dp)
	{
		
		
		if(index==0)
		{
			if(target==0 && num[index]==0)
				return 2;
			
			if(target==0 && num[index]!=0)
				return 1;
			
			if(num[0]==target)
				return 1 ;
			else
				return 0;
			
			
			
		}

		
		if(dp[index][target]!=-1)
		{
			return dp[index][target];
		}
	
		int notTake = recurse(index-1,num,target,dp);
		
		int take = 0;
		
		if(num[index]<=target)
		{
			take = recurse(index-1, num, target-num[index],dp);	
		}
			
		
		
		return dp[index][target]= take + notTake;		
	}

	

	static int tabulate(int[]num, int target)
	{
		
		
		int[][] dp = new int[num.length][target+1];
		

		for(int i=0; i< num.length; i++)
		{
			dp[i][0] = 1;
			
		}
		
		if(num[0]<=target)dp[0][num[0]]=1;
		
	
		for(int index = 1; index<num.length; index++)
		{
			for(int trgt = 0; trgt<=target; trgt++)
			{
				int notTake = dp[index-1][trgt];
	
				int take = 0;
				
				if(num[index]<=trgt)
				{
					take = dp[index-1][trgt-num[index]];	
				}
			
				dp[index][trgt]=take + notTake;
				
			}
		}
			
		return dp[num.length-1][target];		
	}


	
	
	
	static int optimise(int[]num, int target)
	{
		
		
		int[] previous = new int[target+1];

		int[] current = new int[target+1];


		previous[0] = 1;
			current[0]=1;
			
		
		
		if(num[0]<=target)previous[num[0]]=1;
	
		
		
	
		for(int index = 1; index<num.length; index++)
		{
			for(int trgt = 0; trgt<=target; trgt++)
			{
				int notTake = previous[trgt];
	
				int take = 0;
				
				if(num[index]<=trgt)
				{
					take = previous[trgt-num[index]];	
				}
			
				current[trgt]=take + notTake;
				
			}
			
			previous = current;
		}
			
		return previous[target];		
	}

	
}
