package az.rock.lesson.cp6.nodes;

import java.util.function.BiFunction;

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

    @Override
    public int getHeight() {
        return -1;
    }

    @Override
    public AbstractNode<T> remove(T data) {
        return this;
    }

    public static synchronized  <T extends Comparable<T>> NilNode<T> getRootReference() {
        if (NIL == null) {
            NIL = new NilNode<T>();
        }
        return NIL;
    }

    @Override
    public T reduce(BiFunction<T, T, T> function) {
        return null;
    }

    @Override
    public void setLeftChild(AbstractNode<T> left) {
        throw new IllegalStateException("Nil node cannot have left child");
    }

    @Override
    public void setRightChild(AbstractNode<T> right) {
        throw new IllegalStateException("Nil node cannot have right child");
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
