package basics;

import java.util.ArrayList;
import java.util.Arrays;

// https://www.youtube.com/watch?v=AE39gJYuRog&list=PLgUwDviBIf0qUlt5H_kiKYaNSqJ81PMMY&index=8

// https://takeuforward.org/data-structure/dynamic-programming-ninjas-training-dp-7/




public class NinjaTraining_striver {
	
	
	public static void main(String[] args) {
		
		
		int n=3;
		ArrayList<ArrayList<Integer>> points = new ArrayList<>();
		
		for(int i=0; i< n; i++)
		{
			points.add(new ArrayList<>());
			
		}
		
		points.get(0).add(10);
		points.get(0).add(40);
		points.get(0).add(70);
		
		points.get(1).add(20);
		points.get(1).add(50);
		points.get(1).add(80);
	
		points.get(2).add(30);
		points.get(2).add(60);
		points.get(2).add(90);
	
		
		System.out.println(ninjaTraining(n,points));
		
		System.out.println(tabulate(n, points));
		
		System.out.println(spaceoptimise(n, points));
		
	}
	
	
	public static int ninjaTraining(int n, ArrayList<ArrayList<Integer>> points)
	{
		int[][] dp = new int[n][4];
		
		for(int[] row: dp)
		{
			Arrays.fill(row, -1);
			
		}
		
		
		
		return recurse(n-1,3,points,dp);
	}
	
	
	private static int recurse(int day, int last, ArrayList<ArrayList<Integer>> points, int[][] dp )
	{
		
		
		if(day==0)
		{
			
			int max = 0;
			for(int task=0; task< 3; task++)
			{
				
				if(task!=last)
				{
					max = Math.max(max, points.get(0).get(task));
					
				}
				
			}
			return max;
		}
		
		if(dp[day][last]!=-1)
		{
			return dp[day][last];
		}
		
		int max = 0;
		
		for(int task=0; task< 3; task++)
		{
			if(task!=last)
			{
				int point = points.get(day).get(task) + recurse(day-1, task, points,dp);
				
				max = Math.max(max, point);
				
				dp[day][last] = max;
			}
			
			
		}
	
		
		
	
		
		return max;
	}
	

	
	
	private static int tabulate(int n, ArrayList<ArrayList<Integer>> points )
	{
		
		int[][] dp = new int[n][4];
		
		
		dp[0][0] = Math.max(points.get(0).get(1), points.get(0).get(2));
		dp[0][1] = Math.max(points.get(0).get(0), points.get(0).get(2));
		dp[0][2] = Math.max(points.get(0).get(0), points.get(0).get(1));
		dp[0][3] = Math.max(points.get(0).get(0), Math.max(points.get(0).get(2),points.get(0).get(1)));
		
		
		for(int day=1; day<n;day++)
		{
			
			for(int last=0; last<4;last++)
			{
				dp[day][last] = 0;
				
				int maxi = 0;
				
				for(int task=0; task<3; task++)
				{
					if(task!=last)
					{
						int point = points.get(day).get(task) + dp[day-1][task];
						
						maxi = Math.max(maxi, point);
						
						
					}
					
				}
				
				dp[day][last] = maxi;
				
			}
			
		}
		
				
	
		
		return dp[n-1][3];
	}

	

	private static int spaceoptimise(int n, ArrayList<ArrayList<Integer>> points )
	{
		
		int[] prev = new int[4];
		
		
		prev[0] = Math.max(points.get(0).get(1), points.get(0).get(2));
		prev[1] = Math.max(points.get(0).get(0), points.get(0).get(2));
		prev[2] = Math.max(points.get(0).get(0), points.get(0).get(1));
		prev[3] = Math.max(points.get(0).get(0), Math.max(points.get(0).get(2),points.get(0).get(1)));
		
		
		for(int day=1; day<n;day++)
		{
			int[] temp = new int[4];
			
			for(int last=0; last<4;last++)
			{
				temp[last] = 0;
				
				
				
				for(int task=0; task<3; task++)
				{
					if(task!=last)
					{
						int point = points.get(day).get(task) + prev[task];
						
						temp[last]  = Math.max(temp[last] , point);
						
						
					}
					
				}
				
				
				
				
			}
			
			prev = temp;
			
		}
		
				
	
		
		return prev[3];
	}

	
	
	
	
}
