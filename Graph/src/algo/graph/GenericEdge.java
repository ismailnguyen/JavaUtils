package algo.graph;

import java.util.HashMap;

import algo.graph.interfaces.IEdge;
import algo.graph.interfaces.INode;

public class GenericEdge implements IEdge {
	
	private INode _other;	
	private INode _node;
	private HashMap<String, Object> _attr;
	

	public GenericEdge (INode left, INode right, int i){
		_node = left;
		_other = right;
		_attr = new HashMap<String, Object>();
		setAttribute("cost", i);
		
		_node.getEdges().add(this);
		_other.getEdges().add(this);
	}

	@Override
	public Object getAttribute(String arg0) {
		return _attr.get(arg0);
	}

	@Override
	public INode getOther(INode arg0) {
		if (_other == arg0) {
			return _node;
		}
		return _other;
	}

	@Override
	public void setAttribute(String key, Object value) {
		_attr.put(key, value);

	}

}
