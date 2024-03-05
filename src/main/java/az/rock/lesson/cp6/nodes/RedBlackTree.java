package az.rock.lesson.cp6.nodes;

import az.rock.lesson.util.Tree;

import java.util.function.BiFunction;
import java.util.function.Consumer;

public class RedBlackTree<T extends Comparable<T>> implements Tree<T> {
    private AbstractNode<T> root = BlackNode.NilNode.NIL;

    public RedBlackTree() {}

    @Override
    public void insert(T data) {
        if (this.root.isEmpty()){
            this.root = new BlackNode<>(data);
            this.root.updateHeight();
        } else {
            var node = this.root.insert(data);
            node.updateHeight();
            this.settleViolations(node);
        }
    }

    private void settleViolations(AbstractNode<T> node) {
        while(node != null) {
            node.updateHeight();
            this.rebalancing(node);
            node = node.getParent();
        }
    }

    public void rebalancing(AbstractNode<T> node) {
        if (node.isLeftHeavy()){
            if (node.getLeftChild().isRightHeavy()){
                this.rightRotation(node.getLeftChild());
            }
            this.leftRotation(node);
        }
        if (node.isRightHeavy()){
            if (node.getRightChild().isLeftHeavy()){
                this.leftRotation(node.getRightChild());
            }
            this.rightRotation(node);
        }
    }

    public void rightRotation(AbstractNode<T> node) {
        var tempLeftChild = node.getLeftChild();
        var grandChild = tempLeftChild.getRightChild();
        tempLeftChild.setRightChild(node);
        node.setLeftChild(grandChild);
        if (grandChild != null && !grandChild.isEmpty()) {
            grandChild.setParent(node);
        }

        var tempParent = node.getParent();
        node.setParent(tempLeftChild);
        tempLeftChild.setParent(tempParent);
        if (tempLeftChild.getParent() != null && tempLeftChild.getParent().getLeftChild() == node) {
            tempLeftChild.getParent().setLeftChild(tempLeftChild);
        }

        if (tempLeftChild.getParent() != null && tempLeftChild.getParent().getRightChild() == node) {
            tempLeftChild.getParent().setRightChild(tempLeftChild);
        }

        if (node == this.root) {
            this.root = tempLeftChild;
        }

        node.updateHeight();
        tempLeftChild.updateHeight();
    }

    public void leftRotation(AbstractNode<T> node) {
        var tempRightChild = node.getRightChild();
        var grandChild = tempRightChild.getLeftChild();
        tempRightChild.setLeftChild(node);
        node.setRightChild(grandChild);
        if (grandChild != null && !grandChild.isEmpty()) {
            grandChild.setParent(node);
        }

        var tempParent = node.getParent();
        node.setParent(tempRightChild);
        tempRightChild.setParent(tempParent);
        if (tempRightChild.getParent() != null && tempRightChild.getParent().getLeftChild() == node) {
            tempRightChild.getParent().setLeftChild(tempRightChild);
        }

        if (tempRightChild.getParent() != null && tempRightChild.getParent().getRightChild() == node) {
            tempRightChild.getParent().setRightChild(tempRightChild);
        }

        if (node == this.root) {
            this.root = tempRightChild;
        }

        node.updateHeight();
        tempRightChild.updateHeight();
    }

    @Override
    public void remove(T data) {
        this.root = this.root.remove(data);
    }

    @Override
    public void traversal(Consumer<T> consumer) {
        this.root.traverseInOrder(consumer);
    }

    @Override
    public T reduce(BiFunction<T, T, T> function) {
        return this.root.reduce(function);
    }

    @Override
    public T getMaxValue() {
        return null;
    }

    @Override
    public T getMinValue() {
        return null;
    }
}
