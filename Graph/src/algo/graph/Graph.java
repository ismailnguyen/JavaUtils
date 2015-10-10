package algo.graph;

import java.util.Collection;
import java.util.HashMap;

import algo.graph.interfaces.IGraph;
import algo.graph.interfaces.INode;

public class Graph<K, V> implements IGraph<K, V>{
	
	HashMap<K, INode> _collection;
	
	public Graph() {
		super();
		_collection = new HashMap<K, INode>();
	}

	@Override
	public INode<K, V> getNode(K key) {
		return _collection.get(key);
	}

	@Override
	public void registerNode(INode<K, V> arg0) {
		_collection.put(arg0.getId(), arg0);
	}

	@Override
	public void unregisterNode(K arg0) {
		_collection.remove(arg0);
		
	}

	@Override
	public Collection getNodes() {
		return _collection.values();
	}
}
