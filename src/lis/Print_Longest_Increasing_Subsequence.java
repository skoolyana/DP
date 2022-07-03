package lis;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

// https://www.youtube.com/watch?v=ekcwMsSIzVc&list=PLgUwDviBIf0qUlt5H_kiKYaNSqJ81PMMY&index=42

// Checkout new Tabulation method



public class Print_Longest_Increasing_Subsequence {

	
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
		 		

		System.out.println(tabulate(arr));
		
		System.out.println(optimise(arr));

		System.out.println(new_tabulate(arr));


		print_new_tabulate(arr);

		
		
	}
	
	
	
	private static int print_new_tabulate(int[] arr) {
		
		
		int[] dp = new int[arr.length];
		
		int[] hash = new int[arr.length];
		
	
		int lastIndex = 0;
		
		Arrays.fill(dp, 1);
		int max = Integer.MIN_VALUE;
		
		
		for(int i=0; i<arr.length; i++)
		{
			
			for(int previous =0; previous<i; previous++)
			{
				
				if(arr[previous]< arr[i] && 1 + dp[previous]> dp[i])
				{
					
					dp[i] = Math.max(dp[i], dp[previous]+1);
			
					hash[i] = previous;
				
				}
				
			}
		
			if(dp[i]>max)
			{
				max = dp[i];
				lastIndex = i;
			}
			
		}
		

		ArrayList<Integer> temp = new ArrayList<>();
		
		temp.add(arr[lastIndex]);
		
		while(hash[lastIndex]!=lastIndex)
		{
			lastIndex = hash[lastIndex];
			
			temp.add(arr[lastIndex]);
			
		}

		Collections.reverse(temp);
		
		for(Integer  i: temp)
		{
			System.out.println(i + " ");
			
		}
		
		// TODO Auto-generated method stub
		return max;
	}


	private static int new_tabulate(int[] arr) {
		
		
		int[] dp = new int[arr.length];
		
		Arrays.fill(dp, 1);
		int max = Integer.MIN_VALUE;
		
		
		for(int i=0; i<arr.length; i++)
		{
			
			for(int previous =0; previous<i; previous++)
			{
				
				if(arr[previous]< arr[i])
				{
					
					dp[i] = Math.max(dp[i], dp[previous]+1);
				}
				
			}
		
			max = Math.max(max, dp[i]);
		}
		
		
		
		// TODO Auto-generated method stub
		return max;
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

	

	
	private static int  tabulate(int[] arr) {
		// TODO Auto-generated method stub
		
		int[][] dp = new int[arr.length+1][arr.length+1];
		
		for(int i= 0; i<arr.length; i++)
		{
			dp[arr.length][i] = 0;	
		}
		
		
		for(int index=arr.length-1; index>=0; index--)
		{

			for(int previous=index-1; previous>=-1; previous--)
			{
				
				int CannotBePart = 0 + dp[index+1][previous+1];
				int canBePart = 0;
				
				
				if(previous==-1 || arr[index]> arr[previous])
				{
					canBePart = 1 + dp[index+1][index+1];
				}
				
				dp[index][previous+1] = Math.max(CannotBePart, canBePart);
								
			}
							
			
		}
		
						
			
		return dp[0][-1+1];
	}

	

	private static int  optimise(int[] arr) {
		// TODO Auto-generated method stub
		
		int[] next = new int[arr.length+1];

		int[] current = new int[arr.length+1];

		
		for(int i= 0; i<arr.length; i++)
		{
			next[i] = 0;	
		}
		
		
		for(int index=arr.length-1; index>=0; index--)
		{

			for(int previous=index-1; previous>=-1; previous--)
			{
				
				int CannotBePart = 0 + next[previous+1];
				int canBePart = 0;
				
				
				if(previous==-1 || arr[index]> arr[previous])
				{
					canBePart = 1 +next[index+1];
				}
				
				current[previous+1] = Math.max(CannotBePart, canBePart);
								
			}
		
			next = current;
			
		}
		
						
			
		return next[-1+1];
	}


	
	
}
