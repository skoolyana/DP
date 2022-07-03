package basics;

import java.util.ArrayList;

// https://www.youtube.com/watch?v=3WaxQMELSkw&list=PLgUwDviBIf0qUlt5H_kiKYaNSqJ81PMMY&index=7

// https://leetcode.com/problems/house-robber-ii/

// https://leetcode.com/problems/house-robber-ii/submissions/



public class HouseRobber2 {

	public static void main(String[] args) {
		
		ArrayList<Integer> aList = new ArrayList<>();
		
		aList.add(2);

		aList.add(1);
		aList.add(4);
		aList.add(9);
		
		ArrayList<Integer> temp = new ArrayList<>(aList); 
		temp.remove(temp.size()-1);
		
		int lastRemove = recursespaceoptimise(temp);
		
		ArrayList<Integer> temp2 = new ArrayList<>(aList); 
		
		temp2.remove(0);
		
		
		int firstRemove = recursespaceoptimise(temp2);
		
		System.out.println(Math.max(lastRemove, firstRemove));
		
		int[] nums = {1,2,3,1};
		
		System.out.println(robbing(nums));
		
		
	}
	
	
	
	private static int robbing(int[] nums) {
		
		
		return recurse(nums.length-1,nums,0);
		
	}

	
	int max = 0;
	
	
      private static int recurse(int index, int[] nums,boolean robbed) {

    	  
    	  if(index<0)
    		  return 0;
    	  
    	  
    	  
    	  
    	    int rob = nums[index];
    	  
    		int notRob = 0;
    	    
    	  	if(index-2>=0)
    	  	{
    	  		rob+=recurse(index-2, nums);
    	  	}
    	  
    	  	if(index-1>=0)
    	  	{
    	  		notRob  = recurse(index-1,nums);
    	  	}
    	  	
    	  
    	  // TODO Auto-generated method stub
		return Math.max(rob, notRob);
	}


      
      

private static int recursespaceoptimise(ArrayList<Integer> nums) {
		
	
		int n = nums.size();
		
		//int[] dp = new int[index+1];
		//Arrays.fill(dp, -1);
		
		int previous = nums.get(0);
		
		
		int previous2 = 0;
		
		
		for(int i=1; i<n; i++)
		{
			int pick = nums.get(i) ;
			
			if(i>1)
				pick+= previous2;
			int notpick = 0 + previous;
			
			int current = Math.max(pick,notpick);
			
			//dp[i] = Math.max(pick,notpick);
			
			previous2= previous;
			previous = current;
		}
		

		return previous;
		
		
	}
	
}
