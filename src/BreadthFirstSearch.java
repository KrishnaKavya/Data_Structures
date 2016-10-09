import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;
import java.util.Scanner;

/**
 * @author M Krishna Kavya
 * 
 *         Breadth first search is a traversal or searching algorithm for a tree
 *         or graph data structure. It starts at the root and traverses through
 *         its child nodes. BFS traverses through one level of nodes in a graph
 *         or a tree.
 * 
 */
public class BreadthFirstSearch {

	public List<Vertex> breadthFirstSearch(Graph graphObject) {
		List<Vertex> vertices = graphObject.verts;
		Deque<Vertex> queue = new ArrayDeque<Vertex>();
		List<Vertex> result=new ArrayList<Vertex>();
		Vertex start = vertices.get(1);
		start.seen = true;
		start.distance = 0;
		queue.add(start);
		int d = 0;
		while (!queue.isEmpty()) {
			Vertex current = queue.remove();
			result.add(current);
			current.seen = true;
			List<Edge> adj = current.Adj;
			d = d + 1;
			for (Edge e : adj) {
				Vertex otherEnd = e.otherEnd(current);
				if (!otherEnd.seen) {
					otherEnd.seen = true;
					otherEnd.distance = d;
					otherEnd.parent = current;
					queue.add(otherEnd);
				}
			}

		}
		return result;
	}

	public static void main(String[] args) throws FileNotFoundException {

		BreadthFirstSearch obj = new BreadthFirstSearch();
		Scanner sc = null;
		/*
		 * The input is taken in the form of input and
		 */
		File input = args.length > 0 ? new File(args[0]) : null;
		if (input != null && input.exists()) {
			sc = new Scanner(input);
		} else {
			System.out
					.println("Please enter dimensions of graph (#nodes,#edges) followed by edge followed by edges in format(left,right,weight)");
			sc = new Scanner(System.in);
		}
		/**
		 * Creating a graph object. in -taking input from file( vertices and
		 * nodes) true- The graph is a directed one.
		 */
		Graph graphObject = Graph.readGraph(sc, true);
		List<Vertex> bfs=obj.breadthFirstSearch(graphObject);
		System.out.println("Summary of Breadth First Search");
		for(Vertex vertex: bfs){
			System.out.println("Vertex Name: "+vertex.name+" Vertex Parent: "+vertex.parent+" Distace from the root: "+vertex.distance);
		}
		// closing scanner.
		sc.close();
	}
}
