package az.rock.lesson.cp6.nodes;

public class BlackNode<T> extends JNode<T> {
    public BlackNode(T value, AbstractNode<T> parent, AbstractNode<T> left, AbstractNode<T> right) {
        super(value, parent, left, right);
    }
}
