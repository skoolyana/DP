package stocks;

public class BuyAndSellWithTransactionFee {

	public static void main(String[] args) {
		
		int[] arr = { 1, 3, 2, 8, 4,9};

		System.out.println(" The maximum profit that can be generated is " + getMaximumProfit(arr));

	
	}
	
	
	private static int getMaximumProfit(int[] arr) {
		
		
		int index = 0;
		
		int fee = 2;
		
		int buy = 1;
		
		return recurse(index,arr,buy,fee);
		
	}

	private static int recurse(int index, int[] arr, int buy, int fee) {
		
		  int profit = 0; 
		

		  if(index==arr.length)
			  return 0;
		  
		
			if(buy==1)
			{
				int NotbuyProfit = recurse(index+1,arr,1,fee);
			
				int buyProfit = -arr[index] + recurse(index+1,arr,0,fee);
			
				profit = Math.max(NotbuyProfit, buyProfit);
				
			}
			else if(buy==0)
			{
				
				int NotSellProfit = recurse(index+1,arr,0,fee);
				
				int SellProfit =  arr[index]-fee + recurse(index+1,arr,1,fee);
			
				profit = Math.max(NotSellProfit, SellProfit);
				
			}
		
		
		
		// TODO Auto-generated method stub
		return profit;
	}

	
}
