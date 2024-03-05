package az.rock.lesson.cp5.nodes;

import az.rock.lesson.util.Tree;

import java.util.function.BiFunction;
import java.util.function.Consumer;

public class AVLTree <T extends Comparable<T>> implements Tree<T> {

    private AVLNode<T> root = AVLNode.Nil.<T>getInstance();

    @Override
    public void insert(T data) {
        if (this.root.isEmpty()){
            this.root = new AVLNode<>(data);
            this.root.updateHeight();
        }else {
            var node = this.root.insert(data);
            node.updateHeight();
            while (node != null){
                node.updateHeight();
                this.rebalance(node);
                node = node.getParent();
            }
        }
    }

    public void rebalance(AVLNode<T> node){
        if (node.isLeftHeavy()){
            if (node.getLeft().isRightHeavy()) {
                this.leftRotation(node.getLeft());
            }
            this.rightRotation(node);
        }
        if (node.isRightHeavy()){
            if (node.getRight().isLeftHeavy()) this.rightRotation(node.getRight());
            this.leftRotation(node);
        }
    }

    public void rightRotation(AVLNode<T> node){
        var tempLeftChild = node.getLeft();
        var grandChild = tempLeftChild.getRight();
        tempLeftChild.setRight(node);
        node.setLeft(grandChild);
        if (grandChild != null && !grandChild.isEmpty()) {
            grandChild.setParent(node);
        }

        var tempParent = node.getParent();
        node.setParent(tempLeftChild);
        tempLeftChild.setParent(tempParent);
        if (tempLeftChild.getParent() != null && tempLeftChild.getParent().getLeft() == node) {
            tempLeftChild.getParent().setLeft(tempLeftChild);
        }

        if (tempLeftChild.getParent() != null && tempLeftChild.getParent().getRight() == node) {
            tempLeftChild.getParent().setRight(tempLeftChild);
        }

        if (node == this.root) {
            this.root = tempLeftChild;
        }

        node.updateHeight();
        tempLeftChild.updateHeight();
    }

    public void leftRotation(AVLNode<T> node){
        var tempRightChild = node.getRight();
        var grandChild = tempRightChild.getLeft();
        tempRightChild.setLeft(node);
        node.setRight(grandChild);
        if (grandChild != null && !grandChild.isEmpty()) {
            grandChild.setParent(node);
        }

        var tempParent = node.getParent();
        node.setParent(tempRightChild);
        tempRightChild.setParent(tempParent);
        if (tempRightChild.getParent() != null && tempRightChild.getParent().getLeft() == node) {
            tempRightChild.getParent().setLeft(tempRightChild);
        }

        if (tempRightChild.getParent() != null && tempRightChild.getParent().getRight() == node) {
            tempRightChild.getParent().setRight(tempRightChild);
        }

        if (node == this.root) {
            this.root = tempRightChild;
        }

        node.updateHeight();
        tempRightChild.updateHeight();
    }


    @Override
    public void remove(T data) {

    }

    @Override
    public void traversal(Consumer<T> consumer) {

    }

    @Override
    public T reduce(BiFunction<T, T, T> function) {
        return null;
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
    public String toString() {
        return root.toString();
    }
}
