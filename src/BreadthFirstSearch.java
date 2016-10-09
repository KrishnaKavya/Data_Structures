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
 *         Classes: Graph, Vertex, Edge.
 * 
 */

public class BreadthFirstSearch {
	/**
	 * 
	 * The method breadthFirstSearch takes the graph as an object and returns
	 * the list of vertices in the format of bfs. Queue data structure is used
	 * to implement BFS for a graph/tree.
	 * 
	 * Initialization:
	 * 
	 * (Set in the Vertex class) The vertices are fetched to the list. Every
	 * vertex is initialized with: Parent: null distance from the root or start
	 * vertex: 0. seen(visited): false
	 * 
	 * Implementation:
	 * 
	 * The first or the start vertex is added to the queue. The distance from
	 * the start to start is zero, we set is as seen and add to the queue. BFS
	 * is achieved by fetching all the nodes level by level. In order to achieve
	 * that, we add all the nodes at a single level to the queue and process the
	 * whole graph by fetching one vertex from the queue and repeating the above
	 * again ,till we process all the vertices.
	 * 
	 * 
	 * @param graphObject
	 * @return
	 */
	public List<Vertex> breadthFirstSearch(Graph graphObject) {
		List<Vertex> vertices = graphObject.verts;
		// The queue of type vertex is initialized.
		Deque<Vertex> queue = new ArrayDeque<Vertex>();
		// The list of vertices is initialized to store the result of BFS
		List<Vertex> result = new ArrayList<Vertex>();
		/*
		 * The start vertex is fetched and is added to the queue. The vertex is
		 * marked as visited and distance from the root is set to 0.
		 * 
		 * The standard distance from the root to any vertex in the graph is run
		 * with the counter d. The distance is updated to d+1 when processing
		 * every level of nodes. for level 1 (d=d+1=0+1=1) level2(d=d+1=1+1=2).
		 * 
		 * The queue processes all the vertices, Hence, while queue!=null,
		 * dequeue the vertex from the queue, set seen,distance. Add the current
		 * vetex to the result as it finished processing. for all the child
		 * nodes or the next nodes in the graph. For each vertex on the other
		 * end or the next level, if the vertex is not already seen, we process
		 * the vertex(seen, distance and parent).(Parent to the other end nodes
		 * is the current node) and add it to the queue.
		 */
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
		 * Taking the file name as an argument from the command line or can
		 * input the values. The scanner has the values from the input file.
		 * (Files/input.txt).
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
		/*
		 * Method breadthFirstSearch returns list of vertices in bfs order.
		 */
		List<Vertex> bfs = obj.breadthFirstSearch(graphObject);
		/*
		 * Displaying the summary of BFS.
		 */
		System.out.println("Summary of Breadth First Search");
		for (Vertex vertex : bfs) {
			System.out.println("Vertex Name: " + vertex.name
					+ " Vertex Parent: " + vertex.parent
					+ " Distace from the root: " + vertex.distance);
		}
		// closing scanner.
		sc.close();
	}
}
