package dictionary;

import java.util.LinkedList;

public class TrieNode {

		
		// TODO -> make members private and implement getters
		// and setters to use in trie
		char content;
		boolean isEnd;
		int count;
		LinkedList<TrieNode> childs;
		
		public TrieNode(char c ){
			
			this.childs = new LinkedList<TrieNode>();
			this.isEnd = false;
			this.content = c;
			count = 0 ; 
		}
		
		
	    public TrieNode subNode(char c)

	    {

	        if (childs != null)

	            for (TrieNode eachChild : childs)

	                if (eachChild.content == c)

	                    return eachChild;

	        return null;
	    }
	


}
