package knapsack;

class Item
{
  int wert;
  int gewicht;
  
  Item(int wert, int gewicht)
  {
     this.wert = wert;
     this.gewicht = gewicht;
  }
}

public class Rucksackproblem2
{
   public static void main(String[] args)
   {
      Item item1 = new Item( 1, 1 );
      Item item2 = new Item( 3, 2 );
      Item item3 = new Item( 9, 5 );
      Item item4 = new Item( 12, 8 );

      int maxGewicht = 15;
      int[] K = new int[maxGewicht + 1]; // Array für die einzelnen
                                         // Rucksackgrößen, index entspricht
                                         // Gewicht,

      for (int gewicht = 1; gewicht < K.length; gewicht++)
      {
            int w0, w1, w2, w3;
            w0 = w1 = w2 = w3 = 0;

            if (gewicht - item1.gewicht >= 0)
               w0 = K[gewicht - item1.gewicht] + item1.wert;
           
            if (gewicht - item2.gewicht >= 0)
               w1 = K[gewicht - item2.gewicht] + item2.wert;
            
            if (gewicht - item3.gewicht >= 0)
               w2 = K[gewicht - item3.gewicht] + item3.wert;
            
            if (gewicht - item4.gewicht >= 0)
               w3 = K[gewicht - item4.gewicht] + item4.wert;

            K[gewicht] = Math.max(Math.max(w0, w1), Math.max(w2, w3));
      }

      System.out.println("Packungsergebnis: ");
      System.out.println(maxGewicht + " kg ->  " + K[maxGewicht] + " EURO");

      System.out.println();
      System.out.println("Einzelergebnisse");
      for (int i = 0; i < K.length; i++)
      {
         System.out.println(i + " kg ->  " + K[i] + " EURO");
      }
   }
}
