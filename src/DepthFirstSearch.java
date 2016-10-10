import java.io.File;
import java.io.FileNotFoundException;
import java.util.List;
import java.util.Scanner;

/**
 * @author M Krishna Kavya
 *
 */
public class DepthFirstSearch {
	
	public List<Vertex> depthFirstSearch(Graph graphObject){
		
		return null;
	}

	/**
	 * @param args
	 * @throws FileNotFoundException 
	 */
	public static void main(String[] args) throws FileNotFoundException {
		
		DepthFirstSearch dfs=new DepthFirstSearch();
		File input=args.length>0 ? new File(args[0]): null;
		Scanner sc=null;
		if(input!=null && input.exists()){
			sc=new Scanner(input);
		}
		else{
			System.out.println("Please enter dimensions of graph (#nodes,#edges) followed by edge followed by edges in format(left,right,weight)");
			sc=new Scanner(System.in);
		}
		
		Graph graph=Graph.readGraph(sc, true);
		
		dfs.depthFirstSearch(graph);
		
		sc.close();
	}

}
