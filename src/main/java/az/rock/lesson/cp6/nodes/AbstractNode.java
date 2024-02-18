package az.rock.lesson.cp6.nodes;

public abstract class AbstractNode<T extends Comparable<T>>  implements Comparable<AbstractNode<T>> {
    private final T value;
    private AbstractNode<T> parent;
    private AbstractNode<T> left;
    private AbstractNode<T> right;

    protected AbstractNode(T value, AbstractNode<T> parent, AbstractNode<T> left, AbstractNode<T> right) {
        this.value = value;
        this.parent = parent;
        this.left = left;
        this.right = right;
    }

    public Boolean isGreaterThan(AbstractNode<T> node) {
        return this.compareTo(node) > 0;
    }

    public Boolean isLessThan(AbstractNode<T> node) {
        return this.compareTo(node) < 0;
    }

    public Boolean isEqualTo(AbstractNode<T> node) {
        return this.compareTo(node) == 0;
    }

    public Boolean isGreaterOrEqualsThan(AbstractNode<T> node) {
        return this.isGreaterThan(node) || this.isEqualTo(node);
    }

    public Boolean isLessOrEqualsThan(AbstractNode<T> node) {
        return this.isLessThan(node) || this.isEqualTo(node);
    }

    public abstract void insert(AbstractNode<T> node);

    public abstract AbstractNode<T> remove(T data);

    public abstract AbstractNode<T> balance();

    public abstract AbstractNode<T> rotateLeft();

    public abstract AbstractNode<T> rotateRight();

    public abstract AbstractNode<T> getGrandParent();

    public abstract RedNode<T> toRedNode();

    public abstract BlackNode<T> toBlackNode();

    public abstract AbstractNode<T> reColor();


    public AbstractNode<T> getLeft() {
        return left;
    }

    public AbstractNode<T> getRight() {
        return right;
    }

    public void setLeft(AbstractNode<T> left) {
        this.left = left;
    }

    public void setRight(AbstractNode<T> right){
        this.right = right;
    }

    public void setParent(AbstractNode<T> parent){
        this.parent = parent;
    }

    public T getValue() {
        return value;
    }

    public AbstractNode<T> getParent() {
        return parent;
    }

    public Boolean isLeaf() {
        return this.left instanceof NilNode<T> && this.right instanceof NilNode<T>;
    }

    public Boolean hasLeft() {
        return !(this.left instanceof NilNode<T>);
    }

    public Boolean hasRight() {
        return !(this.right instanceof NilNode<T>);
    }

    public Boolean isEmpty() {
        return this instanceof NilNode;
    }


}
