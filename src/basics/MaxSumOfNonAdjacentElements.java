package basics;

import java.util.ArrayList;
import java.util.Arrays;

// https://www.youtube.com/watch?v=GrMBfJNk_NY&list=PLgUwDviBIf0qUlt5H_kiKYaNSqJ81PMMY&index=6


public class MaxSumOfNonAdjacentElements {
	
	public static void main(String[] args) {
		
		ArrayList<Integer> aList = new ArrayList<>();
			
		aList.add(2);

		aList.add(1);
		aList.add(4);
		aList.add(9);
		
		System.out.println(maxNonAdjacentSum(aList));
		System.out.println(recursetab(4,aList));
		
		System.out.println(recursespaceoptimise(4,aList));
	}
	
	public static int maxNonAdjacentSum(ArrayList<Integer> nums)
	{
		
		int[] dp = new int[nums.size()];

		Arrays.fill(dp, -1);
		return recurse(3,nums,dp);
		
		
		
		
	}

	private static int recurse(int index, ArrayList<Integer> nums, int[]dp) {
			
		if(index==0)
			return nums.get(index);
		
		if(index< 0)
			return 0;
		
		if(dp[index]!=-1)
			return dp[index];

		int pick = nums.get(index) + recurse(index-2,nums,dp);
		
		int notpick = 0 + recurse(index-1,nums,dp);
		
		dp[index] = Math.max(pick,notpick);
			
		return Math.max(pick,notpick);
		
		
	}
	
	
	private static int recursetab(int n, ArrayList<Integer> nums) {
		
		
		int[] dp = new int[n];
		Arrays.fill(dp, -1);
		
		dp[0] = nums.get(0);
		
		
		int negative = 0;
		
		
		for(int i=1; i<n; i++)
		{
			int pick = nums.get(i) ;
			
			if(i>1)
				pick+= dp[i-2];
			int notpick = 0 + dp[i-1];
			dp[i] = Math.max(pick,notpick);
			
		}
		

		return dp[n-1];
		
		
	}
	
	
private static int recursespaceoptimise(int index, ArrayList<Integer> nums) {
		
		
		//int[] dp = new int[index+1];
		//Arrays.fill(dp, -1);
		
		int previous = nums.get(0);
		
		
		int previous2 = 0;
		
		
		for(int i=1; i<index; i++)
		{
			int pick = nums.get(i) ;
			
			if(i>1)
				pick+= previous2;
			int notpick = 0 + previous;
			
			int current = Math.max(pick,notpick);
			
			//dp[i] = Math.max(pick,notpick);
			
			previous2= previous;
			previous = current;
		}
		

		return previous;
		
		
	}

}

