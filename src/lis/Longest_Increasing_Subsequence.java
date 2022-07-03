package lis;

import java.util.Arrays;

// https://www.youtube.com/watch?v=ekcwMsSIzVc&list=PLgUwDviBIf0qUlt5H_kiKYaNSqJ81PMMY&index=42



public class Longest_Increasing_Subsequence {

	
	public static void main(String[] args) {
	
		
		int[] arr = {2,1,3,6,4,7,9};
		
		int index = 0;
		
		int previous=-1;
		
		int[][] dp = new int[arr.length][arr.length];
		
		for(int[] dprow : dp)
		{
			Arrays.fill(dprow, -1);
			
		}
		
		System.out.println(getLISLength(index,arr,previous,dp));
		 		
				
		
		
		
	}

	private static int  getLISLength(int index, int[] arr, int previous,int[][] dp) {
		// TODO Auto-generated method stub
		
		if(index==arr.length)
			return 0;
		
		int CannotBePart = 0 + getLISLength(index+1,arr,previous,dp);
		int canBePart = 0;
		
		if(dp[index][previous+1]!=-1)
		{
			return dp[index][previous+1];
		}
		
		if(previous==-1 || arr[index]> arr[previous])
		{
			canBePart = 1 + getLISLength(index+1,arr,index,dp);
		}
				
				
			
		return dp[index][previous+1] = Math.max(CannotBePart, canBePart);
	}

	
	
	
	
	
	
}
