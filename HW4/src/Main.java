import java.util.Scanner;


public class Main {
	
	public static Intersection findIntersection(Intersection[] ins, String s) {
		for (Intersection in: ins) {
			if (in.equals(s))
				return  in;
		}
		return null;
	}
	
	@SuppressWarnings("resource")
	public static void main(String[] args) {
		WeightedGraph<Intersection> mygraph1 = new WeightedGraph<Intersection>();
		WeightedGraph<Intersection> mygraph2 = new WeightedGraph<Intersection>();
		WeightedGraph<Intersection> graph;
		
		Intersection[] kansas = GraphMaps.createKansasGraph(mygraph1);
		Intersection[] manhattan = GraphMaps.createManhattanGraph(mygraph2);
		Intersection[] vertices;
		
		String city;
		
//		System.out.println(mygraph.edgeExists(i[0], i[1]));
//		System.out.println(mygraph.edgeExists(i[1], i[0]));
//		System.out.println(mygraph.edgeExists(i[10], i[3]));	
//		System.out.println(mygraph.edgeExists(i[3], i[10]));	
//
//		System.out.println(mygraph.hasVertex(i[15])); 
//		System.out.println(mygraph.weightIs(i[10], i[3])); 

		String start_string = "Hudson,Kimball,113";
		String end_string = "Claflin,Denison";
		Intersection start=null, end=null;
		
		start = findIntersection(kansas, start_string);
		end = findIntersection(kansas, end_string);
		
		int shortest_dist = UseGraph.shortestPaths(mygraph1, start, end);
		System.out.println("Shortest Distance from " + start_string + " to " + end_string + ": " + shortest_dist);
		
		start_string = "College";
		end_string = "Claflin,Manhattan";
		
		start = findIntersection(kansas, start_string);
		end = findIntersection(kansas, end_string);
		
		shortest_dist = UseGraph.shortestPaths(mygraph1, start, end);
		
		System.out.println("Shortest Distance from " + start_string + " to " + end_string + ": " + shortest_dist);

		start_string = "Canal,Spring";
		end_string = "Spring,Thompson";
		
		start = findIntersection(manhattan, start_string);
		end = findIntersection(manhattan, end_string);
		
		shortest_dist = UseGraph.shortestPaths(mygraph2, start, end);
		
		System.out.println("Shortest Distance from " + start_string + " to " + end_string + ": " + shortest_dist);
		
		System.out.println("Type quit to stop");
		do {
			System.out.print("Kansas or Manhattan? : ");
			Scanner input = new Scanner(System.in);
			city = input.nextLine().toLowerCase();
			
			if (city.equals("quit"))
				break;
		
			
			graph = (city.equals("kansas")) ? mygraph1 : mygraph2;
			vertices = (city.equals("kansas")) ? kansas : manhattan;
	
			System.out.println("\nEnter Start Intersection (, seperated): ");
			input = new Scanner(System.in);
			String intersection1 = input.nextLine().toLowerCase();
			
			System.out.println("\nEnter End Intersection (, seperated): ");
			input = new Scanner(System.in);
			String intersection2 = input.nextLine().toLowerCase();

		
			start = findIntersection(vertices, intersection1);
			end = findIntersection(vertices, intersection2);
			
			shortest_dist = UseGraph.shortestPaths(graph, start, end);
			System.out.println("Shortest Distance from " + intersection1 + " to " + intersection2 + ": " + shortest_dist);
			System.out.println();
		
		} while(true);

	}

}


