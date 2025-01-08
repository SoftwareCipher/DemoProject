package com.demo.project;

import java.util.Comparator;

public class SortByNameComparator implements Comparator<Person> {
    @Override
    public int compare(Person o1, Person o2) {
        return Integer.compare(o2.getName().length(), o1.getName().length());
    }
}
