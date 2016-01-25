package knapsack;

public class RucksackproblemBenchmark 
{
	public static void main(String[] args) 
	{
		int[] g = new int[]{1,2,5,8};  // Gewichte
		int[] w = new int[]{1,3,9,12}; // und zugehörige Werte
		
		long start1, end1;
		long start2, end2;
		
		for(int i=30; i <= 38; i += 2 )
		{
			int v1, v2;
			
			System.out.println("Rucksackgröße : " + i );
			
			System.out.println("DP-Version:");
			start1 = System.currentTimeMillis();
			v1 = getOptimalPackage(i, g, w);
			end1 = System.currentTimeMillis();
			System.out.println("Result = " + v1);
			System.out.println("Time : " + (end1 - start1));
			
			System.out.println("Rekursiv-Version:");
			start2 = System.currentTimeMillis();
			v2 = getOptimalPackageRekursiv(i, g, w);
			end2 = System.currentTimeMillis();
			System.out.println("Result = " + v2);
			System.out.println("Time : " + (end2 - start2));
			
			System.out.println();
		}
		
		
	}
	
	
	public static int getOptimalPackageRekursiv(int pos, int[] g, int[] w)
	{
		int[] val = new int[g.length];
		for(int j=0; j < g.length; j++ )
		{
			if( pos - g[j] >= 0 )
			{
				val[j] = getOptimalPackageRekursiv(pos - g[j], g, w) + w[j];
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
