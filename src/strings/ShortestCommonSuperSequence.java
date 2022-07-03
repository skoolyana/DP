package strings;

import java.util.Arrays;

// https://takeuforward.org/data-structure/shortest-common-supersequence-dp-31/

// https://www.youtube.com/watch?v=xElxAuBcvsU&list=PLgUwDviBIf0qUlt5H_kiKYaNSqJ81PMMY&index=32




public class ShortestCommonSuperSequence {

	
	public static void main(String[] args) {
		 
		String s1 = "brute";
		String s2 = "groot";

		int subseqLength = shortestSupersequenceLength(s1,s2);
		
		System.out.println("The Longest Common subsequence is "+subseqLength);

		int subseqLength1 = tabulate(s1,s2);
		
		System.out.println("The Longest Common subsequence is "+subseqLength1);

		
		
		int superlenght = s1.length() + s2.length() - subseqLength;
		
		System.out.println("The Longest Common Supersequence is "+superlenght);

		  
	}
	
	static int shortestSupersequenceLength(String s1, String s2){
	
		
		int index1 = s1.length()-1;
		
		int index2 = s2.length()-1;

		
		int[][] dp = new int[s1.length()][s2.length()];
		
		for(int[] dprow : dp)
		{
			Arrays.fill(dprow, -1);
			
		}
		
		
		return recurse(index1,index2,s1,s2,dp);
		
		
	}

	private static int recurse(int index1, int index2, String s1, String s2,int[][] dp) {

	
		if(index1<0 || index2<0)
			return 0;
	
		
		if(dp[index1][index2] !=-1)
			return dp[index1][index2];
		
		if(s1.charAt(index1)==s2.charAt(index2))
		{
	
			return dp[index1][index2]= 1 + recurse(index1-1,index2-1,s1,s2,dp);
		}
		else
		{
			
			return dp[index1][index2] = 0 + Math.max(recurse(index1-1,index2,s1,s2,dp),recurse(index1,index2-1,s1,s2,dp));					
		}


		
	}

	
	
	private static int tabulate(String s1, String s2) {

		int[][] dp = new int[s1.length()+1][s2.length()+1];
	
		
		
		for(int i=0; i<=s2.length(); i++)
		{
			dp[0][i] = 0;
			
		}
		
		for(int i=0; i<=s1.length(); i++)
		{
			dp[i][0] = 0;
			
		}
		
		for(int i=1; i<=s1.length(); i++ )
		{
		

			for(int j=1; j<=s2.length(); j++ )
			{
				if(s1.charAt(i-1)==s2.charAt(j-1))
				{
					
					dp[i][j] = 1 + dp[i-1][j-1];
				}
				else
				{
					dp[i][j] = 0 + Math.max(dp[i][j-1], dp[i-1][j]);
					
				}
			}
				
			
		}
		
		int len = dp[s1.length()][s2.length()];

		int i = s1.length();

		int j = s2.length();

		int index = len - 1;

		String ans = "";

		while(i>0 && j> 0)
		{
			
			if(s1.charAt(i-1)==s2.charAt(j-1))
			{
				ans+=s1.charAt(i-1);

				index--;
				
				i--;
				
				j--;
			
			}
			 else if (dp[i - 1][j] > dp[i][j - 1]) {
				 
				 ans += s1.charAt(i-1);
				 
				 i--;
			 
			 }
			
			 else {
			        ans += s2.charAt(j-1);
			        j--;
			    }
			
		
		}
		
		while(i>0){
		      ans += s1.charAt(i-1);
		      i--;
		  }
		  while(j>0){
		      ans += s2.charAt(j-1);
		      j--;
		  }
		  
		  String ans2=new StringBuilder(ans).reverse().toString();
		  
		  System.out.println(ans2);
		
		return dp[s1.length()][s2.length()];

		
	}

	
	
	
	
	
	
}
