
public class Main {

	public static void main(String[] args) {
		AVLT tree = new AVLT();

		/*tree.insert(50);
		tree.insert(30);
		tree.insert(19); // re-balanced after this insertion (LeftLeftImblance)

		tree.insert(17);
		tree.insert(11);
		tree.insert(62);
		
		// re-balanced after this insertion (LeftRightImbalance)
	tree.insert(77);
		tree.insert(70);
		tree.insert(68); // re-balanced after this insertion (LeftLeftImblance)

		tree.insert(5);
		tree.insert(20);
		tree.insert(23);*/
		
		tree.insert(100);
		tree.insert(50);
		tree.insert(150);
		tree.insert(125);
		tree.insert(200);
		tree.insert(110);
		
		System.out.println(tree.toString());

	}
}
