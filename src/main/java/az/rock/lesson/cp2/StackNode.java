package az.rock.lesson.cp2;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.Consumer;

public class StackNode<D> {
    private D data;

    private StackNode<D> tail;

    public StackNode(D data){
        this.data = data;
        this.tail = null;
    }

    public StackNode(D data,StackNode<D> tail){
        this.data = data;
        this.tail = tail;
    }

    public D getData() {
        return data;
    }

    public StackNode<D> getTail() {
        return tail;
    }

    public void iterate(Consumer<D> consumer){
        consumer.accept(this.data);
        if (this.tail != null) this.tail.iterate(consumer);
    }
}
