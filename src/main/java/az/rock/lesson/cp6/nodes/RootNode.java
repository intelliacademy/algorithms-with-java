package az.rock.lesson.cp6.nodes;

public class RootNode<T extends Comparable<T>> extends BlackNode<T>{
    public RootNode(T value, AbstractNode<T> left, AbstractNode<T> right) {
        super(value,left, right);
    }
}
