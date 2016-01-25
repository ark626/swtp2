package dictionary;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class HashList {

	//internal Datastructure
	Map<Integer, List<String>> list = new HashMap<Integer, List<String>>();
	 
	
	//The insert-method dont check for duplicates
	//Beacuse of performance reasons the check for duplicates
	//must be done within the trie structure.
	public void insert(String word) {
		
        
		int length = word.length();

		// create new key and map List<String> to it if this key doesnt exist
		if (list.get(length) == null) {
			list.put(length, new ArrayList<String>());
		}

		list.get(length).add(word.toLowerCase());

	}

	public ArrayList<String> getWordsOfLength(int l) {
		
		ArrayList<String> wordlist = new ArrayList<String>();
		
		//avoid nullpointer-exception
		if(list.containsKey(l)){
			Iterator<String> iterator = list.get(l).iterator();
			
			//iterate over List<String> mapped to key/length
			while (iterator.hasNext()) {
				wordlist.add((String) iterator.next());
			}
		}
		
		return wordlist;

	}
	
	public int getSize(){
		
		int size = 0 ;
		
		Set<Integer> array = list.keySet();
		Iterator<Integer> i = array.iterator();
		
		while(i.hasNext()){
			size += list.get(i.next()).size();
		}
		
		return size;
	}
}
