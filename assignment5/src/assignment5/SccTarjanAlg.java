package assignment5;

import static java.lang.Math.min;
import java.util.*;

public class SccTarjanAlg {
	
	private static final int unvisited = -1;
	private int n; 
	private List<List<Character>> graph;

	private boolean solved;
	private int counter, id;
	private boolean[] visited;
	private int[] ids, low, sccs;
	private Deque<Integer> stack;
	
public SccTarjanAlg(List<List<Character>> graph) {
	
	 n = graph.size();
	 this.graph = graph;
}

public void solve() {
	
    if (solved) return;
    ids = new int[n];
    low = new int[n];
    sccs = new int[n];
    visited = new boolean[n];
    stack = new ArrayDeque<>();
    
    Arrays.fill(ids, unvisited);

    for (int i = 0; i < n; i++) {
      if (ids[i] == unvisited) {
        DFS(i);
      }
    }

    solved = true;
 }

  public int[] getSccs() {
    if (!solved) solve();
    return sccs;
  }
  public int counter() {
	    if (!solved) solve();
	    return counter;
	  }

  private void DFS(Integer loc) {
    ids[loc] = low[loc] = id++;
    stack.push(loc);
    visited[loc] = true;

    for (int to = 0; to < graph.get(loc).size(); to++) {
    	
      char nextChar = graph.get(loc).get(to);
      int next = nextChar - 'A'; 

      if (ids[next] == unvisited) {
        DFS(next);
      }
      if (visited[next]) {
        low[loc] = min(low[loc], low[next]);
      }
    }

  
    if (ids[loc] == low[loc]) {
      for (int node = stack.pop(); ; node = stack.pop()) {
        visited[node] = false;
        sccs[node] = counter;
        if (node == loc) break;
      }
      counter++;
    }
  }


  public static List<List<Character>> initiateGraph(int n) {
    List<List<Character>> graph = new ArrayList<>(n);
    for (int i = 0; i < n; i++) graph.add(new ArrayList<>());
    return graph;
  }


  public static void addEdge(List<List<Character>> graph, char from, char to) {
    graph.get(from - 'A').add(to);
  }

}
