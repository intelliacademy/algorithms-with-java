package az.rock.lesson.cp6.nodes;

public class RedNode<T extends Comparable<T>> extends AbstractNode.Node<T> {
    public RedNode(T value, BlackNode<T> left, BlackNode<T> right) {
        super(value, left, right);
    }

    public RedNode(T value) {
        super(value, BlackNode.NilNode.NIL, BlackNode.NilNode.NIL);
    }
}
