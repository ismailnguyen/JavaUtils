package algo.binarytree.parser.works;

import algo.binarytree.node.interfaces.IBinaryTreeNode;
import algo.binarytree.parser.interfaces.IParseWork;
import algo.binarytree.parser.works.interfaces.ITreeHeightWork;

public class TreeHeightWork<S> implements ITreeHeightWork, IParseWork<S>{
	int height = 0;

	@Override
	public int getTreeHeight() {
		return height;
	}

	@Override
	public void execute(IBinaryTreeNode<S> node, int level, String path) {
		if (level > height) {
			height = level;
		}
	}

}
