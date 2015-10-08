package algo.binarytree.parser.works;

import algo.binarytree.node.interfaces.IBinaryTreeNode;
import algo.binarytree.parser.interfaces.IParseWork;
import algo.binarytree.parser.works.interfaces.IPathLengthInternal;

public class PathLengthInternal<T> implements IPathLengthInternal, IParseWork<T>{
	
	int length;

	@Override
	public int getInternalPathLength() {
		return length;
	}

	@Override
	public void execute(IBinaryTreeNode<T> node, int level, String path) {
		if (node.isSimplePoint() || node.isDoublePoint()) {
			length+=level;
		}
	}

}
