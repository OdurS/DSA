package de.unistuttgart.dsass2025.ex00.p4;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;

public class SimpleList<T extends Comparable<T>> implements ISimpleListIterable<T> {

    /** Do not modify the existing methods and signatures! */
    private final List<T> list;

    public SimpleList() {
        list = new ArrayList<T>();
    }

    @Override
    public void append(T element) {
        list.add(element);
    }

    @Override
    public int getSize() {
        return list.size();
    }

    @Override
    public T getElement(int index) {
        return list.get(index);
    }

}