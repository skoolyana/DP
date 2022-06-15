package basics;


// https://www.pepcoding.com/resources/online-java-foundation/dynamic-programming-and-greedy/climb_stairs_with_variable_jumps/topic


// https://youtu.be/uNqoQ0sNZCM

// https://www.youtube.com/watch?v=uNqoQ0sNZCM




public class ClimbStairsWithVariableJumps {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int n = 13;
		
		
		
		int[] arr = new int[] {5,5,2,4,1,5,9,8,6,3,8,9,1};
		
		int[] dp = new int[n+1];
		
		dp[n] = 1;
		
		for(int i=n-1; i>=0 ; i--)
		{
			
			for(int j=1; j<=arr[i] && i+j< dp.length; j++)
			{
				dp[i] = dp[i] + dp[i+j];
				
			}
			
		}
		
		System.out.println(dp[0]);

	}
	
	
	
	
}
