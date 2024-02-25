package az.rock.lesson.cp6.nodes;

public class BlackNode<T extends Comparable<T>> extends Node<T> {
    public BlackNode(T value, AbstractNode<T> left, AbstractNode<T> right) {
        super(value, left, right);
    }
}
