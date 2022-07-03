package lis;

import java.util.Arrays;

public class Longest_Bitonic_Subsequence {
	
	// https://www.youtube.com/watch?v=y4vN0WNdrlg&list=PLgUwDviBIf0qUlt5H_kiKYaNSqJ81PMMY&index=47
	
	

	
	public static void main(String[] args) {

		int[] arr = {1,11,2,10,4,5,2,1};
		
		
		System.out.println(length_bitonic(arr));  ;
		
		
	}
	


	

	private static int length_bitonic(int[] arr) {
	
		int[] dp = new int[arr.length];
		int[] dp2 = new int[arr.length];

		
		Arrays.fill(dp, 1);
		Arrays.fill(dp2, 1);
		
		int max = 1;
		
		for(int index=0; index<arr.length; index++)
		{
		
			for(int previous=0; previous<index; previous++)
			{
				
				
				if(arr[index]> arr[previous] && 1+ dp[previous]>dp[index])
				{
					dp[index] = 1 + dp[previous];
					
				}
				
			}
		
			
		}
		
		int max2 = 1;
		
		for(int index=arr.length-1; index>=0; index--)
		{
		
			for(int previous=arr.length-1; previous>index; previous--)
			{
				
				
				if(arr[index]> arr[previous] && 1+ dp2[previous]>dp2[index])
				{
					dp2[index] = 1 + dp2[previous];
					
				}
				
			}
		
			
		}
		
		
		int maxi =1;
		
		for(int i=0; i< arr.length; i++)
		{
			maxi = Math.max(maxi, dp[i]+dp2[i]-1);
			
			
		}


		
		
		return maxi;
		
		
		
	}

	
}
