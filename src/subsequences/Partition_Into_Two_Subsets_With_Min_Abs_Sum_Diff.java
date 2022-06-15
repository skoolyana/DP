package subsequences;

// https://www.youtube.com/watch?v=GS_OqZb2CWc&list=PLgUwDviBIf0qUlt5H_kiKYaNSqJ81PMMY&index=17

// https://takeuforward.org/data-structure/partition-set-into-2-subsets-with-min-absolute-sum-diff-dp-16/



public class Partition_Into_Two_Subsets_With_Min_Abs_Sum_Diff {

	
	static boolean[][] dp;
	
	public static void main(String[] args) {
		

		  int[] arr = {1,2,3,4};
		  
		  System.out.println(minSubsetSumDifference(arr));
	}
	
	public static int minSubsetSumDifference(int[]arr)
	{
		int n = arr.length;
		
		int totalsum=0;
		
		for(int i: arr)
		{
			totalsum+=i;
			
		}
		
		tabulate(totalsum+1,arr);
		
		int min = Integer.MAX_VALUE;
		
		for(int s1=0; s1<=totalsum/2;s1++ )
		{
			if(dp[n-1][s1]==true)
			{
				min = Math.min(min, Math.abs((totalsum-s1)-s1));
				
			}
			
		}
		
		return min;
		
	}
	
	private static boolean tabulate(int target, int[]arr)
	{
		int n = arr.length;
		
		dp = new boolean[n][target+1];
		
		
		for(int i=0; i<n ; i++)
		{
			dp[i][0] = true;
				
		}
		
		
		if(arr[0]<=target)
		dp[0][arr[0]]= true;
		
		
		for(int index =1; index<n ; index++)
		{
			
			for(int trgt=1; trgt<=target; trgt++)
			{
				
				boolean notpick = dp[index-1][trgt];
				
				boolean pick = false;
				
			
				if(arr[index]<=trgt)

				{
					pick = dp[index-1][trgt-arr[index]];
				}
				
			
				dp[index][trgt] = notpick || pick;

			}
			
			
		}
		
		return dp[n-1][target];
		
	}
}
