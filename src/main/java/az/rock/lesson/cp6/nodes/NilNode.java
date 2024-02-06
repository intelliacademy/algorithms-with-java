package az.rock.lesson.cp6.nodes;

public class NilNode<T> extends BlackNode<T> {
    public NilNode(AbstractNode<T> parent) {
        super(null, parent, null, null);
    }

    public NilNode() {
        super(null, null, null, null);
    }

    public static <T> NilNode<T> getInstance(BlackNode<T> parent) {
        return new NilNode<T>(parent);
    }

    public static <T> NilNode<T> getInstance() {
        return new NilNode<T>();
    }

    @Override
    public BlackNode<T> toBlackNode() {
        return this;
    }

    @Override
    public RedNode<T> toRedNode(){
        throw new IllegalStateException("Nil node cannot be converted to red node");
    }
}
