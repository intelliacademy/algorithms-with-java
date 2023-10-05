package az.rock.lesson.cp2;

import java.util.function.Consumer;

public class StackFrame<D> {
    private D data;

    private StackFrame<D> tail;

    public StackFrame(D data){
        this(data,null);
    }

    public StackFrame(D data, StackFrame<D> tail){
        this.data = data;
        this.tail = tail;
    }

    public D getData() {
        return data;
    }

    public StackFrame<D> getTail() {
        return tail;
    }

    public void iterate(Consumer<D> consumer){
        consumer.accept(this.data);
        if (this.tail != null) this.tail.iterate(consumer);
    }
}
