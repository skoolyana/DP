package strings;


// https://www.youtube.com/watch?v=_wP9mWNPL5w&list=PLgUwDviBIf0qUlt5H_kiKYaNSqJ81PMMY&index=28

// Copy tabulate of LCS

// https://takeuforward.org/data-structure/longest-common-substring-dp-27/




public class Longest_Common_Substring {

	
	public static void main(String[] args) {
	
		
		
		String s1= "abcjklp";
		  String s2= "acjkp";
		                                 
		  System.out.println("The Length of Longest Common Substring is "+tabulate(s1,s2));
	
			
	
	}
	
private static int tabulate(String s1, String s2) {
		
		
		int[][]dp = new int[s1.length()+1][s2.length()+1];

		
		int result = 0;
		
		
		for(int i=0; i<=s2.length(); i++)
		{
			dp[0][i] = 0;
			
		}
		
		for(int i=0; i<=s2.length(); i++)
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
					 
					 result = Math.max(result, dp[i][j]);
				}
				
			
				else
					
					 dp[i][j]= 0;

				
			}
				
			
			
		}
		
		return result;
}





}
