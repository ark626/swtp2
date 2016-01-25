package knapsack;

public class Rucksackproblem 
{
	public static void main(String[] args) 
	{
		int[] g = new int[]{1,2,5,8};  // Gewichte
		int[] w = new int[]{1,3,9,12}; // und zugehörige Werte
		
		int maxGewicht = 15;
		int[] K = new int[maxGewicht+1];  // Array für die einzelnen Rucksackgrößen, index entspricht Gewicht,

		for( int i=1; i < K.length; i++)
		{
			for(int j=0; j < g.length; j++ )
			{
				if( i - g[j] >= 0 )
				{
					int tmp = K[i - g[j]] + w[j];
					if( tmp > K[i] )
					{
						K[i] = tmp;
					}
				}
			}
		}
		
		System.out.println("Packungsergebnis: ");	
		System.out.println(maxGewicht + " kg ->  " + K[maxGewicht] + " EURO");
		
		System.out.println();
		System.out.println("Einzelergebnisse");
		for( int i=0; i < K.length; i++ )
		{
			System.out.println(i + " kg ->  " + K[i] + " EURO");
		}
	}
}
