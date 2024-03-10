package az.rock.lesson.cp9.abstracts;

public interface AbstractBTree<T extends Comparable<T>>{
    void insert(T value);
}
