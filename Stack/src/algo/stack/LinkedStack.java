package algo.stack;

import java.util.ArrayList;
import java.util.Iterator;

import algo.linkedlist.nodes.LinkSimple;
import algo.stack.exception.StackEmptyException;
import algo.stack.interfaces.ILifo;

public class LinkedStack<V> implements ILifo<V> {

	ArrayList<LinkSimple> stacks = new ArrayList<LinkSimple>();
	private int size;
	private int
	
	@Override
	public Iterator iterator() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Object peek() throws StackEmptyException {
		return this.stacks.get(this.stacks.size()-1);
	}

	@Override
	public Object pop() throws StackEmptyException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void push(Object arg0) {
		if(arg0 instanceof LinkSimple)
			this.stacks.add((LinkSimple) arg0);
	}

	@Override
	public int size() {
		return this.stacks.size();
	}

}
