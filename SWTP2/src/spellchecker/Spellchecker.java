package spellchecker;

import java.util.ArrayList;

import algos.Distance;
import dictionary.Dictionary;

public class Spellchecker {
	
	public static ArrayList<String> spellchecker(String s,int delta,Distance Dist,Dictionary Dict){

		ArrayList<String> result = new ArrayList<String>();
		ArrayList<String> res = new ArrayList<String>();
		

		if(!Dict.contains(s)){
			for(String text:Dict.Hash.getWordsOfLength(s.length())){
				result.add(text);
			}
			for(String text:Dict.Hash.getWordsOfLength(s.length()+1)){
				result.add(text);
			}
			if(s.length() >= 1){
			for(String text:Dict.Hash.getWordsOfLength(s.length()-1)){
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
