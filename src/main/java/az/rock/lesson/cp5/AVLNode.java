package az.rock.lesson.cp5;

public class AVLNode<T extends Comparable<T>> implements Node<T>{
    public T data;
    public AVLNode<T> left;
    public AVLNode<T> right;
    public int height;

    public AVLNode(T data) {
        this.data = data;
        this.height = 0;
    }


    @Override
    public void insert(T data) {
        var node = new AVLNode<>(data);
        if (data.compareTo(this.data) < 0) {
            if (left == null) {
                left = node;
            } else {
                left.insert(data);
            }
        } else {
            if (right == null) {
                right = node;
            } else {
                right.insert(data);
            }
        }
    }

    @Override
    public void remove(T data) {
        if (data.compareTo(this.data) < 0) {
            if (left != null) {
                left.remove(data);
            }
        } else if (data.compareTo(this.data) > 0) {
            if (right != null) {
                right.remove(data);
            }
        } else {
            if (this.isLeaf()) {
                this.data = null;
            } else if (this.hasLeftChild()) {
                var predecessor = left.getMaxValue();
                this.data = predecessor;
                left.remove(predecessor);
            } else {
                var successor = right.getMinValue();
                this.data = successor;
                right.remove(successor);
            }
        }
    }

    @Override
    public void traversal() {
        if (left != null) {
            left.traversal();
        }
        System.out.println(data);
        if (right != null) {
            right.traversal();
        }
    }

    @Override
    public T getMaxValue() {
        if (right == null) {
            return data;
        } else {
            return right.getMaxValue();
        }
    }

    @Override
    public T getMinValue() {
        if (left == null) {
            return data;
        } else {
            return left.getMinValue();
        }
    }

    @Override
    public Boolean isLeaf() {
        return !hasAnyChild();
    }

    @Override
    public Boolean hasLeftChild() {
        return this.left != null;
    }

    @Override
    public Boolean hasRightChild() {
        return this.right != null;
    }

    @Override
    public Boolean hasAnyChild() {
        return this.hasRightChild() || this.hasLeftChild();
    }

    @Override
    public Boolean hasBothChildren() {
        return this.hasRightChild() && this.hasLeftChild();
    }

    @Override
    public void balance() {
        if (this.right.height > this.left.height) {
            if (this.right.right.height > this.right.left.height) {
                this.rotateLeft();
            } else {
                this.right.rotateRight();
                this.rotateLeft();
            }
        } else {
            if (this.left.left.height > this.left.right.height) {
                this.rotateRight();
            } else {
                this.left.rotateLeft();
                this.rotateRight();
            }
        }
    }

    @Override
    public void setBalance(int balance) {
        this.height = balance;
    }

    @Override
    public int getBalance() {
        return this.height;
    }

    @Override
    public void rotateRight() {

    }

    @Override
    public void rotateLeft() {

    }
}
