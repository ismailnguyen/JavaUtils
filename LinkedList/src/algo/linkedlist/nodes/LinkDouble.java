package algo.linkedlist.nodes;

import algo.linkedlist.nodes.interfaces.ILinkDouble;
import algo.linkedlist.nodes.interfaces.ILinkSimple;

public class LinkDouble extends LinkSimple<Object> implements ILinkDouble<Object> {

	private Object data;
	private ILinkDouble<Object> previous;
	private ILinkDouble<Object> next;
	
	@Override
	public Object getValue() {
		return this.data;
	}

	@Override
	public void setNext(ILinkSimple<Object> arg0) {
		this.setNext(arg0);
	}

	@Override
	public void setValue(Object arg0) {
		this.data = arg0;
	}

	@Override
	public ILinkDouble<Object> getNext() {
		return this.next;
	}

	@Override
	public ILinkDouble<Object> getPrevious() {
		return this.previous;
	}

	@Override
	public void setNext(ILinkDouble<Object> arg0) {
		this.next = arg0;
		
	}

	@Override
	public void setPrevious(ILinkDouble<Object> arg0) {
		this.previous = arg0;
	}

}
