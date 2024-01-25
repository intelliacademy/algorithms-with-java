package az.rock.lesson.cp5;

public abstract class AbstractNode <T extends Comparable<T>> implements Node<T>{
    protected T data;
    protected Node<T> leftChild;
    protected Node<T> rightChild;
    protected int height;

    public AbstractNode() {
        this.height = -1;
    }

    public AbstractNode(T data) {
        this(data, EmptyNode.getInstance(), EmptyNode.getInstance());
    }

    public AbstractNode(T data, Node<T> leftChild, Node<T> rightChild) {
        this();
        this.data = data;
        this.leftChild = leftChild;
        this.rightChild = rightChild;
    }

    public Integer getHeight() {
        return height;
    }


    @Override
    public Boolean isLeaf() {
        return this.leftChild == null && this.rightChild == null;
    }

    @Override
    public Boolean hasLeftChild() {
        return this.leftChild != null;
    }

    @Override
    public Boolean hasRightChild() {
        return this.rightChild != null;
    }

    @Override
    public Boolean hasAnyChild() {
        return this.leftChild != null || this.rightChild != null;
    }

    @Override
    public Boolean hasBothChildren() {
        return this.leftChild != null && this.rightChild != null;
    }
}
