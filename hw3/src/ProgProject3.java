
public class ProgProject3 {
	public static void main(String[] args) {
		
		String [][] array_inputs = new String [100][100];
		//System.out.println(array_inputs);
		
		String[] inputs = {
				"DBACGHJK",
				"DACBEFMLGHJK",
				"JABCDEFISRQPON" 
		};
		
//		String[] inputs = {
//				"IHGFEDCBA",
//				"BAC",
//				"IHGJK"
//		};
		
		for (int k=0; k<inputs.length;k++) {
		BinarySearchTree<Visitor> mytree = new BinarySearchTree<Visitor>();
		for (int i=0 ; i< inputs[k].length(); i++) {
			Visitor v = new Visitor("C");
			v.vname = inputs[k].substring(i, i+1);
			mytree.add(v);
		}
		System.out.println("\n\n");
		System.out.println("Tree for input: " + inputs[k]);
		mytree.printTree();
		}
		
	}
	 
}
