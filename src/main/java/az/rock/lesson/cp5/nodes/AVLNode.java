package az.rock.lesson.cp5.nodes;

import java.util.function.Consumer;



public class AVLNode<T extends Comparable<T>> extends AbstractNode<T> {
    public AVLNode(T data) {
        super(data);
    }

    public AVLNode(T data,AbstractNode<T> leftChild, AbstractNode<T> rightChild) {
        super(data, leftChild, rightChild);
    }

    public AVLNode(AbstractNode<T> parent,T data,AbstractNode<T> leftChild, AbstractNode<T> rightChild) {
        super(data, leftChild, rightChild);
        this.setParent(parent);
    }

    @Override
    public Boolean isEmpty() {
        return Boolean.FALSE;
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
    public AbstractNode<T> copy() {
        return new AVLNode<>(this.parent,this.data,this.leftChild,this.rightChild);
    }
}
