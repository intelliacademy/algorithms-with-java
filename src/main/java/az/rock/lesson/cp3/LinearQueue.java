package az.rock.lesson.cp3;

import java.util.Collection;
import java.util.Iterator;
import java.util.Queue;
import java.util.concurrent.atomic.AtomicInteger;

public class LinearQueue<D extends Comparable<D> > implements Queue<D > {
    private QueueChain<D> head;
    private QueueChain<D> tail;

    private final AtomicInteger size = new AtomicInteger(0);

    private void incrementSize(){
        this.size.incrementAndGet();
    }

    private void decrementSize(){
        this.size.decrementAndGet();
    }

    private boolean hasOnlyOneItem(){
        return this.tail.equals(this.head);
    }

    @Override
    public int size() {
        return this.size.get();
    }

    @Override
    public boolean isEmpty() {
        return this.size() == 0;
    }

    @Override
    public boolean contains(Object o) {
        return false;
    }

    @Override
    public Iterator<D> iterator() {
        return null;
    }

    @Override
    public Object[] toArray() {
        return new Object[0];
    }

    @Override
    public <T> T[] toArray(T[] a) {
        return null;
    }

    @Override
    public boolean add(D d) {
        return false;
    }

    @Override
    public boolean remove(Object o) {
        return false;
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        return false;
    }

    @Override
    public boolean addAll(Collection<? extends D> c) {
        return false;
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        return false;
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        return false;
    }

    @Override
    public void clear() {

    }

    @Override
    public boolean offer(D d) {
        return false;
    }

    @Override
    public D remove() {
        return null;
    }

    @Override
    public D poll() {
        return null;
    }

    @Override
    public D element() {
        return null;
    }

    @Override
    public D peek() {
        return null;
    }
}
