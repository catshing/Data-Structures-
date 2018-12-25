
public class PosNode<T> {
	
	int position;
	BSTNode<T> node;
	char child; 	// L or R
	
	public PosNode(BSTNode<T> n, int p) {
		this.node = n;
		this.position = p;
	}

	public PosNode(BSTNode<T> n, int p, char c) {
		this.node = n;
		this.position = p;
		switch(c) {
		case 'L':
			this.child = '/';
		case 'R':
			this.child = '\\';
		}
	}
}
