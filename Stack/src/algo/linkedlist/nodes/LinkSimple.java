package algo.linkedlist.nodes;

import algo.linkedlist.nodes.interfaces.ILinkSimple;

public class LinkSimple implements ILinkSimple {
	
	private Object data;
	private ILinkSimple next;

	@Override
	public ILinkSimple getNext() {
		return this.next;
	}

	@Override
	public Object getValue() {
		return this.data;
	}

	@Override
	public void setNext(ILinkSimple arg0) {
		this.next = arg0;
	}

	@Override
	public void setValue(Object arg0) {
		this.data = arg0;
	}

}
