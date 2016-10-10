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
 */
public class DepthFirstSearch {

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

	public void dfsUtil(Vertex current, Deque<Vertex> stack, Set<Vertex> visited) {
		current.seen = true;
		visited.add(current);
		stack.push(current);

		while (!stack.isEmpty()) {
			// Fetch the top vertex from the stack.
			Vertex v = stack.pop();
			// adding to the output
			System.out.println(v.name + " ");
			List<Edge> edge = v.Adj;
			for (Edge e : edge) {
				Vertex otherEnd = e.otherEnd(v);
				if (visited.contains(otherEnd)) {
					continue;
				} else {
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

		Graph graph = Graph.readGraph(sc, true);

		dfs.depthFirstSearch(graph);

		sc.close();
	}

}
