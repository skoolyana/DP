package stocks;

// https://www.youtube.com/watch?v=excAOvwF_Wk&list=PLgUwDviBIf0qUlt5H_kiKYaNSqJ81PMMY&index=36

// https://takeuforward.org/data-structure/stock-buy-and-sell-dp-35/


public class Best_Time_to_Buy_and_Sell_Stock {

	
public static void main(String[] args) {
	
	
	int[] Arr  ={7,1,5,3,6,4};

	  System.out.println("The maximum profit by selling the stock is "+maximumProfit(Arr));
}

	private static int  maximumProfit(int[] arr) {
	
	
		int cost = arr[0];  int profit = 0;
		
		 
		
		for(int i=1; i< arr.length; i++)
		{
			int temp_profit = arr[i] - cost;
			
			profit = Math.max(profit, temp_profit);
			
			cost = Math.min(arr[i], cost);
			
			
		}
		
		
		
	
	
	
	// TODO Auto-generated method stub
	return profit;
}



	
}
