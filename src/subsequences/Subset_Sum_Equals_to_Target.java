package subsequences;

import java.util.Arrays;

// https://www.youtube.com/watch?v=fWX9xDmIzRI&list=PLgUwDviBIf0qUlt5H_kiKYaNSqJ81PMMY&index=15

// https://takeuforward.org/data-structure/subset-sum-equal-to-target-dp-14/

// https://www.youtube.com/watch?v=7win3dcgo3k&list=PLgUwDviBIf0qUlt5H_kiKYaNSqJ81PMMY&index=16


// https://takeuforward.org/data-structure/partition-equal-subset-sum-dp-15/





public class Subset_Sum_Equals_to_Target {
	
	public static void main(String args[]) {

		  int arr[] = {1,2,3,4};
		  int target=11;
		  int n = arr.length;
		                                 
		  if(subsetSumToTarget(n,target,arr))
		    System.out.println("Subset with given target found");
		  else 
		    System.out.println("Subset with given target not found");
		  
		  if(tabulate(target,arr))
			    System.out.println("Subset with given target found");
			  else 
			    System.out.println("Subset with given target not found");
			  
		  
		  if(optimise(target,arr))
			    System.out.println("Subset with given target found");
			  else 
			    System.out.println("Subset with given target not found");
			  
		  
		  int arr1[] = {2,3,3,3,4,5};
		  
		  if(canPartition(arr1))
			    System.out.println("The Array can be partitioned into two equal subsets");
			  else 
			    System.out.println("The Array cannot be partitioned into two equal subsets");
		  
		  
		  
		}
	

	static boolean canPartition(int[] arr)
	{
		int sum = 0;
		
		
		for(int i: arr)
		{
			sum+=i;
		}
		
		if(sum%2!=0)
			return false;
		
		return subsetSumToTarget(arr.length,sum/2,arr);
		
		
	}

	
	static boolean subsetSumToTarget(int n, int target,int[] arr){
		
		int[][]dp = new int[n][target+1];
		
		for(int[] row : dp)
		{	
			Arrays.fill(row, -1);
				
		}
		
		
		int index = n-1;
		
		return subsetSumUtil(index,target,arr,dp);
	}




	private static boolean subsetSumUtil(int index, int target, int[] arr, int[][] dp) {
	
		
		if(target==0)
			return true;
		
		if(index==0)
		{
			if(arr[index]==target)
			{
				return true;
			}
			else 
				return false;
		}
		
		if(dp[index][target]!=-1)
		{
			return dp[index][target]==0?false: true;
			
		}
		
		
		boolean notpick =  subsetSumUtil(index-1,target,arr,dp);
		
		boolean pick = false;
		
		if(arr[index]<=target)
		{
			pick =  subsetSumUtil(index-1,target-arr[index],arr,dp);
			
			
		}
		
		dp[index][target] = notpick || pick ? 1: 0;
			
		
		// TODO Auto-generated method stub
		return notpick || pick ;
	}
	

	
	
	private static boolean tabulate(int target, int[] arr) {
	
		int n = arr.length;
		
		boolean[][] dp = new boolean[n][target+1];
		
		for(int i=0; i<arr.length ; i++)
		{
			dp[i][0] = true;
			
		}
		
		if(arr[0]<=target)

		dp[0][arr[0]]=true;
		
		
		for(int i=1; i<n; i++)
		{
			for(int j=1; j<=target; j++)
			{
				
				boolean pick = false;
				boolean notpick =  dp[i-1][j];
				
				if(arr[i]<=j)
				{
					pick =  dp[i-1][j-arr[i]];
					
					
				}
				
				dp[i][j] = notpick || pick;
					

			}
			
		}
		
		return dp[n-1][target];
	}

	
	
	private static boolean optimise(int target, int[] arr) {
		
		int n = arr.length;
		
		boolean[] previous = new boolean[target+1];
		
		
		if(arr[0]<=target)
			previous[0] = true;
			
		
		
		//if(arr[0]<=target)

		previous[arr[0]]=true;
		
		
		for(int i=1; i<n; i++)
		{
			boolean[] current = new boolean[target+1];
			current[0] = true;
			for(int j=1; j<=target; j++)
			{
				
				boolean pick = false;
				boolean notpick =  previous[j];
				
				if(arr[i]<=j)
				{
					pick =  previous[j-arr[i]];
					
					
				}
				
				current[j] = notpick || pick;
					

			}
			
			previous = current;
			
		}
		
		return previous[target];
	}
	
	
}
