package basics;

import java.util.Arrays;

// https://www.youtube.com/watch?v=EgG3jsGoPvQ&list=PLgUwDviBIf0qUlt5H_kiKYaNSqJ81PMMY&index=4

// https://takeuforward.org/data-structure/dynamic-programming-frog-jump-dp-3/



public class FrogJump_Striver {

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
		
		//return getMinJumppEnergyusingDPTab(stair,jumps);
		
		return getMinJumppEnergyusingDPTabSpaceImprove(stair,jumps);
		
	}
	
	
	
	
	public static int getMinJumppEnergy(int index, int[] jumps)
	{
		
		
		int left = Integer.MAX_VALUE;
		int right = Integer.MAX_VALUE;
		
		
	
		if(index==0)
			return 0;
		
		
		 left = getMinJumppEnergy(index-1,jumps) + Math.abs(jumps[index]- jumps[index-1]);
			
		
		
		if(index> 1)
		
		right = getMinJumppEnergy(index-2,jumps) + Math.abs(jumps[index]- jumps[index-2]);
		
		
		
		return Math.min(left, right);
	
	}
	

	public static int getMinJumppEnergyusingDPMemo(int index, int[] jumps,int[] dp)
	{
		
		
		int left = Integer.MAX_VALUE;
		int right = Integer.MAX_VALUE;
		
		
	
		if(index==0)
			return 0;
		
		if(dp[index]!=-1)
		{
			return dp[index];
		}
		
		 left = getMinJumppEnergyusingDPMemo(index-1,jumps,dp) + Math.abs(jumps[index]- jumps[index-1]);
			
		
		
		if(index> 1)
		
		right = getMinJumppEnergyusingDPMemo(index-2,jumps,dp) + Math.abs(jumps[index]- jumps[index-2]);
		
		int min_val = Math.min(left, right);
		
		dp[index] = min_val;
		
		return min_val;
	
	}

	
	
	public static int getMinJumppEnergyusingDPTab(int n, int[] jumps)
	{
		
		
		int[] dp = new int[n];
		
		Arrays.fill(dp, -1);
		
		dp[0] = 0;
		
		
		for(int i=1; i< dp.length; i++)
		{
			
			int right = Integer.MAX_VALUE;
			int left = dp[i-1] + Math.abs(jumps[i] - jumps[i-1]);
			
			if(i> 1)
			{
				right = dp[i-2] + Math.abs(jumps[i] - jumps[i-2]);
			}
			
			int min_val = Math.min(left, right);
			
			dp[i] = min_val;
			
		

		}
		
			
			
		return dp[n-1];
	
	}
	

	
	
	
	public static int getMinJumppEnergyusingDPTabSpaceImprove(int n, int[] jumps)
	{
		
		
		
		int previous = 0;
		
		int previous2 = 0;
		
		
		for(int i=1; i< n; i++)
		{
			
			int right = Integer.MAX_VALUE;
			int left = previous + Math.abs(jumps[i] - jumps[i-1]);
			
			if(i> 1)
			{
				right = previous2 + Math.abs(jumps[i] - jumps[i-2]);
			}
			
			int min_val = Math.min(left, right);
			
			int current = min_val;
			
			previous2 = previous;
			previous = current;


		
		
		}
		
			
			
		return previous;
	
	}

	
	
}
