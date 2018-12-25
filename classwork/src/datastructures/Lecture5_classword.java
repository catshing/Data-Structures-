package datastructures;


		//Do question 1, 3, 4
		
		// Question 1
		/*  1. binarySearch(32, 0 ,15) -> binarySearch (32, 8 ,15) -> binarySearch ( 32, 8, 10) value 32 is found in the midpoint 
		 * 
		 * 2. binarySearch(21, 0 , 15) -> binarySearch ( 21, 0 ,6 ) -> binarySearch (21, 4, 6) -> binarySearch (21, 6, 6) value 21 is found 
		 * 
		 * 3. binarySearch(42, 0, 15) -> binarySearch (42, 8 ,15) -> binarySearch (42, 8 , 10) -> binarySearch( 42, 10, 10) value 42 is not found
		 * 
		 * 4. binarySearch (70, 0, 15) -> binarySearch (70, 8 ,15) -> binarySearch (70, 12, 15) -> binarySearch(70, 14,15) -> binarySearch ( 70, 15, 15) value 70 is not found 

		 */
/*
 * 

*/
	/* 3. 
	public boolean numFound(LLNode<Integer> list, int value) { 
		
	if (list==null) 
			return false;
	
	if (list.data == value) 
		return true;
	
	return numFound(list.next, value);

}

*/
	//4 
/*
	import java.util.Scanner;


	public class Lecture5_classword {

	    public static boolean checkPali(String input)
	    
	    {   // if the length of the input is 0 or 1, then it is a palidrome 
	        if(input.length() == 0 || input.length() == 1)
	            return true; 
	        
	        if(input.charAt(0) == input.charAt(input.length()-1))
	        	
	            return checkPali(input.substring(1, input.length()-1));
	        
	        return false;
	    }

	    public static void main(String[]args)
	    {
	        Scanner input1 = new Scanner(System.in);
	        
	        System.out.println("Please enter any word to check ");
	        String inputstring = input1.nextLine();
	        
	        if(checkPali(inputstring))
	        	
	            System.out.println(inputstring + " is a palindrome");
	        else
	        	
	            System.out.println(inputstring + " is not a palindrome");
	    }
	    
	}
	
	*/
	/*
  // Question 2
	public static int numOdds( LLNode<Integer> list, int firstPos, int lastPos ) { 
		int count  = 0;
		if ( firstPos <= lastPos) { 
			count+=numOdds(a, firstPos + 1, lastPos);
			if (a[firstPos] % 2!=0) { 
				count++;
			}
		
	}
		return count;
	}
	
	public static void main(String[] args) {
		int[] values = {4,5,7,9,9,11,12,13};
		int n = numOdds(values, 0,7);
		System.out.println(n);
		
	}
	*/
	
	
