package az.rock.lesson.cp5.nodes;

import java.util.function.Consumer;

public interface Tree <T extends Comparable<T>>{
    void insert(T data);
    void remove(T data);
    void traversal(Consumer<T> consumer);
    T getMaxValue();
    T getMinValue();
}
