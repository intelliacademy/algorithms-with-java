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
    protected AbstractNode<T> root;

    protected T data;
    protected AbstractNode<T> parent;
    protected AbstractNode<T> leftChild;
    protected AbstractNode<T> rightChild;
    protected int height;

    public AbstractNode() {
        this.height = -1;
    }


    public AbstractNode(AbstractNode<T> root,T data) {
        this(root,data, EmptyNode.getInstance(), EmptyNode.getInstance(), EmptyNode.getInstance());
    }

    public AbstractNode(AbstractNode<T> root,T data, AbstractNode<T> parent) {
        this(root,data, parent, EmptyNode.getInstance(), EmptyNode.getInstance());
    }

    public AbstractNode(AbstractNode<T> root,T data, AbstractNode<T> parent,AbstractNode<T> leftChild, AbstractNode<T> rightChild) {
        this();
        this.root = root;
        this.data = data;
        this.parent = parent;
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
    public AbstractNode<T> insert(AbstractNode<T> parent, T data) {
        var node = new AVLNode<>(data);
        if (node.isLessThan(this)) {
            if (this.leftChild.isEmpty()) {
                this.leftChild = node;
                node.setParent(this);
                return this;
            } else {
                return this.leftChild.insert(this,data);
            }
        } else {
            if (this.rightChild.isEmpty()) {
                this.rightChild = node;
                node.setParent(this);
                return this;
            } else {
                return this.rightChild.insert(this,data);
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
    public void setBalance(int balance) {

    }


    @Override
    public Integer getBalance() {
        return this.leftChild.getHeight() - this.rightChild.getHeight();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof AbstractNode<?> that)) return false;
        return Objects.equals(getHeight(), that.getHeight()) && Objects.equals(root, that.root) && Objects.equals(getData(), that.getData()) && Objects.equals(getParent(), that.getParent()) && Objects.equals(getLeftChild(), that.getLeftChild()) && Objects.equals(getRightChild(), that.getRightChild());
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
        return height;
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
