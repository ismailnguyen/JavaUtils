package algo.binarytree.parser.works;

import algo.binarytree.node.interfaces.IBinaryTreeNode;
import algo.binarytree.parser.interfaces.IParseWork;
import algo.binarytree.parser.works.interfaces.ITreeKindWork;

public class TreeKindWork<T> implements IParseWork<T>, ITreeKindWork {
	
	boolean _degenere = true;
	boolean _complet = true;
	boolean _local_complet = true;
	boolean _parfait = true;
	int _level = 0;

	@Override
	public void execute(IBinaryTreeNode<T> node, int level, String path) {
		if (level > _level) {
			_level = level;
		}
		
		if (!node.isLeaf() && node.isDoublePoint()) {
			_degenere = false;
		}
		if (node.isLeaf() && level != _level) {
			_complet = false;
		}
		if (!node.isLeaf() && !node.isDoublePoint()) {
			_local_complet = false;
			_complet = false;
		}
	}

	@Override
	public TreeKind getTreeKind() {
		if (_degenere)
			return TreeKind.DEGENERATED;
		if (_complet)
			return TreeKind.COMPLETE;
		if (_local_complet)
			return TreeKind.LOCALLY_COMPLETE;
		if (_parfait)
			return TreeKind.PERFECT;
		
		return TreeKind.OTHER;
	}


}
