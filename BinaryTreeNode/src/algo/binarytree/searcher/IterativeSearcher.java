package algo.binarytree.searcher;

import java.util.Comparator;

import algo.binarytree.node.interfaces.IBinaryTreeNode;
import algo.binarytree.searcher.interfaces.IBinarySearchTreeSearchListener;
import algo.binarytree.searcher.interfaces.IBinarySearchTreeSearchMethod;

public class IterativeSearcher<V> implements IBinarySearchTreeSearchMethod<V> {

	Comparator<V> comparator;
	
	@Override
	public Comparator<V> getComparator() {
		return this.comparator;
	}

	@Override
	public algo.binarytree.searcher.interfaces.IBinarySearchTreeSearchMethod.SearchResult<V> search(
			algo.binarytree.searcher.interfaces.IBinarySearchTreeSearchMethod.OccurrenceStrategy arg0,
			IBinaryTreeNode<V> arg1, V arg2,
			IBinarySearchTreeSearchListener<V>[] arg3) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public IBinaryTreeNode<V> searchMax(IBinaryTreeNode<V> arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public IBinaryTreeNode<V> searchMin(IBinaryTreeNode<V> arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setComparator(Comparator<V> arg0) {
		// TODO Auto-generated method stub
		
	}

}
