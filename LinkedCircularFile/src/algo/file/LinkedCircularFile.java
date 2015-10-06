package algo.file;

import java.util.Iterator;

import algo.file.exceptions.FileEmptyException;
import algo.file.interfaces.IFifo;
import algo.linkedlist.nodes.LinkSimple;
import algo.linkedlist.nodes.interfaces.ILinkSimple;

public class LinkedCircularFile<V> implements IFifo<V>{
	
	private LinkSimple<V> list = null;

	@Override
	public Iterator<V> iterator() {
		return new LinkIterator();
	}
	
	private class LinkIterator implements Iterator<V> {
	
		private ILinkSimple<V> current = list;
		
		@Override
		public boolean hasNext() {
			return this.current != null;
		}
	
		@Override
		public V next() {
			if(!hasNext())
				try {
					throw new FileEmptyException();
				} catch (FileEmptyException e) {
					e.printStackTrace();
				}
			
			ILinkSimple<V> next = (ILinkSimple<V>) current.getValue();
			this.current = (ILinkSimple<V>) this.current.getNext();
			
			return (V) next;
		}	
	}

	@Override
	public void queue(V value) {
		LinkSimple<V> newNode = new LinkSimple<V>();
		newNode.setValue(value);
		if(list == null)
		{
			newNode.setNext(newNode);
			list = newNode;
		}
		else
		{
			newNode.setNext(list.getNext());
			list.setNext(newNode);
			list = newNode;	
		}
	}

	@Override
	public V dequeue() throws FileEmptyException {
		V tmp = list.getNext().getValue();
		if(list == list.getNext())
			list = null;
		else
			list.setNext(list.getNext().getNext());
		return tmp;
	}

	@Override
	public V peek() throws FileEmptyException {
		return list.getNext().getValue();
	}

	@Override
	public int size() {
		if(list == null)
			return 0;
		int size = 1;
		LinkSimple<V> cur = new LinkSimple<V>();
		cur = (LinkSimple<V>) list.getNext();
		while(cur != list)
		{
			size++;
			cur = (LinkSimple<V>) cur.getNext();
		}
		return size;
	}

	@Override
	public boolean isEmpty() {
		if(list == null)
			return true;
		else
			return false;
	}
}
