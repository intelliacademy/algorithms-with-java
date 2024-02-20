package az.rock.lesson.cp5.nodes;

import java.util.function.BiFunction;
import java.util.function.Consumer;

public class AVLTree<T extends Comparable<T>> implements Tree<T>{
    private AbstractNode<T> root = NillNode.getInstance();

    @Override
    public void insert(T data) {
        if (root.isEmpty()) {
            root = new AVLNode<>(data);
        } else {
            var result = root.insert(root,data);
            result.updateHeight();
            this.settleViolations(result);
        }
    }

    private void settleViolations(AbstractNode<T> node) {
        while(node != null) {
            node.updateHeight();
            this.settleViolation(node);
            node = node.getParent();
        }
    }

    public void settleViolation(AbstractNode<T> node) {
        node.updateHeight();
        if (node.isLeftHeavy()){
            if (node.leftChild.isRightHeavy()){
                rotateLeft(node.leftChild);
            }
            this.rotateRight(node);
        } else if (node.isRightHeavy()){
            if (node.rightChild.isLeftHeavy()){
                rotateRight(node.rightChild);
            }
            this.rotateLeft(node);
        }
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


    public void rotateLeft(AbstractNode<T> node) {
        var tempRightChild = node.getRightChild();
        var grandChildOfTempRightChild = tempRightChild.leftChild;
        tempRightChild.setLeftChild(node);
        node.setRightChild(grandChildOfTempRightChild);

        if (!grandChildOfTempRightChild.isEmpty()){
            grandChildOfTempRightChild.setParent(node);
        }

        var tempParent = node.parent;
        node.setParent(tempRightChild);
        tempRightChild.setParent(tempParent);

        if(!tempRightChild.getParent().isEmpty() && tempRightChild.getParent().getLeftChild() == node){
            tempRightChild.getParent().leftChild = tempRightChild;
        } else if (!tempRightChild.getParent().isEmpty() && tempRightChild.getParent().getRightChild() == (node)){
            tempRightChild.getParent().rightChild = tempRightChild;
        }

        if (node.equals(this.root)){
            this.root = tempRightChild;
        }

        node.updateHeight();
        tempRightChild.updateHeight();
    }

    public void rotateRight(AbstractNode<T> node) {
        var tempLeftChild = node.leftChild;
        var grandChildOfTempLeftChild = tempLeftChild.rightChild;
        tempLeftChild.rightChild = node;
        node.leftChild = grandChildOfTempLeftChild;

        if (!grandChildOfTempLeftChild.isEmpty()){
            grandChildOfTempLeftChild.setParent(node);
        }

        var tempParent = node.parent;
        node.setParent(tempLeftChild);
        tempLeftChild.setParent(tempParent);

        if(!tempLeftChild.getParent().isEmpty() && tempLeftChild.getParent().getLeftChild() == node){
            tempLeftChild.getParent().leftChild = tempLeftChild;
        } else if (!tempLeftChild.getParent().isEmpty() && tempLeftChild.getParent().getRightChild()  == node){
            tempLeftChild.getParent().rightChild = tempLeftChild;
        }

        if (node == this.root){
            this.root = tempLeftChild;
        }

        node.updateHeight();
        tempLeftChild.updateHeight();
    }






    @Override
    public String toString() {
        return "AVLTree{" +
                "root=" + root +
                '}';
    }
}
