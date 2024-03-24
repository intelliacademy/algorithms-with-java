package az.rock.lesson.util;

import java.util.List;

public interface Sort<T extends Comparable<T>>{
    default List<T> execute(List<T> list){
        return List.of();
    }
    default T[] executeArr(T[] list){
        return (T[]) new Object[0];
    }
}
