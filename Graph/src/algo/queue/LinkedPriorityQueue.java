package algo.queue;

import java.util.Comparator;

import algo.linkedlist.nodes.LinkSimple;
import algo.linkedlist.nodes.interfaces.ILinkSimple;
import algo.queue.interfaces.IPriorityQueue;

public class LinkedPriorityQueue<V> implements IPriorityQueue<V> {

	private ILinkSimple<V> head;
	private ILinkSimple<V> current;
	private Comparator<V> comparator;
	
	public LinkedPriorityQueue(Comparator<V> c)
	{
		this.comparator = c;
	}
	
	@Override
	public void add(V arg0) {
		ILinkSimple<V> tmp = new LinkSimple<V>();
		tmp.setValue(arg0);
		
		if(this.head == null)	
		{
			this.head = tmp;
			this.current = tmp;
		}
		else
		{
			ILinkSimple<V> old = this.head;
			ILinkSimple<V> n = new LinkSimple<V>();
			
			while(n != null && this.comparator.compare(arg0, head.getValue()) < 0)
			{
				old = n;
				n = n.getNext();
			}
			
			if(old == null)
			{
				this.current.setNext(tmp);
				this.current = tmp;
			}
			else
			{
				if(n.getValue() != null)
				{
					n.setNext(tmp);
				}
				else
				{
					this.head = tmp;
				}
				
				tmp.setNext(old);
			}
		}
	}

	@Override
	public V peek() {
		if(this.head == null)
			return null;
		
		return this.head.getValue();
	}

	@Override
	public V remove() {
		if(this.head == null)
			return null;
		
		V tmp = this.peek();
		
		ILinkSimple<V> next = this.head.getNext();
		this.head = next;
		
		return tmp;
	}
}
