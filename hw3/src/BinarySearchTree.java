//---------------------------------------------------------------------------
// BinarySearchTree.java          by Dale/Joyce/Weems               Chapter 7
//
// Defines all constructs for a reference-based BST.
// Supports three traversal orders Preorder, Postorder & Inorder ("natural")
//---------------------------------------------------------------------------

 

import java.util.*;   // Iterator, Comparator

      

public class BinarySearchTree<T> {
  protected BSTNode<T> root;
  protected Comparator<T> comp;

  protected boolean found;   // used by remove

  // Precondition: T implements Comparable
  // Creates an empty BST object - uses the natural order of elements.
  public BinarySearchTree() {
    root = null;
    comp = new Comparator<T>() {
       public int compare(T element1, T element2)
       {
         return ((Comparable<T>)element1).compareTo(element2);
       }
    };
  }

  // Creates an empty BST object - uses Comparator comp for order
  // of elements.
  public BinarySearchTree(Comparator<T> comp) {
    root = null;
    this.comp = comp;
  }

  // Returns false; this link-based BST is never full.
  public boolean isFull() {
    return false;
  }

  // Returns true if this BST is empty; otherwise, returns false.

  public boolean isEmpty() {
    return root == null;
  }

  // If this BST is empty, returns null;
  // otherwise returns the smallest element of the tree.
  public T min() {
    if (isEmpty())
       return null;
    else {
       BSTNode<T> node = root;
       while (node.getLeft() != null)
         node = node.getLeft();
       return node.getInfo();
    }
  }

  // If this BST is empty, returns null;
  // otherwise returns the largest element of the tree.
  public T max() {
    if (isEmpty())
       return null;
    else {
       BSTNode<T> node = root;
       while (node.getRight() != null)
         node = node.getRight();
       return node.getInfo();
    }
  }
  
  // Returns the number of elements in subtree rooted at node.
  public int recSize(BSTNode<T> node) {
    if (node == null)    
      return 0;
    else
      return 1 + recSize(node.getLeft()) + recSize(node.getRight());
  }

  // Returns the number of elements in this BST.
  public int size() {
    return recSize(root);
  }

  // Returns the number of elements in this BST.
  public int size2() throws Exception {
    int count = 0;
    if (root != null)
    {
      LinkedStack<BSTNode<T>> nodeStack = new LinkedStack<BSTNode<T>>();
      BSTNode<T> currNode;
      nodeStack.push(root);
      while (!nodeStack.isEmpty()) {
        currNode = nodeStack.top();
        nodeStack.pop();
        count++;
        if (currNode.getLeft() != null)
          nodeStack.push(currNode.getLeft());
        if (currNode.getRight() != null)
          nodeStack.push(currNode.getRight());
      }
    }
    return count;
  }

  // Returns true if the subtree rooted at node contains info i such that 
  // comp.compare(target, i) == 0; otherwise, returns false.
  public boolean recContains(T target, BSTNode<T> node) {
    if (node == null)
      return false;       // target is not found
    else if (comp.compare(target, node.getInfo()) < 0)
      return recContains(target, node.getLeft());   // Search left subtree
    else if (comp.compare(target, node.getInfo()) > 0)
      return recContains(target, node.getRight());  // Search right subtree
    else
      return true;        // target is found
  }

  // Returns true if this BST contains a node with info i such that 
  // comp.compare(target, i) == 0; otherwise, returns false.
  public boolean contains (T target) {
    return recContains(target, root);
  }

  // Returns info i from the subtree rooted at node such that 
  // comp.compare(target, i) == 0; if no such info exists, returns null.
  public T recGet(T target, BSTNode<T> node) {
    if (node == null)
      return null;             // target is not found
    else if (comp.compare(target, node.getInfo()) < 0)
      return recGet(target, node.getLeft());         // get from left subtree
    else
    if (comp.compare(target, node.getInfo()) > 0)
      return recGet(target, node.getRight());        // get from right subtree
    else
      return node.getInfo();  // target is found
  }

  // Returns info i from node of this BST where comp.compare(target, i) == 0;
  // if no such node exists, returns null.
  public T get(T target) {
    return recGet(target, root);
  }

  // Adds element to tree rooted at node; tree retains its BST property.
  public BSTNode<T> recAdd(T element, BSTNode<T> node) {
    if (node == null)
      // Addition place found
      node = new BSTNode<T>(element);
    else if (comp.compare(element, node.getInfo()) <= 0)
      node.setLeft(recAdd(element, node.getLeft()));    // Add in left subtree
    else
      node.setRight(recAdd(element, node.getRight()));   // Add in right subtree
    return node;
  }
  
