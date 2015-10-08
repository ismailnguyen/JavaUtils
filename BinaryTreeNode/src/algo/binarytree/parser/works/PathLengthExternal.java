package algo.binarytree.parser.works;

import algo.binarytree.node.interfaces.IBinaryTreeNode;
import algo.binarytree.parser.interfaces.IParseWork;
import algo.binarytree.parser.works.interfaces.IPathLengthExternal;

public class PathLengthExternal<T> implements IPathLengthExternal, IParseWork<T>{
	int _pathLength;

	@Override
	public int getExternalPathLength() {
		return _pathLength;
	}

	@Override
	public void execute(IBinaryTreeNode<T> node, int level, String path) {
		if (!node.isLeaf()) {
			_pathLength++;
		}
	}
}
