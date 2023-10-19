package az.rock.lesson.cp5;

public class EmptyNode<T extends Comparable<T>> extends AVLNode<T>{

    public EmptyNode(T data) {
        super(data);
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
