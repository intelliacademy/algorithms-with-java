package az.rock.lesson.util;

import java.util.function.BiFunction;
import java.util.function.Consumer;

public interface Tree <T extends Comparable<T>>{
    void insert(T data);
    void remove(T data);
    void traversal(Consumer<T> consumer);

    T reduce(BiFunction<T, T, T> function);
    T getMaxValue();
    T getMinValue();
}
