package az.rock.lesson.cp5.nodes;

import java.util.function.Consumer;



public class AVLNode<T extends Comparable<T>> extends AbstractNode<T> {

    public AVLNode(T data) {
        super(EmptyNode.getInstance(),data);
    }

    public AVLNode(AbstractNode<T> root,T data) {
        super(root,data);
    }

    public AVLNode(AbstractNode<T> root,T data, AbstractNode<T> parent) {
        super(root,data, parent);
    }

    public AVLNode(AbstractNode<T> root,T data, AbstractNode<T> parent,AbstractNode<T> leftChild, AbstractNode<T> rightChild) {
        super(root,data, parent, leftChild, rightChild);
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
    public AbstractNode<T> copy() {
        return new AVLNode<>(this.root,this.data,this.parent,this.leftChild,this.rightChild);
    }
}
