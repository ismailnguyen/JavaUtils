package algo.queue;

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
		{
			this.head = tmp;
			this.current = tmp;
		}
		else
		{
			ILinkSimple<T> old = this.head;
			ILinkSimple<T> n = new LinkSimple<T>();
			
			while(n != null && this.comparator.compare(arg0, n.getValue()) < 0)
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
	public T peek() {
		if(this.current == null)
			return null;
		
		return this.current.getValue();
	}

	@Override
	public T remove() {
		if(this.current == null)
			return null;
		
		T tmp = this.peek();
		
		ILinkSimple<T> next = this.current.getNext();
		this.current = next;
		
		return tmp;
	}
}
