import java.util.Iterator;
import java.util.NoSuchElementException;

public class TwoWayCircularLinkedListWithSentinel<T> {
    private Node<T> sentinel;
    private int size;

    private static class Node<T> {
        T data;
        Node<T> next;
        Node<T> prev;

        public Node(T data) {
            this.data = data;
        }
    }
    public TwoWayCircularLinkedListWithSentinel() {
        sentinel = new Node<>(null);
        sentinel.next = sentinel;
        sentinel.prev = sentinel;
    }

    public void add(T data){
        Node<T> newNode = new Node<>(data);
        Node<T> last = sentinel.prev;

        newNode.prev = last;
        newNode.next = sentinel;
        last.next = newNode;
        sentinel.prev = newNode;

        size++;
    }
//  from what we covered so far, visualize any data structure that you think it would be best for my understanding
    public T remove(int index) {
        if(index <0 || index>= size ){
            throw new IndexOutOfBoundsException("Index out of bonds.");
        }

        Node<T> currentNode = sentinel.next;
        for (int i = 0; i < index; i++) {
            currentNode = currentNode.next;
        }

        T removedData = currentNode.data;
        currentNode.prev.next = currentNode.next;
        currentNode.next.prev = currentNode.prev;

        size--;

        return removedData;
    }

    public T get(int index) {
        if(index < 0 || index>= size) {
            throw new IndexOutOfBoundsException("Index out of bonds.");
        }

        Node<T> currentNode = sentinel.next;
        for (int i = 0; i < index; i++) {
            currentNode = currentNode.next;
        }
        return  currentNode.data;
    }

    public Iterator<T> iterator() {
        return new TwoWayCircularLinkedListWithSentinelIterator();
    }

    private class TwoWayCircularLinkedListWithSentinelIterator implements Iterator<T> {
        private Node<T> currentNode;

        public TwoWayCircularLinkedListWithSentinelIterator() {
            currentNode = sentinel.next;
        }

        @Override
        public boolean hasNext() {
            return currentNode != sentinel;
        }

        @Override
        public T next() {
            if (currentNode == sentinel) {
                throw new NoSuchElementException();
            }
            T data = currentNode.data;
            currentNode = currentNode.next;
            return data;
        }
    }

}

