package az.rock.lesson.cp5;

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
    public void balance() {

    }

    @Override
    public void setBalance(int balance) {

    }

    @Override
    public int getBalance() {
        return 0;
    }

    @Override
    public void rotateRight() {

    }

    @Override
    public void rotateLeft() {

    }
}
