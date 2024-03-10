package az.rock.lesson.cp6.nodes;

import az.rock.lesson.util.Tree;

import java.util.function.BiFunction;
import java.util.function.Consumer;

public class RedBlackTree<T extends Comparable<T>> implements Tree<T> {
    private AbstractNode<T> root = BlackNode.NilNode.getRootReference();

    public RedBlackTree() {}

    @Override
    public void insert(T data) {
        if (this.root.isEmpty()){
            this.root = new BlackNode<>(data);
            this.root.updateHeight();
        } else {
            var node = this.root.insert(data);
            node.updateHeight();
        }
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
        return this.root.getMax();
    }

    @Override
    public T getMinValue() {
        return this.root.getMin();
    }
}
