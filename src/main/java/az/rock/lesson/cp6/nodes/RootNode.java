package az.rock.lesson.cp6.nodes;

public class RootNode<T> extends BlackNode<T>{
    public RootNode(T value, AbstractNode<T> left, AbstractNode<T> right) {
        super(value, EmptyNode.EMPTY_NODE, left, right);
    }
}
