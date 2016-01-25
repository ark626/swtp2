package dictionary;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class Dictfactory {
	
	public static enum Dict {
		Deutsch, English, Huge
	}

	public Dictfactory() {
		super();
	}

	
	public static Dictionary getDictionary(Dict dictionary) {
		Dictionary Dictionary = new Dictionary();
		BufferedReader in;
		String  path = "";
		
		switch (dictionary) {
		
		case Deutsch:
		 path = new File("src/top10000de.txt").getAbsolutePath();
			
			break;
		case English:
			path = new File("src/top10000en.txt").getAbsolutePath();
			break;
		case Huge:
			path = new File("src/german_copy.dic").getAbsolutePath();
			break;
		}
		try {
		String line;
		in = new BufferedReader(new FileReader(path));
			while((line = in.readLine()) != null)
			{
				//if(!Dictionary.contains(line)){
				Dictionary.Hash.insert(line);
				Dictionary.Trie.insert(line);;
				//}
			}
			in.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return Dictionary;
	}

}
