
public class DoubleLinkedQueue<T> implements QueueInterface<T> {
	
	  protected DLLNode<T> front;     // reference to the front of this queue
	  protected DLLNode<T> rear;      // reference to the rear of this queue
	  protected int numElements = 0; // number of elements in this queue
      
	  public DoubleLinkedQueue()
	  {
	    front = null;
	    rear = null;
	  }

	  public void enqueue(T element)
	  // Adds element to the rear of this queue.
	  { 
	    DLLNode<T> newNode = new DLLNode<T>(element);
	    if (rear == null){
	      front = newNode;
	    }
	    else {
	    	rear.setBack(newNode);
	    	newNode.setForward(rear);
	    }
	    rear = newNode;
	    numElements++;
	  }     

	  public T dequeue()
	  // Throws QueueUnderflowException if this queue is empty;
	  // otherwise, removes front element from this queue and returns it.
	  {
	    if (isEmpty())
	      throw new QueueUnderflowException("Dequeue attempted on empty queue.");
	    else
	    {
	      T element;
	      element = front.getInfo();
	      front = front.getBack();
	      front.setForward(null);
	      if (front == null)
	        rear = null;
	      numElements--;
	      return element;
	    }
	  }
	  public T dequeue(T inputinfo)
	  // Throws QueueUnderflowException if this queue is empty;
	  // otherwise, removes front element from this queue and returns it.
	  {
		  
		  DLLNode currentNode = this.front;
		  while(currentNode != null) {
		      if (currentNode.getInfo().equals(inputinfo) ) {
		    	  if (currentNode.getBack() != null ){
		    	  currentNode.getBack().setForward(currentNode.getForward());
		    	  } else {
		    		  rear = currentNode.getForward();
		    	  }
		    	  if (currentNode.getForward() != null ){
		    	  currentNode.getForward().setBack(currentNode.getBack());
		    	  } else {
		    		  front = currentNode.getBack();
		    	  }
		    	  return (T) currentNode.getInfo();
		      }
		      if (currentNode.getBack() == null) {
		    	  break;
		      }
		      else {
			      currentNode = currentNode.getBack();
		      }
		  }
		  return null;
		 
	  }

	  public boolean isEmpty()
	  // Returns true if this queue is empty; otherwise, returns false.
	  {              
	    return (front == null);
	  }
	  
	  public boolean isFull()
	  // Returns false - a linked queue is never full.
	  {              
	    return false;
	  }

	  public int size()
	  // Returns the number of elements in this queue.
	  {
	    return numElements;
	  }
	  
	  public void print() {
		  DLLNode currentNode = this.front;
		  while(currentNode != null) {
		      System.out.println(currentNode.info+ "  Wait: " + currentNode.waittime);
		      if (currentNode.getBack() == null) {
		    	  break;
		      }
		      else {
			      currentNode = currentNode.getBack();
		      }
		  }
	  }
	  public void increment_wait(int intime) {
		  DLLNode currentNode = this.front;
		  while(currentNode != null) {
			   currentNode.waittime+= intime;
		      if (currentNode.getBack() == null) {
		    	  break;
		      }
		      else {
			      currentNode = currentNode.getBack();
		      }
		  }
	  }
	  public double getAverageWait() {
		  int totalwait=0;
		  DLLNode currentNode = this.front;
		  while(currentNode != null) {
			   totalwait += currentNode.waittime ;
		      if (currentNode.getBack() == null) {
		    	  break;
		      }
		      else {
			      currentNode = currentNode.getBack();
		      }
		  }
		  return (double) totalwait/this.numElements ;
	  }


}
