package algo.stack;

import java.util.Iterator;
import algo.linkedlist.nodes.LinkSimple;
import algo.stack.exception.StackEmptyException;
import algo.stack.interfaces.ILifo;

public class LinkedStack<V> implements ILifo<V> {

	private int size;
	private LinkSimple<V> first;
	
	public LinkedStack() {
		this.size = 0;
		this.first = null;
	}
	
	@Override
	public Iterator iterator() {
		return new LinkIterator();
	}
	
	private class LinkIterator implements Iterator<V> {

		private LinkSimple<V> current = first;
		
		@Override
		public boolean hasNext() {
			return this.current != null;
		}

		@Override
		public V next() {
			if(!hasNext())
				try {
					throw new StackEmptyException();
				} catch (StackEmptyException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			
			LinkSimple<V> next = (LinkSimple<V>) current.getValue();
			this.current = (LinkSimple<V>) this.current.getNext();
			
			return (V) next;
		}
	}

	@Override
	public boolean isEmpty() {
		return this.first == null;
	}

	@Override
	public V peek() throws StackEmptyException {
		if(isEmpty())
			throw new StackEmptyException();
		
		return this.first.getValue();
	}

	@Override
	public V pop() throws StackEmptyException {
		if(isEmpty())
			throw new StackEmptyException();
		
		V popped = this.first.getValue();
		this.first = (LinkSimple<V>) first.getNext();
		this.size--;
		
		return popped;
	}

	@Override
	public void push(Object arg0) {
		LinkSimple<V> old = this.first;
		this.first = new LinkSimple<V>();
		this.first.setValue((V) arg0);
		this.first.setNext(old);
		this.size++;
	}

	@Override
	public int size() {
		return this.size;
	}

}
