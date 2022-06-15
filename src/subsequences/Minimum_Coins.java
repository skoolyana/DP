package subsequences;

import java.util.Arrays;

// https://www.youtube.com/watch?v=myPeWb3Y68A&list=PLgUwDviBIf0qUlt5H_kiKYaNSqJ81PMMY&index=21

// https://takeuforward.org/data-structure/minimum-coins-dp-20/


public class Minimum_Coins {

	
		 public static void main(String args[]) {

		  int arr[] ={1,2,3};
		  int target=7;
		                                 
		  System.out.println("The minimum number of coins required to form the target sum is "+minimumElements(arr,target));
		
		  System.out.println("The minimum number of coins required in tabulation to form the target sum is "+ tabulate(target, arr));
		
		  System.out.println("The minimum number of coins required in tabulation to form the target sum is "+  optimisedouble(target, arr));

		
		 
		 
		 
		 }

		private static int minimumElements(int[] arr, int target) {

			int[][]dp = new int[arr.length][target+1];
			
			for(int[] dprow: dp)
			{
				
				Arrays.fill(dprow, -1);
			}
			
			
			return minimumElementsUtil(arr.length-1,target,arr,dp);
			
			
		}

		private static int minimumElementsUtil(int index, int target,int[] arr, int[][] dp) {
	
			
			if(index==0)
			{
			
				if(target%arr[index]==0)
					return target/arr[index] ;
				
				else
					return Integer.MAX_VALUE;
			}
			
			if(dp[index][target]!=-1)
			{
				return dp[index][target];
			}
			
			int pick = Integer.MAX_VALUE ;
			

			int notpick = 0 +  minimumElementsUtil(index-1,target,arr,dp);
			
			if(arr[index]<=target)
			{
				
				pick = 1 + minimumElementsUtil(index,target-arr[index],arr,dp);
				
			}
			
			
			// TODO Auto-generated method stub
			return dp[arr.length-1][target] = Math.min(pick, notpick);
		}
	
	
		
		private static int tabulate(int target,int[] arr) {
			
			int[][] dp = new int[arr.length][target+1];
					
					
						for(int trgt=0; trgt<=target; trgt++)
						{
							
							if(trgt%arr[0]==0)
							{
								dp[0][trgt] = trgt/arr[0];
							}
							else
								dp[0][trgt] = Integer.MAX_VALUE;
							
							
						}
						
						
			
					
					

					for(int ind=1; ind<arr.length; ind++)
					{
						for(int trgt=0; trgt<=target; trgt++)
						{
					
							int pick = Integer.MAX_VALUE ;

							int notpick = 0 +  dp[ind-1][trgt];
							
							if(arr[ind]<=trgt)
							{
								
								pick = 1 + dp[ind][trgt-arr[ind]];
								
							}
							
						
							
							dp[ind][trgt] = Math.min(pick, notpick); 
							
						}
						
					}
					// TODO Auto-generated method stub
					return dp[arr.length-1][target];
				}
	
	

		
		
		
		private static int optimisedouble(int target,int[] arr) {
			
			int[] previous = new int[target+1];
			int[] current = new int[target+1];
					
					
						for(int trgt=0; trgt<=target; trgt++)
						{
							
							if(trgt%arr[0]==0)
							{
								previous[trgt] = trgt/arr[0];
							}
							else
								previous[trgt] = Integer.MAX_VALUE;
							
							
						}
						
						
			
					
					

					for(int ind=1; ind<arr.length; ind++)
					{
						for(int trgt=0; trgt<=target; trgt++)
						{
					
							int pick = Integer.MAX_VALUE ;

							int notpick = 0 +  previous[trgt];
							
							if(arr[ind]<=trgt)
							{
								
								pick = 1 + current[trgt-arr[ind]];
								
							}
							
						
							
					current[trgt] = Math.min(pick, notpick); 
							
						}
						
						previous = current;
						
					}
					// TODO Auto-generated method stub
					return previous[target];
				}

		
		
		
		
		
	
}
