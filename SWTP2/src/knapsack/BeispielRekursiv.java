package knapsack;

public class BeispielRekursiv 
{
	private static int callCounter = 0;
	
	public static void main(String[] args) 
	{
		int[] g = new int[]{1,2,5,8};  // Gewichte
		int[] w = new int[]{1,3,9,15}; // Wert
		
		int gewicht = 35;
		long start = System.currentTimeMillis();
		int wert = getOptimalwert(gewicht, g,  w);
		long end = System.currentTimeMillis();
		
		System.out.println("Packungsergebnis: ");
		System.out.println(gewicht + " kg ->  " + wert + " EURO");
		System.out.println("Rekursionsaufrufe " + callCounter );
		System.out.println("Rechenzeit: " + (end - start) + " [ms]");
	}

	public static int getOptimalwert(int pos, int[] g, int[] w)
	{
		callCounter++;
		int[] val = new int[g.length];
		for(int j=0; j < g.length; j++ )
		{
			if( pos - g[j] >= 0 )
			{
				val[j] = getOptimalwert(pos - g[j], g, w) + w[j];
			}
			else
			{
				val[j] = 0;
			}
		}
		
		int max = 0;
		for( int i=0; i < val.length; i++ )
		{
			if( val[i] > max )
				max = val[i];
		}
		
		return max;
	}
}
