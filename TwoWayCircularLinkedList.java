import java.util.Iterator;
import java.util.NoSuchElementException;

public class TwoWayCircularLinkedList<T> implements Iterable<T> {
    private Node<T> head;
    private int size;

    private static class Node<T> {
        T data;
        Node<T> next;
        Node<T> prev;

        public Node(T data) {
            this.data = data;
        }
    }

    public TwoWayCircularLinkedList() {
        head = null;
        size = 0;
    }


    public void add(T data) {
        Node<T> newNode = new Node<>(data);

        if(head==null) {
            head = newNode;
            head.next = head;
            head.prev = head;
        } else {
            Node<T> last = head.prev;
            newNode.prev = last;
            newNode.next = head;
            last.next = newNode;
            head.prev = newNode;
        }
        size++;
    }
    @Override
    public Iterator<T> iterator() {
        return new TwoWayCircularLinkedListIterator();
    }

    private class TwoWayCircularLinkedListIterator implements Iterator<T> {
        private Node<T> currentNode;

        public TwoWayCircularLinkedListIterator() {
            currentNode = head;
        }
        @Override
        public boolean hasNext() {
            return currentNode != null && (currentNode.next != head);
        }

        @Override
        public T next() {
            if (currentNode == null) {
                throw new NoSuchElementException();
            }
            T data = currentNode.data;
            currentNode = currentNode.next;
            return data;
        }
    }
}