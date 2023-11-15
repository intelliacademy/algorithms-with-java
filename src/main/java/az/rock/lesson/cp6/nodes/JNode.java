package az.rock.lesson.cp6.nodes;

public class JNode<T> extends AbstractNode<T> {
    public JNode(T value, AbstractNode<T> parent, AbstractNode<T> left, AbstractNode<T> right) {
        super(value, parent, left, right);
    }

    @Override
    public AbstractNode<T> insert(T data) {
        return null;
    }

    @Override
    public AbstractNode<T> remove(T data) {
        return null;
    }

    @Override
    public AbstractNode<T> balance() {
        return null;
    }

    @Override
    public AbstractNode<T> rotateLeft() {
        return null;
    }

    @Override
    public AbstractNode<T> rotateRight() {
        return null;
    }

    @Override
    public AbstractNode<T> getGrandParent() {
        return null;
    }
}
