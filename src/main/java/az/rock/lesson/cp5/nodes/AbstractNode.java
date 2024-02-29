package az.rock.lesson.cp5.nodes;

import az.rock.lesson.util.Cloneable;

import java.util.Objects;

/**
 * height = 1 + max(left.height, right.height)
 * <br>
 * leaf node height = 0
 * empty node height = -1
 * <br>
 * balance factor = |left.height - right.height|
 * <br>
 * if only left.height greater than 0 then left heavy (positive balance factor)
 * else if onlyright.height greater than 0 then right heavy (negative balance factor)
 * else balanced
 * <br>
 * is balanced = |left.height - right.height| <= 1
 * <br>
 * When tree is right heavy then we need to rotate left
 * else when tree is left heavy then we need to rotate right
 */

public abstract class AbstractNode <T extends Comparable<T>> implements Node<T>, Cloneable<AbstractNode<T>> {

    protected T data;
    protected AbstractNode<T> parent;
    protected AbstractNode<T> leftChild;
    protected AbstractNode<T> rightChild;
    protected int height;

    public AbstractNode() {
        this.height = -1;
    }


    public AbstractNode(T data) {
        this(data, NillNode.getInstance(), NillNode.getInstance());
    }


    public AbstractNode(T data, AbstractNode<T> leftChild, AbstractNode<T> rightChild) {
        this();
        this.data = data;
        this.parent = null;
        this.leftChild = leftChild;
        this.rightChild = rightChild;
    }

    public void setLeftChild(AbstractNode<T> leftChild) {
        this.leftChild = leftChild;
    }

    public void setRightChild(AbstractNode<T> rightChild) {
        this.rightChild = rightChild;
    }

    @Override
    public AbstractNode<T> insert(T data) {
        var node = new AVLNode<>(data);
        if (node.isLessThan(this)) {
            if (this.leftChild.isEmpty()) {
                this.leftChild = node;
                node.setParent(this);
                return node;
            } else {
                return this.leftChild.insert(data);
            }
        } else {
            if (this.rightChild.isEmpty()) {
                this.rightChild = node;
                node.setParent(this);
                return node;
            } else {
                return this.rightChild.insert(data);
            }
        }
    }

    @Override
    public String toString() {
        return "AbstractNode{" +
                "data=" + data +
                ", leftChild=" + leftChild +
                ", rightChild=" + rightChild +
                ", height=" + height +
                "\n}";
    }


    @Override
    public Integer getBalance() {
        return this.leftChild.getHeight() - this.rightChild.getHeight();
    }


    @Override
    public int hashCode() {
        return Objects.hash(getData(), getParent(), getLeftChild(), getRightChild(), getHeight());
    }

    public void setParent(AbstractNode<T> parent) {
        this.parent = parent;
    }

    @Override
    public int compareTo(Node<T> o) {
        return this.data.compareTo(o.getData());
    }

    public Integer getHeight() {
        return this.height;
    }

    @Override
    public void updateHeight() {
        this.height = 1 + Math.max(this.leftChild.getHeight(), this.rightChild.getHeight());
    }

    @Override
    public Boolean isBalanced() {
        return Math.abs(this.leftChild.getHeight() - this.rightChild.getHeight()) <= 1;
    }

    @Override
    public Boolean isLeaf() {
        return this.leftChild == null && this.rightChild == null;
    }

    @Override
    public Boolean hasLeftChild() {
        return this.leftChild != null;
    }

    @Override
    public Boolean hasRightChild() {
        return this.rightChild != null;
    }

    @Override
    public Boolean hasAnyChild() {
        return this.leftChild != null || this.rightChild != null;
    }

    @Override
    public Boolean hasBothChildren() {
        return this.leftChild != null && this.rightChild != null;
    }


    @Override
    public T getData() {
        return data;
    }

    public AbstractNode<T> getParent() {
        return parent;
    }

    public AbstractNode<T> getLeftChild() {
        return leftChild;
    }

    public AbstractNode<T> getRightChild() {
        return rightChild;
    }


}
