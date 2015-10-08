package algo.binarytree.searcher;

import java.util.Comparator;

import algo.binarytree.node.interfaces.IBinaryTreeNode;
import algo.binarytree.searcher.interfaces.IBinarySearchTreeSearchListener;
import algo.binarytree.searcher.interfaces.IBinarySearchTreeSearchMethod;

public class RecursiveSearcher<V> implements IBinarySearchTreeSearchMethod<V>{
	
	Comparator<V> _comparator;

	@Override
	public Comparator<V> getComparator() {
		return _comparator;
	}

	@Override
	public SearchResult<V> search(
			OccurrenceStrategy strategy,
			IBinaryTreeNode<V> tree, V tosearch,
			IBinarySearchTreeSearchListener<V>[] listener) {
		// TODO Auto-generated method stub
		SearchResult res = new SearchResult();
		if (strategy == OccurrenceStrategy.LAST) {
			
		}
		return res;
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
