import java.util.Iterator;
import java.util.LinkedList;
import java.util.NoSuchElementException;
import java.util.Queue;

public class OueueLL<T> implements Iterable<T> {
    private LinkedList<T> list = new LinkedList<>();

    public void enqueue(T value) {
        list.addLast(value);
    }

    public T dequeue() {
        if(isEmpty()) {
            throw new NoSuchElementException("Queue is empty.");
        }
        return list.removeFirst();
    }

    public T peek() {
        if(isEmpty()) {
            throw new NoSuchElementException("Queue is empty.");
        }
        return list.getFirst();
    }

    public boolean isEmpty() {
        return list.isEmpty();
    }

    public int size() {
        return list.size();
    }

    @Override
    public Iterator<T> iterator() {
        return new QueueIterator();
    }

    private class QueueIterator implements Iterator<T> {
        private int index = 0;

        @Override
        public boolean hasNext() {
            return index < list.size();
        }

        @Override
        public T next() {
            if(!hasNext()) {
                throw new NoSuchElementException();
            }
            return list.get(index++);
        }
    }
}