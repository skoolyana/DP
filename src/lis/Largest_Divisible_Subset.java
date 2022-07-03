package lis;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

//https://www.youtube.com/watch?v=gDuZwBW9VvM&list=PLgUwDviBIf0qUlt5H_kiKYaNSqJ81PMMY&index=45


public class Largest_Divisible_Subset {
	
	

	
	public static void main(String[] args) {
		int[] arr = {5,4,11,1,16,8};
		
		print_new_tabulate(arr);
		
	}
	
	private static int print_new_tabulate(int[] arr) {
		
		int[] dp = new int[arr.length];
		
		int[] hash = new int[arr.length];
		
		int lastIndex = 0;
		
		Arrays.fill(dp, 1);
		
		int max = Integer.MIN_VALUE;
		
		Arrays.sort(arr);
		
		for(int index = 0; index<arr.length; index++)
		{
			for(int previous=0; previous< index; previous++)
			{
				
				if(arr[index]%arr[previous]==0 && 1 + dp[previous]>dp[index])
				{
					
					dp[index] = Math.max(dp[index], 1 + dp[previous]);
			
					hash[index] = previous;
				}
				
			}
			
			if(dp[index]>max)
			{
				max = dp[index];
				lastIndex = index;
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

		return temp.size();
		
	}
		
	
}
