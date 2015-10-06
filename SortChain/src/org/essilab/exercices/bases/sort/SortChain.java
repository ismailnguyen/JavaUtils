package org.essilab.exercices.bases.sort;

import java.util.Comparator;

import org.essilab.exercices.bases.sort.interfaces.ISortChain;

public class SortChain<T> implements ISortChain<T> {

	private Comparator<Person> cmp;
	
	@Override
	public int compare(Object o1, Object o2) {
		this.cmp
	}

	@Override
	public void addComparator(Comparator arg0) {
		this.cmp = arg0;
	}

	@Override
	public void addComparator(int arg0, Comparator arg1) {
		// TODO Auto-generated method stub
		
	}

}
