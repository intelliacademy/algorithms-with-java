package az.rock.lesson.cp6.nodes;

public class Node<T extends Comparable<T>> extends AbstractNode<T> {
    public Node(T value, AbstractNode<T> parent, AbstractNode<T> left, AbstractNode<T> right) {
        super(value, parent, left, right);
    }

    @Override
    public int compareTo(AbstractNode<T> o) {
        return this.getValue().compareTo(o.getValue());
    }

    @Override
    public AbstractNode<T> insert(AbstractNode<T> parent,AbstractNode<T> node) {
        this.setParent(parent);
        if (node.isGreaterOrEqualsThan(this)) {
            if(this.hasRight()){
                return this.getRightChild().insert(this,node);
            } else {
                node.setParent(this);
                this.setRightChild(node);
                return this;
            }
        } else {
            if(this.hasLeft()){
                return this.getLeftChild().insert(this,node);
            } else {
                node.setParent(this);
                this.setLeftChild(node);
                return this;
            }
        }
    }

    @Override
    public AbstractNode<T> remove(T data) {
        //TODO: Implement remove method
        return null;
    }

    @Override
    public AbstractNode<T> balance() {
        return null;
    }

    @Override
    public AbstractNode<T> rotateLeft() {
        return null;
    }

    @Override
    public AbstractNode<T> rotateRight() {
        return null;
    }

    @Override
    public AbstractNode<T> getGrandParent() {
        return null;
    }

    @Override
    public AbstractNode<T> reColor() {
        return null;
    }

    @Override
    public RedNode<T> toRedNode() {
        if (!(this instanceof RedNode))
            return new RedNode<T>(this.getValue(), this.getParent(), this.getLeftChild().toBlackNode(), this.getRightChild().toBlackNode());
        else return (RedNode<T>) this;
    }

    @Override
    public BlackNode<T> toBlackNode() {
        if (!(this instanceof BlackNode))
            return new BlackNode<T>(this.getValue(), this.getParent(), this.getLeftChild().toBlackNode(), this.getRightChild().toBlackNode());
        else return (BlackNode<T>) this;
    }
}
