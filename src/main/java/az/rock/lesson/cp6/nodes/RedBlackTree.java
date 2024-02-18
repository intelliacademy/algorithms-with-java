package az.rock.lesson.cp6.nodes;

import az.rock.lesson.cp5.nodes.Tree;

import java.util.function.BiFunction;
import java.util.function.Consumer;

public class RedBlackTree<T extends Comparable<T>> implements Tree<T> {
    private AbstractNode<T> root = NilNode.<T>getInstance();

    public RedBlackTree() {}

    @Override
    public void insert(T data) {
        if (this.root.isEmpty()){
            this.root = new BlackNode<>(data, NilNode.getRootReference(), NilNode.<T>getInstance(), NilNode.<T>getInstance());
        } else {
            this.root.insert(new RedNode<>(data, root, NilNode.<T>getInstance(), NilNode.<T>getInstance()));
        }
    }

    @Override
    public void remove(T data) {

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
