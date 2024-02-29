package az.rock.lesson.cp5.nodes;

import java.util.function.Consumer;

public class NillNode<T extends Comparable<T>> extends AbstractNode<T>{

    private static final NillNode EMPTY_NODE = new NillNode<>();

    public static < T extends Comparable<T>> NillNode<T> getInstance() {
        return EMPTY_NODE;
    }

    public NillNode(){
        this.height = -1;
    }

    @Override
    public Boolean isEmpty() {
        return Boolean.TRUE;
    }

    @Override
    public Integer getHeight() {
        return this.height;
    }

    @Override
    public void remove(T data) {}

    @Override
    public void traversal(Consumer<T> consumer) {}

    @Override
    public T getMaxValue() {
        return null;
    }

    @Override
    public T getMinValue() {
        return null;
    }

    @Override
    public Integer getBalance() {
        return 0;
    }


    @Override
    public AbstractNode<T> copy() {
        return this;
    }
}
