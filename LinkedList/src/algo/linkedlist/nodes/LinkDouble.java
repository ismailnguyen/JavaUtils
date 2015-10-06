package algo.linkedlist.nodes;

import algo.linkedlist.nodes.interfaces.ILinkDouble;
import algo.linkedlist.nodes.interfaces.ILinkSimple;

public class LinkDouble<V> extends LinkSimple<V> implements ILinkDouble<V> {

	private V data;
	private ILinkDouble<V> previous;
	private ILinkDouble<V> next;
	
	@Override
	public V getValue() {
		return this.data;
	}

	@Override
	public void setNext(ILinkSimple<V> arg0) {
		this.setNext(arg0);
	}

	@Override
	public void setValue(V arg0) {
		this.data = arg0;
	}

	@Override
	public ILinkDouble<V> getNext() {
		return this.next;
	}

	@Override
	public ILinkDouble<V> getPrevious() {
		return this.previous;
	}

	@Override
	public void setNext(ILinkDouble<V> arg0) {
		this.next = arg0;
		
	}

	@Override
	public void setPrevious(ILinkDouble<V> arg0) {
		this.previous = arg0;
	}

}
