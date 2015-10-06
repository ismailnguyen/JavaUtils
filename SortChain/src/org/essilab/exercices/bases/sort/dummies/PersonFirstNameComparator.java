package org.essilab.exercices.bases.sort.dummies;

import java.util.Comparator;
import java.util.Date;

public class PersonFirstNameComparator<T> implements Comparator<T> {

	@Override
	public int compare(T o1, T o2) {
		if(!(o1 instanceof Person) || !(o2 instanceof Person))
			return 0;
		
		Person p = (Person) o1;
		Person q = (Person) o2;
        
        return p.getFirstName().compareTo(q.getFirstName());
	}
}