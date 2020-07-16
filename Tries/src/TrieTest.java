import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class TrieTest {

	@Test
	void delete() {
		Trie r = new Trie();
		
		
		r.insert("cartwheel");
		r.insert("cop");
		r.insert("dartboard");
		r.insert("cat");
		r.insert("car");
		r.insert("dart");

		r.deleteWord("car");
		
		assertFalse(r.search("car"));
		assertTrue(r.search("cartwheel"));
		assertTrue(r.search("cat"));
		assertTrue(r.search("dart"));
		assertTrue(r.search("cop"));
		assertTrue(r.search("dartboard"));
		
		r.deleteWord("cartwheel");
		
		assertFalse(r.search("cartwheel"));

		
		assertTrue(r.search("cat"));
		assertTrue(r.search("dart"));
		assertTrue(r.search("cop"));
		assertTrue(r.search("dartboard"));

		r.deleteWord("dartboard");
		
		assertFalse(r.search("dartboard"));

		assertTrue(r.search("cat"));
		assertTrue(r.search("dart"));
		assertTrue(r.search("cop"));
		
		
		r.deleteWord("caty");
		
		assertTrue(r.search("cat"));
		assertTrue(r.search("dart"));
		assertTrue(r.search("cop"));
		
		
	}
	@Test
	void insert_search() 
	{
		Trie t = new Trie();
		t.insert("banana");
		assertTrue(t.search("banana"));
		
	}
	
	@Test
	void prefixDelete() {
		Trie h = new Trie();
		
		h.insert("cartwheel");
		h.insert("cop");
		h.insert("dartboard");
		h.insert("cat");
		h.insert("car");
		h.insert("dart");
		
		h.deletePrefix("ca");
		
		assertTrue(h.search("dart"));
		assertTrue(h.search("dartboard"));
		assertTrue(h.search("cop"));
		
		assertFalse(h.search("cat"));
		assertFalse(h.search("car"));
		assertFalse(h.search("cartwheel"));

		h.deletePrefix("dart");
		
		assertTrue(h.search("cop"));
		assertFalse(h.search("dartboard"));
		assertFalse(h.search("dart"));
		
		h.deletePrefix("un");
		
		assertTrue(h.search("cop"));
		
				
	}

}
