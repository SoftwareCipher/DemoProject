package com.demo.project;

import lombok.Data;

@Data
class Person implements Comparable<Person> {
    private String name;
    private int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public int compareTo(Person other) {
        return name.compareTo(other.name);
    }
}
