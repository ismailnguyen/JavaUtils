package algo.binarytree.parser.works;

import algo.binarytree.node.interfaces.IBinaryTreeNode;
import algo.binarytree.parser.interfaces.IParseWork;
import algo.binarytree.parser.works.interfaces.IDepthAverageExtern;

public class DepthAverageExtern<T> implements IDepthAverageExtern, IParseWork<T>{
	
	int nb_nodes = 0;
	int length = 0;

	@Override
	public double getAvegareExternalDepth() {
		if (nb_nodes != 0) {
			return (double)length/nb_nodes;
		}
		return 0;
	}

	@Override
	public void execute(IBinaryTreeNode<T> node, int level, String path) {
		if (node.isLeaf()) {
			nb_nodes++;
			length += level;
		}
	}

}
