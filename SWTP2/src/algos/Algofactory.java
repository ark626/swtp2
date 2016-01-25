package algos;


public class Algofactory {

		public static enum Algorithm {
			Levenshtein, DamereauLevenshtein
		}

		public Algofactory() {
			super();
		}

		
		public static Distance getAlgorithm(Algorithm algorithm) {
			Distance Algo = null;
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
