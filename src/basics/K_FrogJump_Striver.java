package basics;

import java.util.Arrays;

// https://www.youtube.com/watch?v=Kmh3rhyEtB8&list=PLgUwDviBIf0qUlt5H_kiKYaNSqJ81PMMY&index=5



public class K_FrogJump_Striver {

	
	public static void main(String[] args) {
		int[] jumps = new int[] {30,10,60,10,60,50}; 
		
		System.out.println(getMainFrog(6,jumps));

	}
	
	
	public static int getMainFrog(int stair, int[] jumps)
	{
		
	//	return getMinJumppEnergy(stair-1,jumps);
	
		//int[] dp = new int[stair+1];
		
		//Arrays.fill(dp, -1);
		
		//return getMinJumppEnergyusingDPMemo(stair-1,jumps,dp);
		
		return getMinJumppEnergyusingDPTab(stair,jumps,2);
		
		//return getMinJumppEnergy(stair-1,jumps,2);
		
	}
	
	public static int getMinJumppEnergy(int index, int[] jumps, int k)
	{
		
		
		int left = Integer.MAX_VALUE;
		int right = Integer.MAX_VALUE;
		
		int min = Integer.MAX_VALUE;
		
	
		if(index==0)
			return 0;
		
		
		for(int j=1; j<=k; j++)
		{
			if(index-j>=0)
			{
				int eneregy = getMinJumppEnergy(index-j,jumps,k) + Math.abs(jumps[index]- jumps[index-j]);
				
				min = Math.min(min, eneregy);
			}
			else 
				break;
			
		}
		
		
		
		
		return min;
	
	}

	public static int getMinJumppEnergyusingDPTab(int n, int[] jumps,int k)
	{
		
		
		int[] dp = new int[n];
		
		Arrays.fill(dp, -1);
		
		dp[0] = 0;
		
		
		for(int i=1; i< dp.length; i++)
		{
			
			int min = Integer.MAX_VALUE;
			
			
			for(int j=1; j<=k; j++)
			{
				if(i-j>=0)
				{
					int jump = dp[i-j] + Math.abs(jumps[i] - jumps[i-j]);
					
					min = Math.min(min, jump);
				}
				
				
				
			}
			
			
			dp[i] = min;
			
		

		}
		
			
			
		return dp[n-1];
	
	}
	

	
	
	
}
