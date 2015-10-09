package algo.binarytree.searcher;

import java.util.Comparator;

import algo.binarytree.node.interfaces.IBinaryTreeNode;
import algo.binarytree.searcher.interfaces.IBinarySearchTreeSearchListener;
import algo.binarytree.searcher.interfaces.IBinarySearchTreeSearchMethod;

public class IterativeSearcher<V> implements IBinarySearchTreeSearchMethod<V>{

	private Comparator<V> comparator = new Comparator<V>() {

		@Override
		public int compare(V o1, V o2) {
			if((int)o1>(int)o2)
				return 1;
			if((int)o1<(int)o2)
				return -1;
			return 0;
		}
		
	};
	private SearchResult<V> sr;
	
	@Override
	public Comparator<V> getComparator() {
		return comparator;
	}

	@Override
	public algo.binarytree.searcher.interfaces.IBinarySearchTreeSearchMethod.SearchResult<V> search(
			algo.binarytree.searcher.interfaces.IBinarySearchTreeSearchMethod.OccurrenceStrategy arg0,
			IBinaryTreeNode<V> arg1, V arg2, IBinarySearchTreeSearchListener<V>[] arg3) {
		sr = null;
		IBinaryTreeNode<V> tmp=arg1;
		while(arg1!=null){
			if(arg0==OccurrenceStrategy.FIRST){
				if(this.getComparator().compare(tmp.getValue(), arg2)==0){
					 sr.getValues().add(arg1.getValue());
					 return sr;
				}
				else if(this.getComparator().compare(tmp.getValue(), arg2)>0)
					tmp=tmp.getRightChild(); 
				else
					tmp=tmp.getLeftChild();
			}
			
			if(arg0==OccurrenceStrategy.ALL){
			
				if(this.getComparator().compare(tmp.getValue(), arg2)==0){
					 sr.getValues().add(tmp.getValue());
					 tmp=tmp.getRightChild();
					 tmp=tmp.getLeftChild();
					 
				}
				else if(this.getComparator().compare(tmp.getValue(), arg2)>0)
					tmp=tmp.getRightChild(); 
				else
					tmp=tmp.getLeftChild();
			}
		
			if(arg0==OccurrenceStrategy.LAST){
				if(this.getComparator().compare(tmp.getValue(), arg2)==0){
					sr.setLastOccurrence(tmp);
				}
				else if(this.getComparator().compare(tmp.getValue(), arg2)>0)
					tmp=tmp.getRightChild(); 
				else
					tmp=tmp.getLeftChild();
			}
		}
		return sr;
	}

	@Override
	public IBinaryTreeNode<V> searchMax(IBinaryTreeNode<V> arg0) {
		if(arg0==null)
			return null;
		if(arg0.getRightChild()==null)
			return arg0;
		return searchMax(arg0.getRightChild());
	}

	@Override
	public IBinaryTreeNode<V> searchMin(IBinaryTreeNode<V> arg0) {
		if(arg0==null)
			return null;
		if(arg0.getLeftChild()==null)
			return arg0;
		return searchMin(arg0.getLeftChild());
	}

	@Override
	public void setComparator(Comparator<V> arg0) {
		this.comparator = arg0;
		
	}

}
