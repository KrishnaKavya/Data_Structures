import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

/**
 * @author M Krishna Kavya
 * 
 *         Depth-first search (DFS) is an algorithm for traversing or searching
 *         tree or graph data structures. One starts at the root (selecting some
 *         arbitrary node as the root in the case of a graph) and explores as
 *         far as possible along each branch before backtracking.
 * 
 *         classes: Graph,Vertex,Edge.
 * 
 */
public class DepthFirstSearch {

	/**
	 * The method depth First Search searches or parse through the start node of
	 * the graph. The Data structures used are stack and a Hashset to keep track
	 * of the vertices visited. for all the vertices in the graph, we check if
	 * the vertex is already processed (the vertices already visited are
	 * considered as processed). if true, the dfs is continued, else the dfsUtil
	 * is called to process the vertex.
	 * 
	 * 
	 * @param graphObject
	 */
	public void depthFirstSearch(Graph graphObject) {
		Deque<Vertex> stack = new ArrayDeque<Vertex>();
		Set<Vertex> visited = new HashSet<Vertex>();
		List<Vertex> vertices = graphObject.verts;
		for (int i = 1; i < vertices.size(); i++) {
			Vertex current = vertices.get(i);
			if (visited.contains(current)) {
				continue;
			} else {
				dfsUtil(current, stack, visited);
			}
		}
	}

	/**
	 * This method processes the dfs of the vertex in in the paramenter. The
	 * stack has the current processing vertices and visited has the vertices
	 * already processed.
	 * 
	 * we push the first vertex(start) into the stack.
	 * 
	 * while stack is not empty, we pop the element from the stack. mark it as
	 * visited and display in the output list.
	 * 
	 * Fetch all the adjacent vertices of the current vertex for all the
	 * adjacent vertices. check if the element is present in the visited elist
	 * if yes continue with the loop else process that vertex by recursively
	 * calling dfsUtil.
	 * 
	 * @param current
	 * @param stack
	 * @param visited
	 */
	public void dfsUtil(Vertex current, Deque<Vertex> stack, Set<Vertex> visited) {
		current.seen = true;
		visited.add(current);
		stack.push(current);

		while (!stack.isEmpty()) {
			// Fetch the top vertex from the stack.
			Vertex v = stack.pop();
			// adding to the output
			System.out.println("Vertex Name: " + v.name + " Vertex Parent: "
					+ v.parent);
			List<Edge> edge = v.Adj;
			for (Edge e : edge) {
				Vertex otherEnd = e.otherEnd(v);
				if (visited.contains(otherEnd)) {
					continue;
				} else {
					otherEnd.parent = v;
					dfsUtil(otherEnd, stack, visited);
				}
			}
		}
	}

	/**
	 * @param args
	 * @throws FileNotFoundException
	 */
	public static void main(String[] args) throws FileNotFoundException {

		DepthFirstSearch dfs = new DepthFirstSearch();
		File input = args.length > 0 ? new File(args[0]) : null;
		Scanner sc = null;
		if (input != null && input.exists()) {
			sc = new Scanner(input);
		} else {
			System.out
					.println("Please enter dimensions of graph (#nodes,#edges) followed by edge followed by edges in format(left,right,weight)");
			sc = new Scanner(System.in);
		}
		// true- represents a directed graph.
		
		
		Graph graph = Graph.readGraph(sc, true);

		dfs.depthFirstSearch(graph);
		
	}

}
