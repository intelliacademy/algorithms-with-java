package az.rock.lesson.cp5.nodes;

import java.util.function.Consumer;

public class AVLTree<T extends Comparable<T>> implements Tree<T>{
    private AbstractNode<T> root = EmptyNode.getInstance();


    @Override
    public void insert(T data) {
        if (root.isEmpty()) {
            root = new AVLNode<>(data);
        } else {
            root.insert(data);
        }
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
