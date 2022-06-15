package basics;

public class Fibonaci_Striver {

	
	// https://www.youtube.com/watch?v=tyB0ztf0DNY&list=PLgUwDviBIf0qUlt5H_kiKYaNSqJ81PMMY&index=2
	
	
	// Check Fibonacci in memoisation
	
	public static void main(String[] args) {
		
		//fibUsingTable(5);
		
		fibUsingLessSpace(5);
		
		// 0  1  1  2  3  5
		
		
	}
	
	
	public static int fibUsingTable(int n) {
		
		int[] dp = new int[n+1];
		
		dp[0] = 0;
		dp[1]= 1;
		
		
		for(int i=2; i<=n; i++)
		{
			dp[i] = dp[i-1] + dp[i-2];
			
			
		}
		
		return dp[n];
		
	}
	
	
	
public static int fibUsingLessSpace(int n) {
		
		int[] dp = new int[n+1];
		
		int previous2  = 0;
		int previous = 1;
		
		
		for(int i=2; i<=n; i++)
		{
			
			int current = previous2 + previous;
			
			
			previous2 = previous;
			previous = current;
			        
			
		}
		
		return previous;
		
	}
	
	
}
