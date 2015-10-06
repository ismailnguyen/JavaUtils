package org.essilab.exercices.bases.sort;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

import org.essilab.exercices.bases.sort.dummies.*;
import org.essilab.exercices.bases.sort.interfaces.ISortChain;

public class Application {
	public static void main(String[] args) {
		
		List<Person> persons = new ArrayList<Person>();
		persons.add(new Person("Olivier", "Sar", new Date(98, 11, 12)));
		persons.add(new Person("Etienne", "Pigeot", new Date(99, 11, 12)));
		persons.add(new Person("Antoine", "Pigeot", new Date(99, 11, 12)));
		persons.add(new Person("Wilfrid", "Zerk", new Date(99, 11, 12)));
		persons.add(new Person("Henry", "Pigeot", new Date(99, 11, 12)));
		persons.add(new Person("Laurent", "Pigeot", new Date(99, 11, 12)));
		persons.add(new Person("Olivier", "Pigeot", new Date(95, 11, 12)));
		persons.add(new Person("Stéphane", "Laurent", new Date(99, 11, 12)));
		persons.add(new Person("Antoine", "Sar", new Date(97, 11, 12)));
		persons.add(new Person("Antoine", "Bichon", new Date(97, 11, 12)));
		persons.add(new Person("Antoine", "Renaud", new Date(97, 11, 12)));
		
		SortChain<Person> sort1 = new SortChain<Person>();
		sort1.addComparator(new PersonBirhdateComparator());
		Collections.sort(persons, sort1);
		System.out.println(persons);

		sort1.addComparator(new PersonLastNameComparator());
		Collections.sort(persons, sort1);
		System.out.println(persons);
		
		sort1.addComparator(new PersonFirstNameComparator());
		Collections.sort(persons, sort1);
		System.out.println(persons);
		
	}
}

