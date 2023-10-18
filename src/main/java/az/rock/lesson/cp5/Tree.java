package az.rock.lesson.cp5;

public interface Tree <T extends Comparable<T>>{
    void insert(T data);
    void remove(T data);
    void traversal();
    T getMaxValue();
    T getMinValue();
}
