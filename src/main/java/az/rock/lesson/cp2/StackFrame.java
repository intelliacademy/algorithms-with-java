package az.rock.lesson.cp2;

import java.util.Objects;
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

    public void previous(Consumer<D> consumer){
        consumer.accept(this.data);
        if (this.tail != null) this.tail.previous(consumer);
    }

    @Override
    public String toString() {
        var current = Objects.requireNonNullElse(this.data.toString(),"");
        if (this.tail != null)
            return current.concat(" , ").concat(this.tail.toString());
        else return current;
    }
}
