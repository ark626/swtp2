

package dictionary;

public class TrieMap implements I_TrieMap{

	 private TrieNode root;
	 private long size;
	 
	 protected TrieMap(){
		 root = new TrieNode(' '); 
		 this.size = 0;
	 }
	 
	 public static TrieMap getEmptyTrie(){
		 return new TrieMap();
	 }
	 
	 public void insert(String word){
		 if(search(word) == true){
			 return;
		 }
		 TrieNode current = root; 
		 for(char ch : word.toCharArray()){
			 //CONVERT ALL INSERTED CHARACTERS TO LOWERCASE
			 ch = Character.toLowerCase(ch);
			 TrieNode child = current.subNode(ch);
			 if(child != null){
				 current = child;
			 }
			 else {
				 current.childs.add(new TrieNode(ch));
				 current = current.subNode(ch);
			 }
			 current.count++;
		 }
		 current.isEnd = true ; 
		 size++;
	 }
	 
	public boolean search(String word){
		TrieNode current = root;
		for(char ch : word.toCharArray()){
			//CONVRT ALL CHARS TO LOWERCASE
			ch = Character.toLowerCase(ch);
			if(current.subNode(ch) == null){
				return false;
			}
			else{
				current = current.subNode(ch);
			}
		}

		if(current.isEnd == true){
			return true;
		}
		return false;
	}

	public void remove(String word){
	  if (search(word) == false)
{
	    System.out.println(word +" does not exist in trie\n");
	       return;
}             
	  TrieNode current = root;
	    for (char ch : word.toCharArray()) { 
	    	//CONVERT ALL CHARS TO LOWERCASE
	    	ch = Character.toLowerCase(ch);
	        TrieNode child = current.subNode(ch);
	        if (child.count == 1) {
	            current.childs.remove(child);
	            this.size--;
	            return;
	        } 
	        else {	
	            child.count--;
	            current = child;
	        }}
	    current.isEnd = false;
	}

	public long getSize(){
		return this.size;
	}

}

