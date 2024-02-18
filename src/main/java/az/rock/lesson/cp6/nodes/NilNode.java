package az.rock.lesson.cp6.nodes;

public class NilNode<T extends Comparable<T>> extends BlackNode<T> {
    public static NilNode NIL;
    public NilNode(AbstractNode<T> parent) {
        super(null, parent, null, null);
    }

    public NilNode() {
        super(null, null, null, null);
    }

    public static <T extends Comparable<T>> NilNode<T> getInstance(BlackNode<T> parent) {
        return new NilNode<T>(parent);
    }

    public static synchronized  <T extends Comparable<T>> NilNode<T> getRootReference() {
        if (NIL == null) {
            NIL = new NilNode<T>();
        }
        return NIL;
    }

    public static <T extends Comparable<T>> NilNode<T> getInstance() {
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
