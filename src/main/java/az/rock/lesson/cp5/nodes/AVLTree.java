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
            var result = root.insert(data);
            result.updateHeight();
            this.reBalance(result);
        }
    }

    private void reBalance(AbstractNode<T> node) {
        while(node != null) {
            node.updateHeight();
            this.reBalancing(node);
            node = node.getParent();
        }
    }

    public void reBalancing(AbstractNode<T> node) {
        if (node.isLeftHeavy()){
            if (node.leftChild.isRightHeavy()){
                this.rotateLeft(node.leftChild);
            }
            this.rotateRight(node);
        } else if (node.isRightHeavy()){
            if (node.rightChild.isLeftHeavy()){
                this.rotateRight(node.rightChild);
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
        System.out.println("rotate left");
        var tempRightChild = node.getRightChild();
        var grandChildOfTempRightChild = tempRightChild.getLeftChild();
        tempRightChild.setLeftChild(node);
        node.setRightChild(grandChildOfTempRightChild);

        if (grandChildOfTempRightChild !=null && !grandChildOfTempRightChild.isEmpty()){
            grandChildOfTempRightChild.setParent(node);
        }

        var tempParent = node.getParent();
        node.setParent(tempRightChild);
        tempRightChild.setParent(tempParent);

        if(tempRightChild.getParent() != null && tempRightChild.getParent().getLeftChild() == node){
            tempRightChild.getParent().setLeftChild(tempRightChild);
        } else if (tempRightChild.getParent() != null  && tempRightChild.getParent().getRightChild() == node){
            tempRightChild.getParent().setRightChild(tempRightChild);
        }

        if (node == this.root){
            this.root = tempRightChild;
        }

        node.updateHeight();
        tempRightChild.updateHeight();
    }

    public void rotateRight(AbstractNode<T> node) {
        System.out.println("rotate right");
        var tempLeftChild = node.getLeftChild();
        var grandChildOfTempLeftChild = tempLeftChild.getRightChild();
        tempLeftChild.setRightChild(node);
        node.setLeftChild(grandChildOfTempLeftChild);

        if (grandChildOfTempLeftChild != null && !grandChildOfTempLeftChild.isEmpty()){
            grandChildOfTempLeftChild.setParent(node);
        }

        var tempParent = node.getParent();
        node.setParent(tempLeftChild);
        tempLeftChild.setParent(tempParent);

        if(tempLeftChild.getParent() != null && tempLeftChild.getParent().getLeftChild() == node){
            tempLeftChild.getParent().setLeftChild(tempLeftChild);
        } else if (tempLeftChild.getParent() != null  && tempLeftChild.getParent().getRightChild()  == node){
            tempLeftChild.getParent().setRightChild(tempLeftChild);
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
