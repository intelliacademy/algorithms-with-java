package az.rock.lesson.cp0;

import java.util.function.Consumer;

public interface OrderedList <T>{
    void add(T element);
    void remove(T element);
    void forEach(Consumer<T> consumer);
    void get(T element);
    void clear();
}
