import java.util.Arrays;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class ArrayBackedLinkedList<T> implements  Iterable<T> {
    private Object[] elements;
    private int size;
    private int capacity;

    public ArrayBackedLinkedList(int initialCapacity) {
        capacity = initialCapacity;
        elements = new Object[capacity];
        size = 0;
    }

    public void add(T value) {
        if (size >= capacity) {
            resize();
        }
        elements[size++] = value;
    }

    public T get(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }
        return (T) elements[index];
    }

    public void remove(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }
        System.arraycopy(elements, index + 1, elements, index, size - index - 1);
        size--;
    }

    public int size() {
        return size;
    }

    private void resize() {
        capacity *= 2;
        elements = Arrays.copyOf(elements, capacity);
    }

    @Override
    public Iterator<T> iterator() {
        return new ArrayBackedLinkedListIterator();
    }

    private class ArrayBackedLinkedListIterator implements Iterator<T> {
        private int currentIndex = 0;

        @Override
        public boolean hasNext(){
            return currentIndex < size;
        }

        @Override
        public T next() {
            if(!hasNext()) {
                throw new NoSuchElementException();
            }
            return (T) elements[currentIndex++];
        }
    }
}