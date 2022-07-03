package lis;

import java.util.Arrays;

// https://www.youtube.com/watch?v=YY8iBaYcc4g&list=PLgUwDviBIf0qUlt5H_kiKYaNSqJ81PMMY&index=46


public class Longest_String_Chain {

	
	public static void main(String[] args) {
		
		String[] strArr = new String[]{"xbc","pcxbcf","xb","cxbc","pcxbc"};
		
		System.out.println(length_new_tabulate(strArr));
		
		
	}
	
	private static int length_new_tabulate(String[] arr) {
		
		int[] dp = new int[arr.length];

		Arrays.fill(dp, 1);
		
		int max = 1;
		
		Arrays.sort(arr,(a,b)-> a.length() - b.length());		
		
		
		for(int index=0;index<arr.length; index++)
		{

			for(int previous=0;previous<index; previous++)
			{
				
				if(compare(arr[index],arr[previous]) && 1+dp[previous]>dp[index])
				{
					
					dp[index] = 1+dp[previous];
					
				}
				
				
				
			}
				
				
			if(dp[index]>max)
			{
				max =  dp[index];
			}
			
		
		}
		
		
		return max;
		
		
		
	}

	private static boolean compare(String str1, String str2) {


		if(str1.length()!=str2.length()+1)
		return false;
		
		
		int first = 0;

		int second = 0;
		
		while(first<str1.length())
		{
			
			if(second < str2.length() && str1.charAt(first)==str2.charAt(second))
			{
				first++;
				second++;
			}
			else
			{
				first++;
			}
			
			
		}
			
		
		if(first==str1.length() && second==str2.length())
		{
			return true;
		}
		
		return false;
				
	}

}
