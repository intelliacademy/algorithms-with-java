package az.rock.lesson.cp5.nodes;

import java.util.function.Consumer;

public class EmptyNode <T extends Comparable<T>> extends AbstractNode<T>{

    private static final EmptyNode EMPTY_NODE = new EmptyNode<>();

    public static < T extends Comparable<T>> EmptyNode<T> getInstance() {
        return EMPTY_NODE;
    }

    @Override
    public Integer getHeight() {
        return -1;
    }

    @Override
    public void insert(T data) {

    }

    @Override
    public void remove(T data) {

    }

    @Override
    public void traversal(Consumer<T> consumer) {

    }

    @Override
    public T getMaxValue() {
        return null;
    }

    @Override
    public T getMinValue() {
        return null;
    }

    @Override
    public Integer balance() {
        return 0;
    }

    @Override
    public void setBalance(int balance) {

    }


    @Override
    public void leftRotation() {

    }

    @Override
    public void rightRotation() {

    }


}