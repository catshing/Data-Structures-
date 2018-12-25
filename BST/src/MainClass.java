


// using the binary search tree, have a method that returns the number of leave nodes there are 
//
public class MainClass {
	public static void main(String[] args) {
		BinarySearchTree<Visitor> mytree = new BinarySearchTree<Visitor>();
		Visitor v = new Visitor("Q");
		mytree.add(v);
		v = new Visitor("K");
		mytree.add(v);
		v = new Visitor("D");
		mytree.add(v);
		v = new Visitor("B");
		mytree.add(v);
		v = new Visitor("J");
		mytree.add(v);
		v = new Visitor("M");
		mytree.add(v);
		v = new Visitor("P");
		mytree.add(v);
		v = new Visitor("N");
		mytree.add(v);
		v = new Visitor("T");
		mytree.add(v);
		v = new Visitor("R");
		mytree.add(v);
		v = new Visitor("Y");
		mytree.add(v);
		v = new Visitor("W");
		mytree.add(v);
		System.out.println(mytree.count(mytree.root));
		BSTNode mynode;
	    LinkedQueue<Visitor> myq = new LinkedQueue<Visitor>();
	    mytree.preOrder(mytree.root, myq);
	    printqueue(myq);
	    myq = new LinkedQueue<Visitor>();
	    mytree.inOrder(mytree.root, myq);
	    printqueue(myq);
	    myq = new LinkedQueue<Visitor>();
	    mytree.postOrder(mytree.root, myq);
	    printqueue(myq);
	    
	}
	public static void printqueue(LinkedQueue inqueue) {
		 LLNode mynode = inqueue.front;
		 while (mynode != null)  {
			 System.out.print(  ((Visitor) mynode.getInfo()).vname  + " ");
			 mynode = mynode.getLink();
		 }
		 System.out.println();
		
	}
	
	 
}
