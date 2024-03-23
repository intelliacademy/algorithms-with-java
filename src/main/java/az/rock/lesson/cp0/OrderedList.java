package az.rock.lesson.cp0;

import java.util.function.Consumer;

public interface OrderedList <T>{
    void add(T element);
    void remove(T element);
    void forEach(Consumer<T> consumer);
    T get(T element);

    T getFirst();
    T getLast();
    void clear();
}
