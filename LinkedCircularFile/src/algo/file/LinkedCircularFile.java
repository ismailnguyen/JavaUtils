package algo.file;

import java.util.Iterator;

import algo.file.exceptions.FileEmptyException;
import algo.file.interfaces.IFifo;
import algo.linkedlist.nodes.LinkSimple;

public class LinkedCircularFile<V> implements IFifo<V>{
	
	private LinkSimple<V> list = new LinkSimple<V>();

	@Override
	public Iterator<V> iterator() {
		Iterator<V> iterator = new Iterator<V>() {
			LinkSimple<V> temp = (LinkSimple<V>) list.getNext();
			@Override
			public boolean hasNext() {
				return (temp.getNext() == list)? false : true;
			}
	
			@Override
			public V next() {
				if(hasNext()){
					temp = (LinkSimple<V>) temp.getNext();
				}
				return temp.getValue();
			}	
		};
		return iterator;
	}

	@Override
	public void queue(V value) {
		LinkSimple<V> newNode = new LinkSimple<V>();
		newNode.setValue(value);
		if(list.getValue() == null)
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
		if(list.getValue() == null)
			throw new FileEmptyException();
		
		V tmp = list.getNext().getValue();
		if(list == list.getNext())
			list = new LinkSimple<V>();
		else
			list.setNext(list.getNext().getNext());
		return tmp;
	}

	@Override
	public V peek() throws FileEmptyException {
		if(list.getValue() == null)
			return null;
		
		return list.getNext().getValue();
	}

	@Override
	public int size() {
		if(list.getValue() == null)
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
		if(list.getValue() == null)
			return true;
		else
			return false;
	}
}
