package main;

import java.util.ArrayList;
import java.util.Scanner;

import spellchecker.Spellchecker;
import dictionary.Dictfactory;
import dictionary.Dictionary;
import algos.Algofactory;
import algos.Algofactory.Algorithm;
import algos.Distance;
import algos.LevenshteinDamerau;

public class Main {

	public static void main(String[] args){
		
		System.out.println("Gestartet");
		long Started = System.currentTimeMillis();
		Dictionary Dict = Dictfactory.getDictionary(Dictfactory.Dict.Huge);
		Distance Dist = Algofactory.getAlgorithm(Algofactory.Algorithm.DamereauLevenshtein);
		Scanner s = new Scanner(System.in);
		long Loaded = System.currentTimeMillis();
		
		System.out.println("Ladezeit für die Bibliothek: "+(Loaded-Started));
		String Suchtext =s.nextLine(); 
		while(!Suchtext.equals("escape")){
			Started = System.currentTimeMillis();
			ArrayList<String> res = Spellchecker.spellchecker(Suchtext, 1, Dist, Dict);
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

	public static void spellchecker(String s,int delta,Distance Dist,Dictionary Dict){	
}
	
}
