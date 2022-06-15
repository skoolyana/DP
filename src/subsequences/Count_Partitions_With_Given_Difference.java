package subsequences;

import java.util.Arrays;

// https://www.youtube.com/watch?v=zoilQD1kYSg&list=PLgUwDviBIf0qUlt5H_kiKYaNSqJ81PMMY&index=19

// https://takeuforward.org/data-structure/count-partitions-with-given-difference-dp-18/

// https://www.youtube.com/watch?v=b3GD8263-PQ&list=PLgUwDviBIf0qUlt5H_kiKYaNSqJ81PMMY&index=22

// Problem 21 similar but twisted language

// https://takeuforward.org/data-structure/target-sum-dp-21/




public class Count_Partitions_With_Given_Difference {
	
	
	static int mod = (int)(Math.pow(10, 9)+7);
	
	public static void main(String[] args) {
		 int arr[] = {5,2,6,4};
			
			int diff = 3;
			
			System.out.println(findWays(arr,diff));
			
			
			arr = new int[] {0,0,1};
			
			diff = 1;

			
			System.out.println(findWays(arr,diff));

			
		}

	
	public static int findWays(int[] nums, int diff)
	{
		
		int sum = 0;
		
		for(int num : nums)
		{
			sum+=num;
		}
	
		
		// given : s1 - s2 = d
		
		// sum-s2 - s2 = d;
		
		// s2 = (sum-d)/2;
	
		if(sum-diff <0)
		return 0;
		
		if((sum-diff)%2==1)
		{
			return 0;
			
		}
		
		
		
		int target = (sum-diff)/2;
	
		int[][]dp = new int[nums.length][target+1];
		
		
		for(int[] dprow: dp)
		{
			Arrays.fill(dprow, -1);
			
		}
		
		
		//return findWaysUtil(nums,target,nums.length-1,dp);
		
		//return tabulate(nums, target);
		
		return optimise(nums, target);
		
		
	}

	private static int findWaysUtil(int[] nums, int target,int index, int[][] dp) {

		
		
		
		if(index==0)
		{
			if(target==0 && nums[index]==0)
				return 2;
			
			if(target==0 && nums[index]!=0)
				return 1;
			
			if(nums[0]==target)
				return 1 ;
			else
				return 0;
			
		}
		
		if(dp[index][target]!=-1)
		{
			return dp[index][target];
		}
		
		
		int Nottake = findWaysUtil(nums,target,index-1,dp);
		
		int take = 0;
		
		if(nums[index]<=target)
			take = findWaysUtil(nums,target-nums[index],index-1,dp);
			
		// TODO Auto-generated method stub
		return dp[index][target]= (take + Nottake)%mod;
	}
	
	
	private static int tabulate(int[] nums, int target) {


		int[][] dp = new int[nums.length][target+1];
		
		if(nums[0]==0)
		dp[0][nums[0]]=2;
		
		else
			dp[0][nums[0]]=1;
			
		
		
		if(nums[0]<=target && nums[0]!=0)
			dp[0][nums[0]]=1;
		
		
		
		
		for(int index=1; index<nums.length; index++)
		{

			for(int trgt=0; trgt<=target; trgt++)
			{
				int Nottake = dp[index-1][trgt];
	
				int take = 0;
				
				if(nums[index]<=trgt)
					take = dp[index-1][trgt-nums[index]];
		
				dp[index][trgt] = (take + Nottake)%mod;
				
			}
				
			
			
		}
		
		
		
			
		// TODO Auto-generated method stub
		return dp[nums.length-1][target];
	}
	


	private static int optimise(int[] nums, int target) {


		int[] previous = new int[target+1];

		int[] current = new int[target+1];

		
		
		if(nums[0]==0)
		{
			previous[nums[0]]=2;
			current[nums[0]]=2;
		}
		
		else
		{
			previous[nums[0]]=1;
			current[nums[0]]=1;
			
		}
			
		
		
		if(nums[0]<=target && nums[0]!=0)
			previous[nums[0]]=1;
		
		
		
		
		for(int index=1; index<nums.length; index++)
		{

			for(int trgt=0; trgt<=target; trgt++)
			{
				int Nottake = previous[trgt];
	
				int take = 0;
				
				if(nums[index]<=trgt)
					take = previous[trgt-nums[index]];
		
				current[trgt] = (take + Nottake)%mod;
				
			}
				
			previous = current;
			
		}
			
		
		
			
		// TODO Auto-generated method stub
		return previous[target];
	}

	
	
	
	
}
