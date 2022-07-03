package lis;

import java.util.ArrayList;
import java.util.Arrays;

// https://www.youtube.com/watch?v=on2hvxBXJH4&list=PLgUwDviBIf0qUlt5H_kiKYaNSqJ81PMMY&index=44


public class LISUsingBinarySearch_Incomplete {

	
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

		ArrayList<Integer> temp = new ArrayList<>() ;
		
		
		temp.add(arr[0]);
		
		
		for(int i=1; i< arr.length; i++)
		{
			if(arr[i]> arr[i-1])
				temp.add(arr[i]);
			
			else 
			{
				
				int index = searchBinaryLowerBound(temp,arr[i]);
			}
			
		}
		
	}

	private static int searchBinaryLowerBound(ArrayList<Integer> temp, int value) {

			
		int start = 0;
		
		int end = temp.size()-1;
		
		
		while(start<end)
		{
		
			int middle = (start + end)/2;
			
			if(temp.get(middle)>= value)
			{
				
			}
		
			
			
		}
		
		
		// TODO Auto-generated method stub
		return 0;
	}	
	
}
