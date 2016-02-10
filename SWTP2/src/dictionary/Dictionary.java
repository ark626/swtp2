package dictionary;

import java.util.List;

public class Dictionary implements I_Dictionary {
	public I_TrieMap Trie;
	public HashList Hash;
	
	public Dictionary(){
		Trie = new TrieMap();
		Hash = new HashList();
	}
	
	public boolean contains(String word) {
		return Trie.search(word);
	}
	
	public void insert(String word) {
		
		if(!this.Trie.search(word)){
			this.Trie.insert(word);
			this.Hash.insert(word);
		}
	}
	
	public int size(){
		return this.Hash.getSize();
	}
	
	public List<String> getWords(int length) {
		
		return this.Hash.getWordsOfLength(length);
	}



}
