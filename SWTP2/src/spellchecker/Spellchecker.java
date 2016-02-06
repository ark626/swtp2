package spellchecker;

import java.util.ArrayList;




import algos.I_Editdistance;
import dictionary.I_Dictionary;

public class Spellchecker {
	
	private static class SingletonHelper {
		private static final Spellchecker INSTANCE = new Spellchecker();
	}

	public static Spellchecker getInstance() {
		return SingletonHelper.INSTANCE;
	}
	
	public  ArrayList<String> spellchecker(String s,int delta,I_Editdistance Dist,I_Dictionary dict){

		ArrayList<String> result = new ArrayList<String>();
		ArrayList<String> res = new ArrayList<String>();
		

		if(!dict.contains(s)){
			for(String text:dict.getWords(s.length())){
				result.add(text);
			}
			for(String text:dict.getWords(s.length()+1)){
				result.add(text);
			}
			if(s.length() >= 1){
			for(String text:dict.getWords(s.length()-1)){
				result.add(text);
			}
			}
			
			for(int i = 0;i<result.size();i++){
			//	System.out.println(result.get(i)+": "+Levenshtein.computeLevenshteinDistance(s, result.get(i)));
				if((Dist.computeDistance(s, result.get(i))) <= delta){
					res.add(result.get(i));
				}
			}
		}
		else{
			res.add(s);
		}
		return res;
	}

}
