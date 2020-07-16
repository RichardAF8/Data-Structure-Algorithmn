
public class Main {
public static void main (String[] args) {
	
	SkipList t = new SkipList();
	
	//6 7 9 12 17 19 21 25 26
	t.insert(26);
	t.insert(6);
	t.insert(7);
	t.insert(12);
	t.insert(9);
	t.insert(17);
	t.insert(19);
	
	t.insert(21);
	t.insert(25);
	
	t.displayList();
	
	t.delete(7);
	System.out.println();
	t.displayList();
	
}
}
