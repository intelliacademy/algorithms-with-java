package az.rock.lesson.cp6.nodes;

public class RedNode<T> extends JNode<T> {
    public RedNode(T value, AbstractNode<T> parent, BlackNode<T> left, BlackNode<T> right) {
        super(value, parent, left, right);
    }
}
