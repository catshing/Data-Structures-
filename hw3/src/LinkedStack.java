//----------------------------------------------------------------------
// LinkedStack.java         by Dale/Joyce/Weems                Chapter 2
//
// Implements StackInterface using a linked list to hold the elements.
//-----------------------------------------------------------------------

public class LinkedStack<T> {
  protected LLNode<T> top;   // reference to the top of this stack

  public LinkedStack() {
    top = null;
  }

  // Places element at the top of this stack.
  public void push(T element) { 
    LLNode<T> newNode = new LLNode<T>(element);
    newNode.setLink(top);
    top = newNode;
  }     

  // Throws StackUnderflowException if this stack is empty,
  // otherwise removes top element from this stack.
  public void pop() throws Exception {                  
    if (isEmpty())
      throw new  Exception("Pop attempted on an empty stack.");
    else
      top = top.getLink();
  }

  public T top() throws Exception
  // Throws StackUnderflowException if this stack is empty,
  // otherwise returns top element of this stack.
  {                 
    if (isEmpty())
      throw new  Exception("Top attempted on an empty stack.");
    else
      return top.getInfo();
  }

  // Returns true if this stack is empty, otherwise returns false.
  public boolean isEmpty() {              
    return (top == null); 
  }

  // Returns false - a linked stack is never full
  public boolean isFull() {              
      return false;
  }

}

