//git
public class Trie {
	TrieNode root;
	int index;
	TrieNode iter;
	boolean delete;

	public Trie() {
		this.root = new TrieNode();
	}

	public void insert(String word) {
		insert2(word, root, 0, 0);
	}

	private void insert2(String word, TrieNode node, int x, int index) {
		
		if (x < word.length()) {
			index = word.charAt(x) - 96;
			x += 1;
			if (node.arr[index] == null) {
				node.arr[index] = new TrieNode();
				node.size += 1;
			}
			insert2(word, node.arr[index], x, 0);
		} else {
			node.endOfWord = true;
		}

	}

	public boolean search(String word) {
		return contains(word, root, 0);
	}

	private boolean contains(String word, TrieNode node, int x) {

		if (x < word.length()) {
			index = word.charAt(x) - 96;
			if (node.arr[index] == null) {
				return false;
			}
			return contains(word, node.arr[index], x + 1);
		}
		return node.endOfWord;
	}

	public void deletePrefix(String word) {
		deletePrefix2(word, root, 0);
	}

	private void deletePrefix2(String word, TrieNode node, int x) {
		index = word.charAt(x) - 96;

		if (x < word.length() - 1) {
			if (node.arr[index] == null) {
				return;
			} else {
				deletePrefix2(word, node.arr[index], x + 1);
			}

		} else if (node.arr[index] != null) {
			node.arr[index] = null;
			node.size -= 1;
		}
	}

	public void deleteWord(String word) {
		delete = true;
		deleteWord2(word, root, 0, 0);
	}

	private void deleteWord2(String word, TrieNode node, int x, int index2) {

		if (node == null) {
			return;
		}

		index2 = word.charAt(x) - 96;
		if (node.arr[index2] == null) {
			delete = false;
			return;
		}

		if (x < word.length() - 1) {

			deleteWord2(word, node.arr[index2], x + 1, 0);

		}
		if (node.arr[index2].size == 0 && delete == true) {
			node.arr[index2] = null;
			node.size -= 1;
		} else if (node.arr[index2].endOfWord == true && (x == word.length() - 1)) {
			node.arr[index2].endOfWord = false;
			delete = false;
		}
		if (node.endOfWord == true) {
			delete = false;
		}
	}
}