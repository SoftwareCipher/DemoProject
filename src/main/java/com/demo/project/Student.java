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
        id = objectInputStream.readInt() ^ 0xFF;
        name = objectInputStream.readUTF();
    }

    @Serial
    private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
        objectOutputStream.defaultWriteObject();
        objectOutputStream.writeInt(id ^ 0xFF);
        objectOutputStream.writeUTF(name);
    }
}