package az.rock.lesson.cp5.nodes;

import java.util.function.BiFunction;
import java.util.function.Consumer;

public class AVLTree<T extends Comparable<T>> implements Tree<T>{
    private AbstractNode<T> root = EmptyNode.getInstance();


    @Override
    public void insert(T data) {
        if (root.isEmpty()) {
            root = new AVLNode<>(data);
        } else {
            root.insert(root,root,data);
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
        return "AVLTree{" +
                "root=" + root +
                '}';
    }
}
