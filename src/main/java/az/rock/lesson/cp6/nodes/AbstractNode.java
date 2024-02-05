package az.rock.lesson.cp6.nodes;

public abstract class AbstractNode<T>  {
    private final T value;
    private final AbstractNode<T> parent;
    private final AbstractNode<T> left;
    private final AbstractNode<T> right;

    protected AbstractNode(T value, AbstractNode<T> parent, AbstractNode<T> left, AbstractNode<T> right) {
        this.value = value;
        this.parent = parent;
        this.left = left;
        this.right = right;
    }

    public abstract AbstractNode<T> insert(T data);

    public abstract AbstractNode<T> remove(T data);

    public abstract AbstractNode<T> balance();

    public abstract AbstractNode<T> rotateLeft();

    public abstract AbstractNode<T> rotateRight();

    public abstract AbstractNode<T> getGrandParent();



    public AbstractNode<T> getLeft() {
        return left;
    }

    public AbstractNode<T> getRight() {
        return right;
    }

    public T getValue() {
        return value;
    }

    public AbstractNode<T> getParent() {
        return parent;
    }

    public Boolean isLeaf() {
        return this.left instanceof EmptyNode<T> && this.right instanceof EmptyNode<T>;
    }

    public Boolean hasLeft() {
        return !(this.left instanceof EmptyNode<T>);
    }

    public Boolean hasRight() {
        return !(this.right instanceof EmptyNode<T>);
    }

    public Boolean isEmpty() {
        return this instanceof EmptyNode;
    }


}