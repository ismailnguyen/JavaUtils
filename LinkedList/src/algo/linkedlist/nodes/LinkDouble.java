package algo.linkedlist.nodes;

import algo.linkedlist.nodes.interfaces.ILinkDouble;
import algo.linkedlist.nodes.interfaces.ILinkSimple;

public class LinkDouble extends LinkSimple implements ILinkDouble {

	private Object data;
	private ILinkDouble previous;
	private ILinkDouble next;
	
	@Override
	public Object getValue() {
		return this.data;
	}

	@Override
	public void setNext(ILinkSimple arg0) {
		this.setNext(arg0);
	}

	@Override
	public void setValue(Object arg0) {
		this.data = arg0;
	}

	@Override
	public ILinkDouble getNext() {
		return this.next;
	}

	@Override
	public ILinkDouble getPrevious() {
		return this.previous;
	}

	@Override
	public void setNext(ILinkDouble arg0) {
		this.next = arg0;
		
	}

	@Override
	public void setPrevious(ILinkDouble arg0) {
		this.previous = arg0;
	}

}
