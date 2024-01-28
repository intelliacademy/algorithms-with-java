package az.rock.lesson.cp6.nodes;

import az.rock.lesson.cp5.nodes.Tree;

import java.util.function.Consumer;

public class RedBlackTree<T extends Comparable<T>> implements Tree<T> {
    private RootNode<T> root;

    public RedBlackTree() {}

    @Override
    public void insert(T data) {

    }

    @Override
    public void remove(T data) {

    }

    @Override
    public void traversal(Consumer<T> consumer) {

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
