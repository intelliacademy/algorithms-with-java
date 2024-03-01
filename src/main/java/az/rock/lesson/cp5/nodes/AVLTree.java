package az.rock.lesson.cp5.nodes;

import az.rock.lesson.cp6.nodes.Tree;

import java.util.function.BiFunction;
import java.util.function.Consumer;

public class AVLTree <T extends Comparable<T>> implements Tree<T> {

    private AVLNode<T> root = AVLNode.Nil.<T>getInstance();

    @Override
    public void insert(T data) {
        if (this.root.isEmpty()){
            this.root = new AVLNode<>(data);
        }else {
            var node = this.root.insert(data);
            while (node != null){
                rebalance(node);
                node = node.getParent();
            }
        }
    }


    public void rebalance(AVLNode<T> node){
        if (node.isLeftHeavy()){
            if (node.getLeft().isRightHeavy()){
                node.setLeft(node.getLeft().rotateLeft());
            }
            this.root = node.rotateRight();
        }else if (node.isRightHeavy()){
            if (node.getRight().getBalanceFactor() > 0){
                node.setRight(node.getRight().rotateRight());
            }
            this.root = node.rotateLeft();
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

    @Override
    public String toString() {
        return root.toString();
    }
}
