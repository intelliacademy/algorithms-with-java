package az.rock.lesson.cp5;

import java.util.function.Consumer;

public class AVLTree<T extends Comparable<T>> implements Tree<T> {
    private AVLNode<T> root;


    @Override
    public void insert(T data) {
        var node = new AVLNode<>(data);
        if (root == null) {
            root = node;
        } else {
            root.insert(data);
        }
    }

    @Override
    public void remove(T data) {
        if (root != null) {
            root.remove(data);
        }
    }

    @Override
    public void traversal(Consumer<T> consumer) {
        this.root.traversal(consumer);
    }

    @Override
    public T getMaxValue() {
        return this.root.getMaxValue();
    }

    @Override
    public T getMinValue() {
        return this.root.getMinValue();
    }
}
