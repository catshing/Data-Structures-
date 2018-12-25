public class GraphMaps {

	public static void addEdges(WeightedGraph<Intersection> g, Intersection i1, Intersection i2, int weight) {
		g.addEdge(i1, i2, weight);
		g.addEdge(i2, i1, weight);
	}
	
	public static  void  addAllVertices(WeightedGraph g, Object[] vertices) {
		for (int i =0; i<vertices.length; i++) {
			g.addVertex(vertices[i]);
		}
	}
	
	public static Intersection[] createKansasGraph(WeightedGraph<Intersection> graph) {
		Intersection i1_1 = new Intersection(new String[]{"Hudson", "Kimball", "113"});
		Intersection i1_2 = new Intersection(new String[]{"Hudson", "Dickens"});
		Intersection i1_3 = new Intersection(new String[]{"Hudson", "Claflin"});

		Intersection i2_1 = new Intersection(new String[]{"113", "Seth Child"});
		Intersection i2_2 = new Intersection(new String[]{"113", "Kimball"});
		Intersection i2_3 = new Intersection(new String[]{"113", "Dickens"});
		Intersection i2_4 = new Intersection(new String[]{"113", "Claflin"});

		Intersection i3_1 = new Intersection(new String[]{"Seth Child", "Kimball"});
		Intersection i3_2 = new Intersection(new String[]{"Seth Child", "Dickens"});
		Intersection i3_3 = new Intersection(new String[]{"Seth Child", "Claflin"});

		Intersection i4_1 = new Intersection(new String[]{"Browning", "113"});
		Intersection i4_2 = new Intersection(new String[]{"Browning", "Kimball"});
		Intersection i4_3 = new Intersection(new String[]{"Browning", "Dickens"});
		Intersection i4_4 = new Intersection(new String[]{"Browning", "Claflin"});

		Intersection i5_1 = new Intersection(new String[]{"College"});
		Intersection i5_2 = new Intersection(new String[]{"College", "Kimball"});
		Intersection i5_3 = new Intersection(new String[]{"College", "Dickens"});
		Intersection i5_4 = new Intersection(new String[]{"College", "Claflin"});

		Intersection i6_1 = new Intersection(new String[]{"Denison"});
		Intersection i6_2 = new Intersection(new String[]{"Denison", "Kimball"});
		Intersection i6_3 = new Intersection(new String[]{"Denison", "Claflin"});

		Intersection i7_1 = new Intersection(new String[]{"Manhattan", "Kimball"});
		Intersection i7_2 = new Intersection(new String[]{"Manhattan", "Claflin"});

		Intersection[] vertices = {i1_1, i1_2, i1_3, i2_1, i2_2, i2_3, i2_4, i3_1, i3_2, i3_3, i4_1, i4_2, i4_3, i4_4, i5_1, i5_2, i5_3, i5_4, i6_1, i6_2, i6_3, i7_1, i7_2
};
		addAllVertices(graph, vertices);
		
		// VERTICAL
		// Hudson
		addEdges(graph, i1_1, i1_2, 1);
		addEdges(graph, i1_2, i1_3, 1);
		
		// 113
		addEdges(graph, i4_1, i2_1, 1);
		addEdges(graph, i2_1, i1_1, 1);
		addEdges(graph, i1_1, i2_2, 1);
		addEdges(graph, i2_2, i2_3, 1);
		addEdges(graph, i2_3, i2_4, 1);

		// Seth Child
		addEdges(graph, i3_1, i3_2, 1);
		addEdges(graph, i3_2, i3_3, 1);

		// Browning
		addEdges(graph, i4_2, i4_3, 1);
		addEdges(graph, i4_3, i4_4, 1);
		
		// College
		addEdges(graph, i5_1, i5_2, 1);
		addEdges(graph, i5_2, i5_3, 1);
		addEdges(graph, i5_3, i5_4, 1);
		
		// Denison
		addEdges(graph, i6_1, i6_2, 1);
		addEdges(graph, i6_2, i6_3, 1);
		
		// Manhattan
		addEdges(graph, i7_1, i7_2, 1);
		
		// HORIZONTAL
		// Kimball
		addEdges(graph, i1_1, i2_2, 1);
		addEdges(graph, i2_2, i3_1, 1);
		addEdges(graph, i3_1, i4_2, 1);
		addEdges(graph, i4_2, i5_2, 1);
		addEdges(graph, i5_2, i6_2, 1);
		addEdges(graph, i6_2, i7_1, 1);

		// Dickens
		addEdges(graph, i1_2, i2_3, 1);
		addEdges(graph, i2_3, i3_2, 1);
		addEdges(graph, i3_2, i4_3, 1);
		addEdges(graph, i4_3, i5_3, 1);
		
		// Claflin
		addEdges(graph, i1_3, i2_4, 1);
		addEdges(graph, i2_4, i3_3, 1);
		addEdges(graph, i3_3, i4_4, 1);
		addEdges(graph, i4_4, i5_4, 1);
		addEdges(graph, i5_4, i6_3, 1);
		addEdges(graph, i6_3, i7_2, 1);
		
		return vertices;
	}
	
	public static Intersection[] createManhattanGraph(WeightedGraph<Intersection> graph) {
		Intersection i1_1 = new Intersection(new String[]{"Spring", "Canal"});
		Intersection i1_2 = new Intersection(new String[]{"Spring", "Washington"});
		Intersection i1_3 = new Intersection(new String[]{"Spring", "Greenwich"});
		Intersection i1_4 = new Intersection(new String[]{"Spring", "Renwick"});
		Intersection i1_5 = new Intersection(new String[]{"Spring", "Hudson"});
		Intersection i1_6 = new Intersection(new String[]{"Spring", "Varick"});
		Intersection i1_7 = new Intersection(new String[]{"Spring", "6th1"});
		Intersection i1_8 = new Intersection(new String[]{"Spring", "6th"});
		Intersection i1_9 = new Intersection(new String[]{"Spring", "Sullivan"});
		Intersection i1_10 = new Intersection(new String[]{"Spring", "Thompson"});

		Intersection i2_1 = new Intersection(new String[]{"Canal", "Washington"});
		Intersection i2_2 = new Intersection(new String[]{"Canal", "Greenwich"});
		Intersection i2_3 = new Intersection(new String[]{"Canal", "Renwick"});
		Intersection i2_4 = new Intersection(new String[]{"Canal", "Hudson"});
		Intersection i2_5 = new Intersection(new String[]{"Canal", "Varick"});
		Intersection i2_7 = new Intersection(new String[]{"Canal", "6th"});
		Intersection i2_8 = new Intersection(new String[]{"Canal", "Thompson"});
		Intersection i2_9 = new Intersection(new String[]{"Canal", "Sullivan"});

		Intersection i3_1 = new Intersection(new String[]{"Dominick", "Hudson"});
		Intersection i3_2 = new Intersection(new String[]{"Dominick", "Varick"});
		Intersection i3_3 = new Intersection(new String[]{"Dominick", "6th1"});
		Intersection i3_4 = new Intersection(new String[]{"Dominick", "6th"});
		
		Intersection i4_1 = new Intersection(new String[]{"Broome", "Varick"});
		Intersection i4_2 = new Intersection(new String[]{"Broome", "6th"});
		Intersection i4_3 = new Intersection(new String[]{"Broome", "Thompson"});

		Intersection i5_1 = new Intersection(new String[]{"Watts", "Hudson"});
		Intersection i5_2 = new Intersection(new String[]{"Watts", "Varick"});
		Intersection i5_3 = new Intersection(new String[]{"Watts", "6th"});
		Intersection i5_4 = new Intersection(new String[]{"Watts", "Thompson"});
		
		Intersection i6_1 = new Intersection(new String[]{"Grand", "Varick"});
		Intersection i6_4 = new Intersection(new String[]{"Grand", "Sullivan"});;
		Intersection i6_2 = new Intersection(new String[]{"Grand", "6th"});
		Intersection i6_3 = new Intersection(new String[]{"Grand", "Thompson"});
		
		Intersection[] vertices = {i1_1, i1_2, i1_3, i1_4, i1_5, i1_6, i1_7, i1_8, i1_9, i1_10, i2_1, i2_2, i2_3, i2_4, i2_5, i2_7, i2_8, i2_9, i3_1, i3_2, i3_3, i3_4, i4_1, i4_2, i4_3, i5_1, i5_2, i5_3, i5_4, i6_1, i6_2, i6_3};
		addAllVertices(graph, vertices);

		// HORIZONTAL
		// Spring
		addEdges(graph, i1_1, i1_2, 1);
		addEdges(graph, i1_2, i1_3, 1);
		addEdges(graph, i1_3, i1_4, 1);
		addEdges(graph, i1_4, i1_5, 1);
		addEdges(graph, i1_5, i1_6, 1);
		addEdges(graph, i1_6, i1_7, 1);
		addEdges(graph, i1_7, i1_8, 1);
		addEdges(graph, i1_8, i1_9, 1);
		addEdges(graph, i1_9, i1_10, 1);
		
		// Canal
		addEdges(graph, i1_1, i2_1, 1);
		addEdges(graph, i2_1, i2_2, 1);
		addEdges(graph, i2_2, i2_3, 1);
		addEdges(graph, i2_3, i2_4, 1);
		addEdges(graph, i2_4, i2_5, 1);
		addEdges(graph, i2_5, i2_9, 1);
		addEdges(graph, i2_9, i2_7, 1);
		addEdges(graph, i2_7, i2_8, 1);

		// Dominick
		addEdges(graph, i3_1, i3_2, 1);
		addEdges(graph, i3_2, i3_3, 1);
		addEdges(graph, i3_3, i3_4, 1);

		// Broome
		addEdges(graph, i4_1, i4_2, 1);
		addEdges(graph, i4_2, i4_3, 1);

		// Watts		
		addEdges(graph, i5_1, i5_2, 1);
		addEdges(graph, i5_2, i5_3, 1);
		addEdges(graph, i5_3, i5_4, 1);

		// Grand
		addEdges(graph, i6_1, i6_2, 1);
		addEdges(graph, i6_2, i6_3, 1);
	
		// Canal and Spring
		addEdges(graph, i1_2, i2_1, 1);
		
		addEdges(graph, i1_3, i2_2, 1);
		
		addEdges(graph, i1_4, i2_3, 1);
		
		// Hudson DOWN
		addEdges(graph, i1_5, i3_1, 1);
		addEdges(graph, i3_1, i5_1, 1);
		addEdges(graph, i5_1, i2_4, 1);
		
		
		
		// Varick DOWN
		addEdges(graph, i1_6, i3_2, 1);
		addEdges(graph, i3_2, i4_1, 1);
		addEdges(graph, i4_1, i5_2, 1);
		addEdges(graph, i5_2, i2_5, 1);
		addEdges(graph, i6_2, i2_7, 1);

		// 6th Av DOWN
		addEdges(graph, i1_8, i3_4, 1);
		addEdges(graph, i3_4, i4_2, 1);
		addEdges(graph, i4_2, i5_3, 1);

		// Sullivan DOWN
		addEdges(graph, i1_9, i2_7, 1);

		addEdges(graph, i1_8, i2_7, 1);
		
		// Thompson DOWN
		addEdges(graph, i1_10,i5_4, 1);
		addEdges(graph, i5_4, i6_3, 1);
		addEdges(graph, i6_3, i2_8, 1);
		
		return vertices;
	}
}
