package az.rock.lesson.cp6.nodes;

import java.util.function.BiFunction;
import java.util.function.Consumer;

public class RedBlackTree<T extends Comparable<T>> implements Tree<T> {
    private AbstractNode<T> root = NilNode.NIL;

    public RedBlackTree() {}

    @Override
    public void insert(T data) {
        if (this.root.isEmpty()){
            this.root = new BlackNode<>(data, NilNode.<T>getInstance(), NilNode.<T>getInstance());
        } else {
            var result = this.root.insert(this.root,data);
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
            if (node.getLeftChild().isRightHeavy()){
                this.rotateLeft(node.getLeftChild());
            }
            this.rotateRight(node);
        } else if (node.isRightHeavy()){
            if (node.getRightChild().isLeftHeavy()){
                this.rotateRight(node.getRightChild());
            }
            this.rotateLeft(node);
        }
    }

    public void rotateLeft(AbstractNode<T> node) {
        var tempRightChild = node.getRightChild();
        var grandChildOfTempRightChild = tempRightChild.getLeftChild();
        tempRightChild.setLeftChild(node);
        node.setRightChild(grandChildOfTempRightChild);

        if (!grandChildOfTempRightChild.isEmpty()){
            grandChildOfTempRightChild.setParent(node);
        }

        var tempParent = node.getParent();
        node.setParent(tempRightChild);
        tempRightChild.setParent(tempParent);

        if(tempRightChild.getParent() != null && tempRightChild.getParent().getLeftChild() == node)
            tempRightChild.getParent().setLeftChild(tempRightChild);
        else if (tempRightChild.getParent() != null && tempRightChild.getParent().getRightChild() == node)
            tempRightChild.getParent().setRightChild(tempRightChild);

        if (node == this.root) this.root = tempRightChild;
        node.updateHeight();
        tempRightChild.updateHeight();
    }

    public void rotateRight(AbstractNode<T> node) {
        var tempLeftChild = node.getLeftChild();
        var grandChildOfTempLeftChild = tempLeftChild.getRightChild();
        tempLeftChild.setRightChild(node);
        node.setLeftChild(grandChildOfTempLeftChild);

        if (!grandChildOfTempLeftChild.isEmpty()) grandChildOfTempLeftChild.setParent(node);

        var tempParent = node.getParent();
        node.setParent(tempLeftChild);
        tempLeftChild.setParent(tempParent);

        if(tempLeftChild.getParent() != null && tempLeftChild.getParent().getLeftChild() == node)
            tempLeftChild.getParent().setLeftChild(tempLeftChild);
        else if (tempLeftChild.getParent() != null && tempLeftChild.getParent().getRightChild()  == node)
            tempLeftChild.getParent().setRightChild(tempLeftChild);

        if (node == this.root) this.root = tempLeftChild;
        node.updateHeight();
        tempLeftChild.updateHeight();
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
