package az.rock.lesson.cp5.nodes;

import java.util.function.Consumer;

public interface Node <T extends Comparable<T>> extends Comparable<Node<T>>{
    T getData();
    void insert(T data);
    void remove(T data);

    default Boolean isGreaterThan(AbstractNode<T> that) {
        return this.compareTo(that) > 0;
    }

    default Boolean isLessThan(AbstractNode<T> that) {
        return this.compareTo(that) < 0;
    }

    default Boolean isEqualTo(AbstractNode<T> that) {
        return this.compareTo(that) == 0;
    }

    default Boolean isLessOrEqualsThan(AbstractNode<T> that) {
        return this.isLessThan(that) || this.isEqualTo(that);
    }


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

    public Boolean isBalanced();
    void balance();
    void setBalance(int balance);
    int getBalance();
    void rotateRight();
    void rotateLeft();
}
