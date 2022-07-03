// https://leetcode.com/problems/maximum-length-of-repeated-subarray/

// https://www.youtube.com/watch?v=hmXH7MzcGv4



package basics;

import java.util.Arrays;

public class Maximum_Length_of_Repeated_Subarray {

	
	public static void main(String[] args) {
		
		
		int[]nums1 = {1,2,3,2,1};
	
		int[]nums2 = {3,2,1,4,7};
		
		System.out.println(findLength_striver(nums1, nums2));
		
		System.out.println(tabulate(nums1, nums2));
		
		System.out.println(optmise(nums1, nums2));
		
	
	}
	

	public static int findLength_striver(int[] nums1, int[] nums2) {
		
		int[][]dp = new int[nums1.length][nums2.length];

		for(int[] dprow: dp)
		{
			Arrays.fill(dprow, -1);
			
		}
		
		
		
		return recurse(nums1.length-1, nums1, nums2.length-1, nums2,dp);
	}
	
	public static int recurse(int index1, int[] nums1,int index2,int[] nums2,int[][]dp) {
		
		if(index1<0 || index2 < 0)
		{
			return 0;
		}

		
		if(dp[index1][index2]!=-1)
			return dp[index1][index2]; 
	
		
		
		if(nums1[index1]==nums2[index2])
		{
			return dp[index1][index2] =  1 + recurse(index1-1,nums1,index2-1,nums2,dp);
			
		}
		else
		{
			return dp[index1][index2] =  0 +   Math.max(recurse(index1-1, nums1, index2, nums2,dp), recurse(index1, nums1, index2-1, nums2,dp) );   
			 
		}
		
		
		
		
		
		
	}


	
	
	public static int tabulate(int[] nums1,int[] nums2) {
		
		int[][]dp = new int[nums1.length+1][nums2.length+1];
		
		for(int i=0; i<=nums1.length; i++)
		{
			dp[i][0] = 0;
			
		}
		
		for(int i=0; i<=nums2.length; i++)
		{
			dp[0][i] = 0;
			
		}
		
	
		for(int index1=1;index1<=nums1.length; index1++)
		{
			for(int index2=1;index2<=nums2.length; index2++)
			{
				if(nums1[index1-1]==nums2[index2-1])
				{
				  dp[index1][index2] =  1 + dp[index1-1][index2-1];
					
				}
				else
				{
					 dp[index1][index2] =  0 +   Math.max(dp[index1-1][index2], dp[index1][index2-1] );   
					 
				}
				
				
			}
		
			
		}
		
		
		 return dp[nums1.length][nums2.length];
		
		
	}


	
	
	public static int optmise(int[] nums1,int[] nums2) {
		
		int[]previous = new int[nums2.length+1];
		int[]current = new int[nums2.length+1];
		
		
		for(int i=0; i<=nums1.length; i++)
		{
			previous[0] = 0;
			
		}
		
		for(int i=0; i<=nums2.length; i++)
		{
			previous[i] = 0;
			
		}
		
	
		for(int index1=1;index1<=nums1.length; index1++)
		{
			for(int index2=1;index2<=nums2.length; index2++)
			{
				if(nums1[index1-1]==nums2[index2-1])
				{
					current[index2] =  1 + previous[index2-1];
					
				}
				else
				{
					current[index2] =  0 +   Math.max(previous[index2], current[index2-1] );   
					 
				}
				
				
			}
			
			previous = current;
			
		}
		
		
		 return previous[nums2.length];
		
		
	}


	
	
		
	
	
	public int findLength(int[] nums1, int[] nums2) {
		
		
		int max = 0;
		
		int[][] dp = new int[nums1.length+1][nums2.length+1];
		
		for(int i=1; i<= nums1.length; i++)
		{
			for(int j=1; j<= nums2.length; j++)
			{
				if(nums1[i-1]==nums2[j-1])
				{
					dp[i][j] = dp[i-1][j-1]+1;
					
					max = Math.max(dp[i][j] , max);
				}
				else
				{
					dp[i][j]  = 0;
				}
				
			}
			
			
		}
	
		return max;
		
		
		
		
	}
}
