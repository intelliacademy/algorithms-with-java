package az.rock.lesson.cp5.nodes;

import java.util.function.Consumer;



public class AVLNode<T extends Comparable<T>> extends AbstractNode<T> {

    public AVLNode(T data) {
        super(EmptyNode.getInstance(),data);
    }

    @Override
    public void insert(AbstractNode<T> root,T data) {
        var node = new AVLNode<>(data);
        if (node.isLessThan(this)) {
            if (this.leftChild.isEmpty()) {
                this.leftChild = node;
                node.setParent(this);
            } else {
                this.leftChild.insert(root,data);
            }
        } else {
            if (this.rightChild.isEmpty()) {
                this.rightChild = node;
                node.setParent(this);
            } else {
                this.rightChild.insert(root,data);
            }
        }
        this.parent.updateHeight();
        this.settleViolation();
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
    public void setBalance(int balance) {

    }



}
