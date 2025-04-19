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
    //Schweikert
    private class SimpleListIterator implements Iterator<T> {
        private int currentIndex = 0;
        private int lastReturnedIndex = -1;

        public SimpleListIterator(){
		}

        @Override
        public boolean hasNext() {
            return currentIndex < list.size();
        }

        @Override
        public T next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            T element = list.get(currentIndex);
            lastReturnedIndex = currentIndex;
        
            currentIndex++;
            return element;
        }

        @Override
        public void remove() {
            if (lastReturnedIndex == -1) {
                throw new IllegalStateException("next() must be called before remove()");
            }
            list.remove(lastReturnedIndex);
            currentIndex--; // adjust for removed item
            lastReturnedIndex = -1;
        }
        public void iterator(){
            while(hasNext()){
                next();

            }
        }
    }





    private class SimpleListSkippingIterator extends SimpleListIterator implements Iterator<T>  {
        private int currentIndex = 0;
        private int lastReturnedIndex = -1;
        private int currentStepSize = 1;
         
       private SimpleListSkippingIterator(int stepSize) {
        currentStepSize = stepSize;
       }
        

        @Override
        public boolean hasNext() {
            return currentIndex + currentStepSize < list.size();
        }

        @Override
        public T next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            T element = list.get(currentIndex);
            lastReturnedIndex = currentIndex;
            currentIndex = currentIndex + currentStepSize;
            return element;
        }

        @Override
        public void remove() {
            if (lastReturnedIndex == -1) {
                throw new IllegalStateException("next() must be called before remove()");
            }
            list.remove(lastReturnedIndex);
            currentIndex--; 
            lastReturnedIndex = -1;
        }
    }
    
    /**
	 * Returns an iterator that enumerates every
	 * element in the collection, starting with the
	 * first element.
	 *
	 * @return the iterator.
	 */
	@Override
	public Iterator<T> iterator() {
		return new SimpleListIterator();
	}




	/**
	 * Returns an iterator that enumerates every n-th
	 * element in the collection, starting with the
	 * first element.
	 *
	 * @param stepSize the number of skipped elements+1.
	 * @return the iterator.
	 * @throws IllegalArgumentException if stepSize is less than 1.
	 */
	@Override
	public Iterator<T> skippingIterator(int stepSize) {
		return new SimpleListSkippingIterator(stepSize);
	}
}

