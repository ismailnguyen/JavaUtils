package org.essilab.exercices.bases.sort;

import java.util.ArrayList;
import java.util.Comparator;

import org.essilab.exercices.bases.sort.interfaces.ISortChain;

public class SortChain<P> implements ISortChain {

    ArrayList<Comparator> comparators = new ArrayList<Comparator>();

    @Override
    public int compare(Object o1, Object o2)
    {
        int result = 0;
        for (int i = 0; i < comparators.size(); i++)
        {
            result = comparators.get(i).compare(o1, o2);
            if (result != 0)
                break;
        }
        return result;
    }
    
    @Override
    public void addComparator(Comparator comparator) {
        comparators.add(comparator);
    }

    @Override
    public void addComparator(int i, Comparator comparator) {
        comparators.add(i, comparator);
    }
}
