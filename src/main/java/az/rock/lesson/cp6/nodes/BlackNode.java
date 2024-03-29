package az.rock.lesson.cp6.nodes;

import java.util.function.BiFunction;

public class BlackNode<T extends Comparable<T>> extends AbstractNode.Node<T> {
    public BlackNode(AbstractNode<T> parent,T value, AbstractNode<T> left, AbstractNode<T> right) {
        super(value, left, right);
    }

    public BlackNode(T value) {
        super(value);
    }


    @Override
    public AbstractNode<T> reColor() {
        return this.toRedNode();
    }

    public static class NilNode<T extends Comparable<T>> extends BlackNode<T> {
        public static NilNode NIL;
        public static NilNode ROOT = new NilNode();
        public NilNode(AbstractNode<T> parent) {
            super(parent,null, NIL, NIL);
        }

        public NilNode() {
            super(null,null, null, null);
        }

        public static <T extends Comparable<T>> NilNode<T> getInstance(AbstractNode<T> parent) {
            if (NIL == null) {
                NIL = new NilNode(parent);
            }
            return NIL;
        }

        @Override
        public AbstractNode<T> reColor() {
            return this;
        }

        @Override
        public void updateHeight() {}
        @Override
        public Integer getBalanceFactor() {
            return 0;
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
            return ROOT;
        }

        @Override
        public T reduce(BiFunction<T, T, T> function) {
            return null;
        }

        @Override
        public BlackNode<T> toBlackNode() {
            return this;
        }

        @Override
        public RedNode<T> toRedNode(){
            throw new IllegalStateException("Nil node cannot be converted to red node");
        }

        @Override
        public String toString() {
            return "NIL";
        }
    }
}
