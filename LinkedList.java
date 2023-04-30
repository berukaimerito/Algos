import java.util.ArrayList;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.function.Consumer;

public class LinkedList<T> implements Iterable<T> {
    private ArrayList<T> list;

    public LinkedList() {
        list = new ArrayList<>();
    }

    public void add(T value) {
        list.add(value);
    }

    public T get(int index) {
        return list.get(index);
    }

    public void remove(int index) {
        list.remove(index);
    }

    public int size() {
        return list.size();
    }
//    @Override
//    public void forEach(Consumer<? super T> action) {
//        Iterable.super.forEach(action);
//    }

    @Override
    public Iterator<T> iterator() {
        return new LinkedListIterator();
    }

    private class LinkedListIterator implements Iterator<T> {
        private int currentIndex = 0;
        @Override
        public boolean hasNext() {
            return currentIndex < list.size();

        }
        @Override
        public T next() {
            if(!hasNext()) {
                throw new NoSuchElementException();
            }
            return list.get(currentIndex++);
        }
    }
}