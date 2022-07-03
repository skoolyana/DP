package lis;

import java.util.Arrays;


// https://www.youtube.com/watch?v=cKVl1TFdNXg&list=PLgUwDviBIf0qUlt5H_kiKYaNSqJ81PMMY&index=48


public class Number_of_Longest_Increasing_Subsequences {

	public static void main(String[] args) {
		
		
		int[] arr = {1,3,5,4,7};
	
		System.out.println(		print_new_tabulate(arr));

	}
	
private static int print_new_tabulate(int[] arr) {
		
		
		int[] dp = new int[arr.length];

		int[] count = new int[arr.length];

		
		
		Arrays.fill(dp, 1);
		Arrays.fill(count, 1);
	
		
		int max = 1;
		
		for(int i=0; i<arr.length; i++)
		{
			
			for(int previous =0; previous<i; previous++)
			{
				
				if(arr[previous]< arr[i] && 1 + dp[previous]> dp[i])
				{
					
					dp[i] = dp[previous]+1;	
					
					count[i] = count[previous];
				
				}
				else if(arr[previous]< arr[i] && 1 + dp[previous]== dp[i])
				{
					
					count[i] = count[i] + count[previous] ;			
				
				}
				
			}
		
			max = Math.max(max, dp[i]);
		}
		
		
	
		int result = 0;
		
		for(int i=0; i<dp.length; i++)
		{
		
			if(dp[i]==max)
			{
				result+=count[i];
			}
			
			
		}
		
		return result;
	}
	
}