  // Adds element to this BST. The tree retains its BST property.
  public boolean add (T element) {
    root = recAdd(element, root);
    return true;
  }

  // Returns the information held in the rightmost node of subtree
  public T getPredecessor(BSTNode<T> subtree) {
    BSTNode<T> temp = subtree;
    while (temp.getRight() != null)
      temp = temp.getRight();
    return temp.getInfo();
  }

  // Removes the information at node from the tree. 
  public BSTNode<T> removeNode(BSTNode<T> node) {
    T data;
    if (node.getLeft() == null)
      return node.getRight();
    else if (node.getRight() == null) 
      return node.getLeft();
    else
    {
      data = getPredecessor(node.getLeft());
      node.setInfo(data);
      node.setLeft(recRemove(data, node.getLeft()));  
      return node;
    }
  }

  // Removes element with info i from tree rooted at node such that
  // comp.compare(target, i) == 0 and returns true; 
  // if no such node exists, returns false. 
  public  BSTNode<T> recRemove(T target, BSTNode<T> node) {
    if (node == null)
      this.found = false;
    else if (comp.compare(target, node.getInfo()) < 0)
      node.setLeft(recRemove(target, node.getLeft()));
    else if (comp.compare(target, node.getInfo()) > 0)
      node.setRight(recRemove(target, node.getRight()));
    else   {
      node = removeNode(node);
      this.found = true;
    }
    return node;
  }

  // Removes a node with info i from tree such that comp.compare(target,i) == 0
  // and returns true; if no such node exists, returns false.
  public boolean remove (T target) {
    root = recRemove(target, root);
    return this.found;
  }

  // Enqueues the elements from the subtree rooted at node into q in preOrder.
  public void preOrder(BSTNode<T> node, LinkedQueue<T> q) {
    if (node != null) {
      q.enqueue(node.getInfo());
      preOrder(node.getLeft(), q);
      preOrder(node.getRight(), q);
    }
  }

  // Enqueues the elements from the subtree rooted at node into q in inOrder.  

  public void inOrder(BSTNode<T> node, LinkedQueue<T> q) {
    if (node != null) {
      inOrder(node.getLeft(), q);
      q.enqueue(node.getInfo());
      inOrder(node.getRight(), q);
    }
  }

  public void postOrder(BSTNode<T> node, LinkedQueue<T> q)
  // Enqueues the elements from the subtree rooted at node into q in postOrder.  
  {
    if (node != null) {
      postOrder(node.getLeft(), q);
      postOrder(node.getRight(), q);
      q.enqueue(node.getInfo());
    }
  }
  
  ArrayList<ArrayList<PosNode>> levels = new ArrayList<>();
  int r_shift;
  
  // Enqueues the elements from the subtree rooted at node into q in postOrder. 
  public void printTree() {
	  r_shift = 0;
	  parsePrintTree(this.root, 0, 0, ' ');
	  StringBuilder string_builder;
	  
	  for (ArrayList<PosNode> pos_nodes : levels) {
		  int i = 0;
		  string_builder = new StringBuilder();
		  for (PosNode pos_node : pos_nodes) {
			  for (; i<pos_node.position; ++i) {
				  string_builder.append(' ');
			  }
			  string_builder.append(pos_node.node.getInfo());
		  }
		  System.out.println(string_builder.toString());
	  }
	  
  }

  public int parsePrintTree(BSTNode<T> node, int pos, int level, char dir) {
	  if (node == null) {
		  return pos;
	  }
	  
	  if (dir == 'L')
		  r_shift -= 1;
	  else if (dir == 'R')
		  r_shift += 1;
	  
	  if (level >= levels.size()) {
		  levels.add(new ArrayList<PosNode>());
	  }
	  
	  int cur_pos;
		  
	  cur_pos = parsePrintTree(node.getLeft(), pos, level+1, 'L');		// LEFT
	  
	  PosNode<T> thisPos = new PosNode<T>(node, cur_pos);	  
	  levels.get(level).add(thisPos);
	  
	  if (r_shift < 0 || level == 0)		// 0 means left side of tree overlaps right
		  parsePrintTree(node.getRight(), cur_pos + 2, level+1, 'R');
	  else {
		  if (dir == 'R') {
			  parsePrintTree(node.getRight(), cur_pos + 2, level+1, 'R');
		  } else {
			  parsePrintTree(node.getRight(), cur_pos + 2 + r_shift*2, level+1, 'R');
		  }
	  }
	  
	  return cur_pos + 2;	// levels above right by two
  }
}