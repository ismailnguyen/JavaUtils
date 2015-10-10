package algo.graph;

import java.util.ArrayList;
import java.util.List;

import algo.graph.interfaces.IEdge;
import algo.graph.interfaces.INode;

public class GenericNode<K, V> implements INode<K, V>{

	private List<IEdge> _list = new ArrayList<IEdge>();
	private K _id;
	private V _value;
	
	public GenericNode (K id){
		_id = id;
	}
	
	@Override
	public List<IEdge> getEdges() {
		return _list;
	}

	@Override
	public K getId() {
		return _id;
	}

	@Override
	public V getValue() {
		return _value;
	}
	
	public String toString() {
		return _id.toString();
	}

}
