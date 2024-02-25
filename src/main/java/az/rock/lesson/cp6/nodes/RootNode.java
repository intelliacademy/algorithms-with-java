package az.rock.lesson.cp6.nodes;

import java.util.Observable;

public class RootNode<T extends Comparable<T>> extends BlackNode<T>{
    public RootNode(T value, AbstractNode<T> left, AbstractNode<T> right) {
        super(value,left, right);
    }
}
