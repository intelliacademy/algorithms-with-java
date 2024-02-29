package az.rock.lesson.cp5.nodes;

import java.util.function.Consumer;

public interface Node <T extends Comparable<T>> extends Comparable<Node<T>> {
    T getData();

    AbstractNode<T> insert(T data);

    void remove(T data);

    void updateHeight();

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

    Boolean isEmpty();

    Boolean hasAnyChild();

    Boolean hasBothChildren();

    default Boolean isBalanced() {
        return Math.abs(this.getBalance()) <= 1;
    }

    default Boolean isUnbalanced() {
        return !this.isBalanced();
    }

    default Boolean isLeftHeavy() {
        return this.getBalance() > 1;
    }

    default Boolean isRightHeavy() {
        return this.getBalance() < -1;
    }

    Integer getBalance();

}
