import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.List;
import java.util.Scanner;

public class DirectedGraph {
	
	/**
	 * 
	 * @param graph
	 * @param val1
	 * @param val2
	 * @return
	 */
	public boolean isPath(Graph graph, int val1, int val2) {

		List<Vertex> vertices = graph.verts;
		Deque<Vertex> queue = new ArrayDeque<Vertex>();

		for (int i = 1; i < vertices.size(); i++) {
			Vertex v = vertices.get(i);
			if (v.name == val1) {
				queue.add(v);
				while (!queue.isEmpty()) {
					Vertex vertex = queue.remove();
					List<Edge> edge = vertex.Adj;
					for (Edge e : edge) {
						Vertex otherEnd = e.otherEnd(v);
						if (otherEnd.name == val2) {
							return true;
						} else {
							queue.add(otherEnd);
						}
					}
				}
			}
		}
		return false;

	}

	public static void main(String[] args) throws FileNotFoundException {

		DirectedGraph obj = new DirectedGraph();
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

		System.out.println(obj.isPath(graph, 5, 4));
	}

}
