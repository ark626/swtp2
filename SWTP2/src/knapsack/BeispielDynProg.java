package knapsack;

public class BeispielDynProg 
{
	public static void main(String[] args) 
	{
      int[] g = new int[]{1,2,5,8};  // Gewichte
      int[] w = new int[]{1,3,9,12}; // Wert
      
      int gewicht = 35;
      
      long start = System.currentTimeMillis();
      int wert = getOptimalPackage(gewicht, g,  w);
      long end = System.currentTimeMillis();
      
      System.out.println("Packungsergebnis: ");
      System.out.println(gewicht + " kg ->  " + wert + " EURO");
      System.out.println("Rechenzeit: " + (end - start) + " [ms]");
	}

	
	

	
	public static int  getOptimalPackage(int maxGewicht, int[] g, int[] w) 
	{
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
		
		return K[maxGewicht];
	}
}
