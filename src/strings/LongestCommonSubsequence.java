package strings;

import java.util.Arrays;

// https://www.youtube.com/watch?v=NPZn9jBrX8U&list=PLgUwDviBIf0qUlt5H_kiKYaNSqJ81PMMY&index=26

// https://takeuforward.org/data-structure/longest-common-subsequence-dp-25/


// tabulation : Understand right shift

// Print also :  https://www.youtube.com/watch?v=-zI4mrF2Pb4&list=PLgUwDviBIf0qUlt5H_kiKYaNSqJ81PMMY&index=27

// https://takeuforward.org/data-structure/print-longest-common-subsequence-dp-26/





public class LongestCommonSubsequence {

	public static void main(String[] args) {
		
		String s1= "acd";
		  String s2= "ced";
		                                 
		  System.out.println("The Length of Longest Common Subsequence is "+lcs(s1,s2));
		  
		  System.out.println("The Length of Longest Common Subsequence is "+tabulate(s1,s2));

	
		  System.out.println("The Length of Longest Common Subsequence is "+optimise(s1,s2));

	
	}
	
	static int lcs(String s1, String s2)
	{
		
		int index1 = s1.length()-1;
		
		int index2 = s2.length()-1;

		int[][]dp = new int[s1.length()][s2.length()];

		for(int[] dprow : dp)
		{
			Arrays.fill(dprow, -1);
			
		}
		
		
		return recurse(index1,s1,index2,s2,dp);
		
		
		
	}

	private static int recurse(int index1, String s1, int index2, String s2, int[][] dp) {
		
		if(index1<0 || index2 < 0)
		{
			return 0;
		}

	
		if(dp[index1][index2]!=-1)
		{
			return dp[index1][index2];
		}
		
		
		if(s1.charAt(index1)==s2.charAt(index2))
		{		
			return dp[index1][index2]= 1 + recurse(index1-1,s1,index2-1,s2,dp);
		}
		
	
		else
			
			return dp[index1][index2]= 0 + Math.max(recurse(index1-1,s1,index2,s2,dp), recurse(index1,s1,index2-1,s2,dp));
		
	}
	
	
	
	private static int tabulate(String s1, String s2) {
		
		
		int[][]dp = new int[s1.length()+1][s2.length()+1];

		
		
		for(int i=0; i<=s2.length(); i++)
		{
			dp[0][i] = 0;
			
		}
		
		for(int i=0; i<=s1.length(); i++)
		{
			dp[i][0] = 0;
			
		}
		
		
		for(int i=1; i<=s1.length(); i++)
		{

			for(int j=1; j<=s2.length(); j++)
			{
				
				if(s1.charAt(i-1)==s2.charAt(j-1))
				{		
					 dp[i][j]= 1 + dp[i-1][j-1];
				}
				
			
				else
					
					 dp[i][j]= 0 + Math.max(dp[i-1][j], dp[i][j-1]);

				
			}
				
			
			
		}
		
		
		int length = dp[s1.length()][s2.length()];
		
		int i = s1.length();
		
		int j = s2.length();
		
		 int index = length-1;
		 
		 String str="";
		    for(int k=1; k<=length;k++){
		        str +="$"; // dummy string
		    }
		 
		
		    StringBuilder ss= new StringBuilder(s1);
		    StringBuilder str2=new StringBuilder(str);
		    
		    while(i>0 && j>0){
		    	
		    	if(ss.charAt(i-1) == s2.charAt(j-1)){
		    		
		    		str2.setCharAt(index,ss.charAt(i-1) ); 
		    		
		    		 index--;
		             i--;
		             j--;
		    	}
		    	 else if(ss.charAt(i-1)>s2.charAt(j-1)){
		             i--;
		         }
		    	 else j--;
		    	
		    }
		    
		    System.out.println(str2);    
		
		return dp[s1.length()][s2.length()];
		
	}
	

	
	
	
	private static int optimise(String s1, String s2) {
		
		
		int[]previous = new int[s2.length()+1];
		
		int[]current = new int[s2.length()+1];

		
				
		for(int i=0; i<=s2.length(); i++)
		{
			previous[i] = 0;
			
		}
		
		
		
		
		for(int i=1; i<=s1.length(); i++)
		{

			for(int j=1; j<=s2.length(); j++)
			{
				
				if(s1.charAt(i-1)==s2.charAt(j-1))
				{		
					current[j]= 1 + previous[j-1];
				}
				
			
				else
					
					current[j]= 0 + Math.max(previous[j], current[j-1]);

				
			}
				
			
			previous = current;
			
			
		}
		
		return previous[s2.length()];
		
	}

	
	
}
