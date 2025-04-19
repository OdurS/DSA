package de.unistuttgart.dsass2025.ex00.p4;

import java.util.Iterator;

/**
 * An iterator over a collection
 *
 * @param <T> The type of elements returned by this iterator
 */
public interface ISimpleListIterable<T extends Comparable<T>> extends ISimpleList<T> {

    /**
    * Returns an iterator that enumerates every element in the collection,
    * starting with the element at index 0.
    *
    * @return the iterator
    */
    public Iterator<T> iterator();

    /**
    * Returns an iterator that enumerates every n-th element in the collection,
    * starting with the element at index 0.
    *
    * @param stepSize the number of skipped elements + 1
    * @return the iterator
    * @throws IllegalArgumentException if stepSize is less than 1
    */
    public Iterator<T> skippingIterator(int stepSize);
}