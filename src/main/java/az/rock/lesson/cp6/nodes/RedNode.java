package az.rock.lesson.cp6.nodes;

public class RedNode<T extends Comparable<T>> extends Node<T> {
    public RedNode(T value, BlackNode<T> left, BlackNode<T> right) {
        super(value, left, right);
    }
}
