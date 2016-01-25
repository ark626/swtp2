package dictionary;

import java.util.List;

public interface I_Dictionary {
	public boolean contains(String word);
	public void insert (String word);
	public int size();
	public List<String> getWords(int length);

}
