package az.rock.lesson.cp7.nodes;

import az.rock.lesson.util.Tree;

import java.util.function.BiFunction;
import java.util.function.Consumer;

public class SplayTree<T extends Comparable<T>> implements Tree<T> {


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
}
