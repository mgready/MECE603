package assignment5;

import java.util.*;

public class Main  {
	
	public static void main(String[] args) {
		
		int n = 10;
		List<List<Character>> graph = SccTarjanAlg.initiateGraph(n);
		SccTarjanAlg.addEdge(graph, 'A', 'B');
		SccTarjanAlg.addEdge(graph, 'B', 'C');
		SccTarjanAlg.addEdge(graph, 'C', 'A');
		SccTarjanAlg.addEdge(graph, 'B', 'D');
		SccTarjanAlg.addEdge(graph, 'D', 'E');
		SccTarjanAlg.addEdge(graph, 'E', 'F');
		SccTarjanAlg.addEdge(graph, 'F', 'E');
		SccTarjanAlg.addEdge(graph, 'G', 'E');
		SccTarjanAlg.addEdge(graph, 'H', 'F');
		SccTarjanAlg.addEdge(graph, 'G', 'H');
		SccTarjanAlg.addEdge(graph, 'H', 'I');
		SccTarjanAlg.addEdge(graph, 'J', 'G');
		SccTarjanAlg.addEdge(graph, 'J', 'H');
		SccTarjanAlg.addEdge(graph, 'I', 'J');
		
		SccTarjanAlg  solver = new SccTarjanAlg(graph);
		
		int[] sccs = solver.getSccs();
		
		 Map<Integer, List<Character>> multimap = new HashMap<>();
		    for (int i = 0; i < n; i++) {
		      if (!multimap.containsKey(sccs[i])) multimap.put(sccs[i], new ArrayList<>());
		      multimap.get(sccs[i]).add((char)('A' + i));
		    }
		    
		    
		    System.out.printf("Number SCC: %d\n", solver.counter());
		    for (List<Character> scc : multimap.values()) {
		      System.out.println("Nodes: " + scc + " SCC");
		    }		
	}
}