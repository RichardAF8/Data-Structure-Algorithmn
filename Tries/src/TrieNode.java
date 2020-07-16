import java.util.Arrays;

public class TrieNode {
	TrieNode [] arr = new TrieNode[26];
	TrieNode parent;
	boolean endOfWord;
	int currentIndex;
	int size;
	
	public TrieNode() {
		this.endOfWord=false;
		Arrays.fill(arr, null);
		size=0;
	}

}
