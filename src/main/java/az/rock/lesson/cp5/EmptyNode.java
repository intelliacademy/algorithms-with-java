package az.rock.lesson.cp5;

public class EmptyNode<T extends Comparable<T>> extends AVLNode<T>{

    public static final EmptyNode EMPTY_NODE = new EmptyNode<>(null);

    public EmptyNode(T data) {
        super(data);
    }

    public EmptyNode(T data, AVLNode<T> parent) {
        super(data, parent);
    }

    @Override
    public Boolean isEmpty() {
        return Boolean.TRUE;
    }

    @Override
    public int getHeight() {
        return -1;
    }
}
