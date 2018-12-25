import java.util.ArrayList;
import java.util.Random;

public class MainMethod_Visit {
	static Random r = new Random(6);
	public static ArrayList<String> interest;
	public static int visitors  =1;
	static DoubleLinkedQueue<Visitor> queue = new DoubleLinkedQueue<Visitor>();
	public static void main(String[] args) {	
		// Randomized interest
		interest = new ArrayList<String>();
		interest.add("CAS");
		interest.add("Stern");
		interest.add("Grad");
		
		for (int i=0; i<10; i++) {
			queue.enqueue(gen_Visitor());
		}
		queue.print();
		//Simulation
		final int Persons_on_Tour = 3;
		double totalwait =0;
		int num_guides =1;
		Visitor firstvisitor, nextvisitor;
		for (int i = 1; i<=10; i++){
			for (int k=1; k<= num_guides; k++) {
			firstvisitor= (Visitor) queue.dequeue();
			System.out.println( "Tour for: " + firstvisitor.interest);
			System.out.println( firstvisitor.toString());
			for (int j = 1; j<= Persons_on_Tour-1; j++) {
			 nextvisitor=queue.dequeue(firstvisitor);
			 if (nextvisitor == null) {
				 System.out.println("short tour");
			 } else {
			 System.out.println( nextvisitor.toString());
			 }
			}
			}
			queue.increment_wait(1);
			int newVisitors = r.nextInt(3)+1;
			for (int j = 1; j<= newVisitors; j++) {
				queue.enqueue(gen_Visitor());
			}
			System.out.println( "Guides: " + num_guides + "  Visitors:  " + newVisitors);
			queue.print();
			double cycle_avg_weight = queue.getAverageWait() ;
			System.out.println("average wait for this cycle: " + cycle_avg_weight  );
		    totalwait+= cycle_avg_weight;
		}
		System.out.println("average wait over 100 cycles: " + totalwait/10   );
	}
	
	public static Visitor gen_Visitor() { 
		int random_num1 = r.nextInt(3);
		String temp_name = "P" + Integer.toString(visitors );
		visitors++;
		String temp_school = interest.get(random_num1);
		return new Visitor(temp_name,temp_school);
	}

}
