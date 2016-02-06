package algos;


public class Algofactory {

		public static enum Algorithm {
			Levenshtein, DamereauLevenshtein
		}

		public Algofactory() {
			super();
		}

		
		public static I_Editdistance getAlgorithm(Algorithm algorithm) {
			I_Editdistance Algo = null;
			switch (algorithm) {
			
			case Levenshtein:
				Algo = new Levenshtein();
				break;
			case DamereauLevenshtein:
				Algo = new LevenshteinDamerau();
				break;
			}
			return Algo;
		}
	


}
