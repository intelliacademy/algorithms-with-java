package az.rock.lesson.cp5;

import java.util.function.Consumer;

public class AVLNode<T extends Comparable<T>> implements Node<T>{
    public T data;
    public AVLNode<T> parent;

    public AVLNode<T> left;
    public AVLNode<T> right;
    public int height;

    public AVLNode(T data) {
        this(data, null);
    }

    public AVLNode(T data, AVLNode<T> parent) {
        this.data = data;
        this.parent = parent;
        this.height = 0;
        this.left = EmptyNode.EMPTY_NODE;
        this.right = EmptyNode.EMPTY_NODE;
    }

    public int getHeight() {
        return height;
    }

    @Override
    public void insert(T data) {
        if (data.compareTo(this.data) < 0) {
            if (!this.hasLeftChild()) {
                this.left = new AVLNode<>(data, this);
            } else {
                this.left.insert(data);
            }
        } else {
            if (!this.hasRightChild()) {
                this.right = new AVLNode<>(data,this);
            } else {
                this.right.insert(data);
            }
        }
    }

    @Override
    public void remove(T data) {
        if (data.compareTo(this.data) < 0) {
            if (this.hasLeftChild()) {
                this.left.remove(data);
            }
        } else if (data.compareTo(this.data) > 0) {
            if (this.hasRightChild()) {
                this.right.remove(data);
            }
        } else {
            if (this.left != null && this.right != null) {
                this.data = this.right.getMinValue();
                this.right.remove(this.data);
            } else if (this.parent == null) {
                if (this.left != null) {
                    this.data = this.left.data;
                    this.right = this.left.right;
                    this.left = this.left.left;
                } else if (this.right != null) {
                    this.data = this.right.data;
                    this.left = this.right.left;
                    this.right = this.right.right;
                } else {
                    this.data = null;
                }
            } else if (this.parent.left == this) {
                this.parent.left = this.left != null ? this.left : this.right;
            } else if (this.parent.right == this) {
                this.parent.right = this.left != null ? this.left : this.right;
            }
        }
    }

    @Override
    public void traversal(Consumer<T> consumer){
        if (!this.left.isEmpty()) {
            this.left.traversal(consumer);
        }
        consumer.accept(this.data);
        if (!this.right.isEmpty()) {
            this.right.traversal(consumer);
        }
    }

    @Override
    public T getMaxValue() {
        if (this.right.isEmpty()) {
            return this.data;
        } else {
            return this.right.getMaxValue();
        }
    }

    @Override
    public T getMinValue() {
        if (this.left.isEmpty()) {
            return this.data;
        } else {
            return this.left.getMinValue();
        }
    }

    @Override
    public Boolean isLeaf() {
        return !this.hasLeftChild() &&! this.hasRightChild();
    }

    @Override
    public Boolean hasLeftChild() {
        return !(this.left instanceof EmptyNode);
    }

    @Override
    public Boolean hasRightChild() {
        return !(this.right instanceof EmptyNode);
    }

    @Override
    public Boolean hasAnyChild() {
        return this.hasLeftChild() || this.hasRightChild();
    }

    @Override
    public Boolean hasBothChildren() {
        return !this.isLeaf();
    }

    @Override
    public void balance() {

    }

    @Override
    public void setBalance(int balance) {

    }

    @Override
    public int getBalance() {
        return 0;
    }

    @Override
    public void rotateRight() {

    }

    @Override
    public void rotateLeft() {

    }
}
