package az.rock.lesson.cp5;

import java.util.function.Consumer;

public interface Node <T extends Comparable<T>>{
    void insert(T data);
    void remove(T data);
    void traversal(Consumer<T> consumer);
    T getMaxValue();
    T getMinValue();
    Boolean isLeaf();
    Boolean hasLeftChild();
    Boolean hasRightChild();

    default Boolean isEmpty() {
        return Boolean.FALSE;
    }
    Boolean hasAnyChild();
    Boolean hasBothChildren();
    void balance();
    void setBalance(int balance);
    int getBalance();
    void rotateRight();
    void rotateLeft();
}
