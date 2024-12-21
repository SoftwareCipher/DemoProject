package com.demo.project;

import java.io.*;

public class Student implements Serializable {
    int id;
    String name;

    public Student(int id, String name) {
        this.id = id;
        this.name = name;
    }

    @Serial
    private void readObject(ObjectInputStream objectInputStream) throws IOException, ClassNotFoundException {
        objectInputStream.defaultReadObject();
        id = (int) objectInputStream.readObject() ^ 0xFF;
        name = (String) objectInputStream.readObject() + "    ";
    }

    @Serial
    private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
        id = id ^ 0xFF;
        name = name +  "    ";
        objectOutputStream.defaultWriteObject();
    }
}