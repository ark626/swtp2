package main;

import java.util.ArrayList;
import java.util.Scanner;
import spellchecker.Spellchecker;
import dictionary.Dictfactory;
import dictionary.I_Dictionary;
import algos.Algofactory;
import algos.I_Editdistance;

public class Main {

	public static void main(String[] args){
		
		System.out.println("Gestartet");
		long Started = System.currentTimeMillis();
		I_Dictionary Dict = Dictfactory.getDictionary(Dictfactory.Dict.Huge);
		I_Editdistance Dist = Algofactory.getAlgorithm(Algofactory.Algorithm.DamereauLevenshtein);
		Spellchecker sc = Spellchecker.getInstance();
		Scanner s = new Scanner(System.in);
		long Loaded = System.currentTimeMillis();
		ArrayList<String> res =null;
		
		System.out.println("Ladezeit für die Bibliothek: "+(Loaded-Started));
		String Suchtext =s.nextLine(); 
		while(!Suchtext.equals("escape")){
			Started = System.currentTimeMillis();
			res = sc.spellchecker(Suchtext, 1, Dist, Dict);
			Loaded = System.currentTimeMillis();
			for(String text:res){
					System.out.println(text+" hat eine Distanz von "+(Dist.computeDistance(Suchtext, text))+" zu "+Suchtext);
			}
			System.out.println("Gefundene Vorschläge: " +res.size());
			System.out.println("Ladezeit für die Suche: "+(Loaded-Started));
			Suchtext =s.nextLine(); 
		}
		s.close();
	}

	public static void spellchecker(String s,int delta,I_Editdistance Dist,I_Dictionary Dict){	
}
	
}
