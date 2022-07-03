package strings;

// https://www.youtube.com/watch?v=6i_T5kkfv4A&list=PLgUwDviBIf0qUlt5H_kiKYaNSqJ81PMMY&index=29

// Copy LCS tabulate

// https://takeuforward.org/data-structure/longest-palindromic-subsequence-dp-28/



// https://www.youtube.com/watch?v=xPBLEj41rFU&list=PLgUwDviBIf0qUlt5H_kiKYaNSqJ81PMMY&index=30

// https://takeuforward.org/data-structure/minimum-insertions-to-make-string-palindrome-dp-29/



// https://www.youtube.com/watch?v=yMnH0jrir0Q&list=PLgUwDviBIf0qUlt5H_kiKYaNSqJ81PMMY&index=31

// https://takeuforward.org/dynamic-programming/striver-dp-series-dynamic-programming-problems/





public class LongestPalindromicSubsequence {

	public static void main(String[] args) {
		String s= "bbabcbcab";
        
		  System.out.print("The Length of Longest Palindromic Subsequence is ");
		  System.out.println(longestPalindromeSubsequence(s));
	
		  
		    String t = s;
		    String ss=new StringBuilder(s).reverse().toString();
		
			  System.out.print("The Length of Longest Palindromic Subsequence is ");
			  System.out.println(optimise(ss,t));
		
	
			  String str= "abcaa";
			  System.out.println("The Minimum insertions required to make string palindrome: "+
					  minimuminsertionstomakeStringPalindrome(str));
	
	}
	

	static int minimuminsertionstomakeStringPalindrome(String s){
		
		
		int length = s.length();
		int longestpalindromsequence = longestPalindromeSubsequence(s);
		
		return length - longestpalindromsequence;
		
		
		
	}

	
	
	static int longestPalindromeSubsequence(String s){
	    String t = s;
	    String ss=new StringBuilder(s).reverse().toString();
	    return tabulate(ss,t);
	}
	
	
	private static int tabulate(String s1, String s2) {
		
		
		int[][]dp = new int[s1.length()+1][s2.length()+1];

		
		
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
