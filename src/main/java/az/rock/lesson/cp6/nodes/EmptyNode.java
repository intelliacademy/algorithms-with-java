package az.rock.lesson.cp6.nodes;

public class EmptyNode<T> extends BlackNode<T> {
    public static EmptyNode EMPTY_NODE = new EmptyNode<>();


    public EmptyNode(AbstractNode<T> parent) {
        super(null, parent, null, null);
    }

    public EmptyNode() {
        super(null, null, null, null);
    }

    public static <T> EmptyNode<T> getInstance(BlackNode<T> parent) {
        return new EmptyNode<T>(parent);
    }

}
