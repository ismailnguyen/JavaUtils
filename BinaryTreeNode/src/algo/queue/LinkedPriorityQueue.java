package algo.queue;

import java.util.ArrayList;
import java.util.Comparator;

import algo.linkedlist.nodes.LinkSimple;
import algo.linkedlist.nodes.interfaces.ILinkSimple;
import algo.queue.interfaces.IPriorityQueue;

public class LinkedPriorityQueue<T> implements IPriorityQueue<T> {

	private ILinkSimple<T> head;
	private ILinkSimple<T> current;
	private Comparator<T> comparator;
	
	public LinkedPriorityQueue(Comparator<T> c)
	{
		this.comparator = c;
	}
	
	@Override
	public void add(T arg0) {
		ILinkSimple<T> tmp = new LinkSimple<T>();
		tmp.setValue(arg0);
		
		if(this.head == null)
			this.head = tmp;
		else
		{
			ILinkSimple<T> old = this.head;
			ILinkSimple<T> n = new LinkSimple<T>();
			
			while(n != null && this.comparator.compare(arg0, n.getValue()) < 0)
			{
				old = n;
				n = n.getNext();
			}
			
			if(n == null)
			{
				
			}
		}
		
		node = (ILinkSimple<T>) arg0;
		node.setNext((ILinkSimple<T>) old);
	}
	{
		LinkSimple<T> nouveau = new LinkSimple<T>();
		nouveau.setValue(valeur);
				
		if (_head == null) {
			_head = nouveau;
			_tail = nouveau;
		} else {
			ILinkSimple<T> n = _head;
			ILinkSimple<T> p = new LinkSimple<T>();
			
			
			if (n == null ) {
				_tail.setNext(nouveau);
				_tail = nouveau;
			} else{
				if (p.getValue() != null) {
					p.setNext(nouveau);
				} else {
					this._head = nouveau;
				}
				nouveau.setNext(n);
			}	
		}
	}

	@Override
	public T peek() {
		if(node == null)
			return null;
		
		return (T) node.getValue();
	}

	@Override
	public T remove() {
		if(node == null)
			return null;
		
		T tmp = this.peek();
		
		ILinkSimple<T> next = (ILinkSimple<T>) node.getNext();
		this.node = (ILinkSimple<T>) next;
		
		return tmp;
	}

}
