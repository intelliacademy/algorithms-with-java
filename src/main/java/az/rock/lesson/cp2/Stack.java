package az.rock.lesson.cp2;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.Consumer;

public class Stack <D extends Comparable<D>>{
    private StackFrame<D> head;

    private final AtomicInteger size = new AtomicInteger(0);

    public int size(){
        return this.size.get();
    }

    public boolean isEmpty(){
        return this.size() == 0;
    }

    private void incrementSize(){
        this.size.incrementAndGet();
    }

    private void decrementSize(){
        this.size.decrementAndGet();
    }

    public  D pop(){
        if (this.head != null){
            var headData = this.head.getData();
            this.head  = this.head.getTail();
            this.decrementSize();
            return headData;
        }else return null;
    }

    public void push(D data){
        this.head = new StackFrame<>(data, this.head);
        this.incrementSize();
    }

    public D peek(){
        return this.head.getData();
    }

    public void forEach(Consumer<D> consumer){
        this.head.previous(consumer);
    }

    @Override
    public String toString() {
        if (this.head != null) return this.head.toString();
        else return "";
    }
}
