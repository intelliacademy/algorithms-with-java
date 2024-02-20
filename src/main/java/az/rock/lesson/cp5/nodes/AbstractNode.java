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


    @Override
    public void insert(AbstractNode<T> root,AbstractNode<T> parent,T data) {
        this.root = root;
        var node = new AVLNode<>(data);
        if (node.isLessThan(this)) {
            if (this.leftChild.isEmpty()) {
                this.leftChild = node;
                node.setParent(this);
            } else {
                this.leftChild.insert(root,this,data);
            }
        } else {
            if (this.rightChild.isEmpty()) {
                this.rightChild = node;
                node.setParent(this);
            } else {
                this.rightChild.insert(root,this,data);
            }
        }
        this.parent.updateHeight();
        this.settleViolation();
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
    public void rotateLeft() {
        var tempRightChild = this.rightChild;
        var grandChildOfTempRightChild = tempRightChild.leftChild;
        tempRightChild.leftChild = this;
        this.rightChild = grandChildOfTempRightChild;

        if (!grandChildOfTempRightChild.isEmpty()){
            grandChildOfTempRightChild.setParent(this);
        }

        var tempParent = this.parent;
        this.setParent(tempRightChild);
        tempRightChild.setParent(tempParent);

        if(!tempRightChild.getParent().isEmpty() && tempRightChild.getParent().getLeftChild().equals(this)){
            tempRightChild.getParent().leftChild = tempRightChild;
        } else if (!tempRightChild.getParent().isEmpty() && tempRightChild.getParent().getRightChild().equals(this)){
            tempRightChild.getParent().rightChild = tempRightChild;
        }

        if (this.equals(this.root)){
            this.root = tempRightChild;
        }

        this.updateHeight();
        tempRightChild.updateHeight();
    }

    @Override
    public void rotateRight() {
        var tempLeftChild = this.leftChild;
        var grandChildOfTempLeftChild = tempLeftChild.rightChild;
        tempLeftChild.rightChild = this;
        this.leftChild = grandChildOfTempLeftChild;

        if (!grandChildOfTempLeftChild.isEmpty()){
            grandChildOfTempLeftChild.setParent(this);
        }

        var tempParent = this.parent;
        this.setParent(tempLeftChild);
        tempLeftChild.setParent(tempParent);

        if(!tempLeftChild.getParent().isEmpty() && tempLeftChild.getParent().getLeftChild().equals(this)){
            tempLeftChild.getParent().leftChild = tempLeftChild;
        } else if (!tempLeftChild.getParent().isEmpty() && tempLeftChild.getParent().getRightChild().equals(this)){
            tempLeftChild.getParent().rightChild = tempLeftChild;
        }

        if (this.equals(this.root)){
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
                this.leftChild.rotateLeft();
            }
            this.rotateRight();
        } else if (this.isRightHeavy()){
            if (this.rightChild.isLeftHeavy()){
                this.rightChild.rotateRight();
            }
            this.rotateLeft();
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
