package algo.binarytree.searcher;

import java.util.Comparator;

import algo.binarytree.node.interfaces.IBinaryTreeNode;
import algo.binarytree.searcher.interfaces.IBinarySearchTreeSearchListener;
import algo.binarytree.searcher.interfaces.IBinarySearchTreeSearchMethod;

public class RecursiveSearcher<V> implements IBinarySearchTreeSearchMethod<V> {
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
	
	@Override
	public Comparator<V> getComparator() {
		return comparator;
	}

	@Override
	public algo.binarytree.searcher.interfaces.IBinarySearchTreeSearchMethod.SearchResult<V> search(
			algo.binarytree.searcher.interfaces.IBinarySearchTreeSearchMethod.OccurrenceStrategy arg0,
			IBinaryTreeNode<V> arg1, V arg2, IBinarySearchTreeSearchListener<V>[] arg3) {
		SearchResult<V> sr = null;
		if(arg0==OccurrenceStrategy.FIRST){
			if(arg1==null)
				return null;
			if(this.getComparator().compare(arg1.getValue(), arg2)==0){
				 sr.getValues().add(arg1.getValue());
				 return sr;
			}
			else if(this.getComparator().compare(arg1.getValue(), arg2)>0)
				return search(OccurrenceStrategy.ALL, arg1.getRightChild(), arg2, arg3); 
			else
				return search(OccurrenceStrategy.ALL, arg1.getLeftChild(), arg2, arg3); 
		}
		
		if(arg0==OccurrenceStrategy.ALL){
			if(arg1==null)
				return null;
			if(this.getComparator().compare(arg1.getValue(), arg2)==0){
				 sr.getValues().add(arg1.getValue());
				 search(OccurrenceStrategy.ALL, arg1.getRightChild(), arg2, arg3);
				 search(OccurrenceStrategy.ALL, arg1.getLeftChild(), arg2, arg3);
				 return sr;
			}
			else if(this.getComparator().compare(arg1.getValue(), arg2)>0)
				return search(OccurrenceStrategy.ALL, arg1.getRightChild(), arg2, arg3); 
			else
				return search(OccurrenceStrategy.ALL, arg1.getLeftChild(), arg2, arg3);
		}
		
		if(arg0==OccurrenceStrategy.LAST){
			if(arg1==null)
				return null;
			if(this.getComparator().compare(arg1.getValue(), arg2)==0){
				sr.setLastOccurrence(arg1);
				return search(OccurrenceStrategy.ALL, arg1.getLeftChild(), arg2, arg3); 
			}
		}
		return null;
		/*if(arg0==OccurrenceStrategy.FIRST){
			
			if(arg1.getValue()==arg2)
				return sr;
			for(int i=0; i<arg3.length; i++)
				arg3[i].onFound(arg1, OccurrenceStrategy.FIRST, this);
			return search(OccurrenceStrategy.FIRST, arg1.getLeftChild(), arg2, arg3);
		}
		if(arg0==OccurrenceStrategy.LAST){
			for(int i=0; i<arg3.length; i++)
				arg3[i].onFound(arg1, OccurrenceStrategy.FIRST, this);
			return search(OccurrenceStrategy.LAST, arg1.getRightChild(), arg2, arg3);
		}
		return search(OccurrenceStrategy.ALL, arg1.getRightChild(), arg2, arg3);
		*/
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
