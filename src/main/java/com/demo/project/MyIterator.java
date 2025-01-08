package com.demo.project;

import java.util.Iterator;

class MyIterator<T> implements Iterator<T> {
    private final MyCollection<T> collection;
    private int index = 0;

    public MyIterator(MyCollection<T> collection) {
        this.collection = collection;
    }

    @Override
    public boolean hasNext() {
        return index < collection.size();
    }

    @Override
    public T next() {
        if (!hasNext()) {
            throw new IllegalStateException("No more elements");
        }
        return collection.getItems()[index++];
    }

    @Override
    public void remove() {
        throw new UnsupportedOperationException("Remove not supported");
    }
}
