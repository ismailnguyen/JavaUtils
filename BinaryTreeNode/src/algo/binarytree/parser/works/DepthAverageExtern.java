package algo.binarytree.parser.works;

import algo.binarytree.node.interfaces.IBinaryTreeNode;
import algo.binarytree.parser.interfaces.IParseWork;
import algo.binarytree.parser.works.interfaces.IDepthAverageExtern;

public class DepthAverageExtern<T> implements IDepthAverageExtern, IParseWork<T>{
	
	int _nb_nodes = 0;
	int _length = 0;

	@Override
	public double getAvegareExternalDepth() {
		if (_nb_nodes != 0) {
			return (double)_length/_nb_nodes;
		}
		return 0;
	}

	@Override
	public void execute(IBinaryTreeNode<T> node, int level, String path) {
		if (node.isLeaf()) {
			_nb_nodes++;
			_length += level;
		}
	}

}
