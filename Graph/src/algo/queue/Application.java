package algo.queue;

import algo.queue.interfaces.IPriorityQueue;
import java.util.Comparator;

public class Application {

	public static void main(String[] args) {
		IPriorityQueue<Integer> s = new LinkedPriorityQueue<Integer>(new Comparator<Integer>() {
			@Override
			public int compare(Integer o1, Integer o2) {
				return o2 != null ? o1.compareTo(o2) : o1.compareTo(0);
			}
		});
		
		s.add(15);
		s.add(11);
		s.add(18);
		s.add(13);
		s.add(25);
		s.add(14);
		
		Integer i = null;
		while (null != (i = s.remove())) {
			System.out.println(i);
		}

	}

}
