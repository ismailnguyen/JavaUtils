package algo.graph;

import java.util.List;

import algo.graph.interfaces.IEdge;
import algo.graph.interfaces.INode;

public class Application {

	public static void main(String[] args) {
		Graph<String, Object> graph = new Graph<>();

		// Build node.
		GenericNode<String, Object> paris = new GenericNode<>("Paris");
		GenericNode<String, Object> lyon = new GenericNode<>("Lyon");
		GenericNode<String, Object> grenoble = new GenericNode<>("Grenoble");
		GenericNode<String, Object> valence = new GenericNode<>("Valence");
		GenericNode<String, Object> gap = new GenericNode<>("Gap");
		GenericNode<String, Object> marseille = new GenericNode<>("Marseille");

		graph.registerNode(paris);
		graph.registerNode(lyon);
		graph.registerNode(grenoble);
		graph.registerNode(valence);
		graph.registerNode(gap);
		graph.registerNode(marseille);
		
		// Build edges
		new GenericEdge(paris, lyon, 400);
		new GenericEdge(lyon, grenoble, 100);
		new GenericEdge(lyon, valence, 100);
		new GenericEdge(grenoble, valence, 100);
		new GenericEdge(grenoble, gap, 100);
		new GenericEdge(gap, marseille, 150);
		new GenericEdge(valence, marseille, 250);
		
		INode<String, Object> node = graph.getNode("Grenoble");
		
		List<IEdge> edges = node.getEdges();
		for (IEdge edge : edges)
			System.out.println(edge.getOther(node) + " -> " + edge.getAttribute("cost")); 
		   // Lyon -> 100
		   // Valence -> 100
		   // Gap > 100

	}

}
