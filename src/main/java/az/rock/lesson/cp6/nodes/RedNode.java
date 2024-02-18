package az.rock.lesson.cp6.nodes;

public class RedNode<T> extends Node<T> {
    public RedNode(T value, AbstractNode<T> parent, BlackNode<T> left, BlackNode<T> right) {
        super(value, parent, left, right);
    }
}
