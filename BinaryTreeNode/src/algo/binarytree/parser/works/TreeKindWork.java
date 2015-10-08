package algo.binarytree.parser.works;

import algo.binarytree.node.interfaces.IBinaryTreeNode;
import algo.binarytree.parser.interfaces.IParseWork;
import algo.binarytree.parser.works.interfaces.ITreeKindWork;

public class TreeKindWork<T> implements IParseWork<T>, ITreeKindWork {
	
	boolean degenere = true;
	boolean complet = true;
	boolean local_complet = true;
	boolean parfait = true;
	int level = 0;

	@Override
	public void execute(IBinaryTreeNode<T> node, int l, String path) {
		if (l > level) {
			level = l;
		}
		
		if (!node.isLeaf() && node.isDoublePoint()) {
			degenere = false;
		}
		if (node.isLeaf() && l != level) {
			complet = false;
		}
		if (!node.isLeaf() && !node.isDoublePoint()) {
			local_complet = false;
			complet = false;
		}
	}

	@Override
	public TreeKind getTreeKind() {
		if (degenere)
			return TreeKind.DEGENERATED;
		if (complet)
			return TreeKind.COMPLETE;
		if (local_complet)
			return TreeKind.LOCALLY_COMPLETE;
		if (parfait)
			return TreeKind.PERFECT;
		
		return TreeKind.OTHER;
	}


}
