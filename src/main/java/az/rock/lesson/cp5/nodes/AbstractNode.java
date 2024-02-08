package az.rock.lesson.cp5.nodes;

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

public abstract class AbstractNode <T extends Comparable<T>> implements Node<T>{
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

    @Override
    public String toString() {
        return "AbstractNode{" +
                "data=" + data +
                ", leftChild=" + leftChild +
                ", rightChild=" + rightChild +
                '}';
    }

    @Override
    public void leftRotation() {
        var tempRightChild = this.rightChild;//E
        this.rightChild = tempRightChild.leftChild;//
        tempRightChild.leftChild.setParent(this);
        tempRightChild.setParent(this.parent);

        var tempParent = this.parent;
        this.parent = tempRightChild;
        tempRightChild.leftChild = tempParent;
        if (tempRightChild.getParent().getLeftChild() == this) {
            tempRightChild.getParent().leftChild = tempRightChild;
        } else if (tempRightChild.getParent().getRightChild() == this) {
            tempRightChild.getParent().rightChild = tempRightChild;
        }
        if (this.root.isEmpty()){
            this.root = tempRightChild;
        }

        this.updateHeight();
        tempRightChild.updateHeight();
    }

    @Override
    public void rightRotation() {
        var tempLeftChild = this.leftChild;
        this.leftChild = tempLeftChild.rightChild;
        tempLeftChild.rightChild.setParent(this);
        tempLeftChild.setParent(this.parent);

        var tempParent = this.parent;
        this.parent = tempLeftChild;
        tempLeftChild.rightChild = tempParent;
        if (tempLeftChild.getParent().getRightChild() == this) {
            tempLeftChild.getParent().rightChild = tempLeftChild;
        } else if (tempLeftChild.getParent().getLeftChild() == this) {
            tempLeftChild.getParent().leftChild = tempLeftChild;
        }
        if (this.root.isEmpty()){
            this.root = tempLeftChild;
        }

        this.updateHeight();
        tempLeftChild.updateHeight();
    }

    @Override
    public void settleViolation() {
        this.updateHeight();
        if (this.isLeftHeavy()){
            if (this.leftChild.isRightHeavy()){
                this.leftChild.leftRotation();
            }
            this.rightRotation();
        } else if (this.isRightHeavy()){
            if (this.rightChild.isLeftHeavy()){
                this.rightChild.rightRotation();
            }
            this.leftRotation();
        }
    }

    @Override
    public Integer getBalance() {
        return this.leftChild.getHeight() - this.rightChild.getHeight();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof AbstractNode<?> that)) return false;
        return this.data.equals(that.data);
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
