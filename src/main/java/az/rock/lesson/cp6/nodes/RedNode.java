package az.rock.lesson.cp6.nodes;

public class RedNode<T extends Comparable<T>> extends AbstractNode.Node<T> {
    public RedNode(T value, BlackNode<T> left, BlackNode<T> right) {
        super(value, left, right);
    }

    public RedNode(AbstractNode<T> parent, T value, AbstractNode<T> left, AbstractNode<T> right) {
        super(parent,value, left, right);
    }

    public RedNode(T value) {
        super(value, BlackNode.NilNode.NIL, BlackNode.NilNode.NIL);
    }


    @Override
    public AbstractNode<T> reColor() {
        return this.toBlackNode();
    }
}
