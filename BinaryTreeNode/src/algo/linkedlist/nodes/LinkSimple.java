package algo.linkedlist.nodes;

import algo.linkedlist.nodes.interfaces.ILinkSimple;

public class LinkSimple<V> implements ILinkSimple<V> {
	
	private V data;
	private ILinkSimple<V> next;

	@Override
	public ILinkSimple<V> getNext() {
		return this.next;
	}

	@Override
	public V getValue() {
		return this.data;
	}

	@Override
	public void setNext(ILinkSimple<V> arg0) {
		this.next = arg0;
	}

	@Override
	public void setValue(V arg0) {
		this.data = arg0;
	}

}
