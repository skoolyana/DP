package basics;

// https://youtu.be/Ph1EB07Q4pA

//https://youtu.be/l_nR5X9VmaI

public class CoinChangeCombinations {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		int n=4;
		
		int[] arr = new int[] {2,3,5,7};
		
		int amount = 10;
		
		int[] dp = new int[amount+1];
		
		
		dp[0] = 1;
		
		
		
		for(int i=0; i< arr.length; i++)
		{
			for(int j=arr[i];j< dp.length; j++)
			{
				
				dp[j] = 	dp[j] + 	dp[j-arr[i]]; 
				
			}
			
		}
		
		System.out.println(dp[amount] );
		
	}

}

