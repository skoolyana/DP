package basics;

// https://www.pepcoding.com/resources/online-java-foundation/dynamic-programming-and-greedy/target_sum_subsets_dp/topic


// https://www.youtube.com/watch?v=tRpkluGqINc



public class TargetSumSubSets {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int n=6;
			
		int[] arr = new int[] {5,4,2,3,1,7};
		
		int target = 10;
		
		
		
		boolean[][] dp = new boolean[n+1][target+1];
		
		
		for(int i=0; i< dp.length; i++)
		{
			
			for(int j=0; j<dp[0].length; j++)
			{
				if(i==0 && j==0)
				{
					dp[i][j] = true;
					
				}
				else if(i==0)
				{
					dp[i][j]=false; // all of first row is false
					
				}
				else if(j==0)
				{
					dp[i][j]=true; // Start of all coumns is true
					
				}
				else
				{
					if(dp[i-1][j]==true)
					dp[i][j]= true;
				
					else
					{
						
						int val = arr[i-1];
						
						if(j>=val)
						{
							if(dp[i-1][j-val]==true)
							{
								dp[i][j]= true;
								
							}
						}
					}
			
					
				}
				
			}
			
		}
		
		
		System.out.println(dp[arr.length][target]);
		
	}

}
