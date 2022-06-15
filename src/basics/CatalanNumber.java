package basics;


// https://www.youtube.com/watch?v=eUw9A1wsFg8



public class CatalanNumber {

	public static void main(String[] args) {
		
		System.out.println(catalan(4));
	}
	
	
	public static int catalan(int k)
	{
		
		int catalan = 0;
		
		
		
		int[] arrCatalan = new int[k+1];
		
		arrCatalan[0] = 1;
		arrCatalan[1] = 1;
		
		
		for(int i=2; i<arrCatalan.length; i++)
		{
			
			for(int j=0; j< i; j++)
			{
				arrCatalan[i]+= arrCatalan[j] * arrCatalan[i-j-1];
			}
			
			
		}
		
		
		catalan = arrCatalan[k];
		
		
	return catalan;
		
		
		
		
	}
}
