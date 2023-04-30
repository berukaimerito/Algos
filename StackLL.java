import java.util.Iterator;
import java.util.LinkedList;
import java.util.NoSuchElementException;

public class StackLL<T> implements Iterable<T> {
   private LinkedList<T> list = new LinkedList<>();

   public void push(T value) {
      list.addLast(value);
   }

   public T peek() {
       if(isEmpty()) {
           throw new NoSuchElementException("Stack is empty.");
       }
       return list.getLast();
   }

   public boolean isEmpty() {
       return list.isEmpty();
   }

   public int size() {
       return list.size();
   }

   @Override
   public Iterator<T> iterator() {
       return new StackIterator();
   }

   private class StackIterator implements Iterator<T> {
       private int index = list.size() -1;

       @Override
       public boolean hasNext() {
           return index >= 0;
       }

       public T next() {
           if(!hasNext()) {
               throw new NoSuchElementException();
           }
           return list.get(index--);
       }
   }
}