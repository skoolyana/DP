package basics;

// https://www.pepcoding.com/resources/online-java-foundation/dynamic-programming-and-greedy/climb_stairs/topic

// https://www.youtube.com/watch?v=A6mOASLl2Dg&list=PL-Jc9J83PIiG8fE6rj9F5a6uyQ5WPdqKy&index=2


// https://www.youtube.com/watch?v=mLfjzJsN8us&list=PLgUwDviBIf0qUlt5H_kiKYaNSqJ81PMMY&index=3



public class ClimbStairs {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.out.println(countPaths(10,new int[11]));
		
		System.out.println(countPathsTab(10));
		
		
	}
	
	public static int countPaths(int n, int[] memo)
	{
		if(n==0)
			return 1;
		
		if(n<0)
			return 0;
		
		if(memo[n]> 0)
		{
			return memo[n];
		}
		
		
		int paths1 = countPaths(n-1,memo); // faith
		
		int paths2 = countPaths(n-2, memo); // faith
		
		int paths3 = countPaths(n-3, memo); // faith
		
		
		int pathsn = paths1 + paths2 + paths3 ;
		
		memo[n] = pathsn;
				
		return pathsn;
		
	}
	
	public static int countPathsTab(int n)
	{
		
		int[] dp = new int[n+1];
		
		dp[0] = 1;
		
		
		for(int i=1; i<=n;i++)
		{
			
			if(i==1)
				dp[i]=1;
			else if(i==2)
				dp[i]=2;
			else
			{
				dp[i] = dp[i-1] + dp[i-2] + dp[i-3]; 
				
			}
			
		}
				
		return dp[n];
		
	}

}
