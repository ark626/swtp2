package knapsack;

public class Beispiel 
{
	public static void main(String[] args) 
	{	
		int maxGewicht = 15;
		// Array für die einzelnen Rucksackgrößen, index entspricht Gewicht
		int[] K = new int[maxGewicht+1];  

		// Schleife über die Rucksackgrößen
		K[0] = 0;
		for( int i=1; i < K.length; i++)
		{
			int v1 = 0, v2 = 0, v3 = 0, v4 = 0;
			
			// Prüfe, ob Problem von einem kleineren Rucksack 
			// abgeleitet werden kann
			
			// 1 kg-Gegenstand
			if( i - 1 >= 0 )
			{
				v1 = K[i-1] + 1;
			}
			
			// 2 kg-Gegenstand
			if( i - 2 >= 0 )
			{
				v2 = K[i-2] + 3;
			}
			
			// 5 kg-Gegenstand
			if( i - 5 >= 0 )
			{
				v3 = K[i-5] + 9;
			}
			
			// 8 kg-Gegenstand
			if( i - 8 >= 0 )
			{
				v4 = K[i-8] + 12;
			}
			
			// Bestimme Maximum von v1,v2,v3,v4
			int max = v1;
			if( v2 > max ) max = v2;
			if( v3 > max ) max = v3;
			if( v4 > max ) max = v4;
			
			K[i] = max;
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
