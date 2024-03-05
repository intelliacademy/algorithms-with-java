package az.rock.lesson.cp6.nodes;

import az.rock.lesson.cp5.nodes.AVLNode;

public class Node<T extends Comparable<T>> extends AbstractNode<T> {
    public Node(T value,  AbstractNode<T> left, AbstractNode<T> right) {
        super(value, left, right);
    }

    public Node(T value) {
        super(value);
    }

    @Override
    public int compareTo(AbstractNode<T> o) {
        return this.getValue().compareTo(o.getValue());
    }

    @Override
    public AbstractNode<T> insert(T data) {
        AbstractNode<T> node = new RedNode<T>(data);
        if (node.isLessThan(this)){
            if (this.getLeftChild().isEmpty()){
                this.setLeftChild(node);
                node.setParent(this);
                return this;
            }else {
                return this.getLeftChild().insert(data);
            }
        }else {
            if (this.getRightChild().isEmpty()){
                this.setRightChild(node);
                node.setParent(this);
                return this;
            }else {
                return this.getRightChild().insert(data);
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
            return new RedNode<T>(this.getValue(), this.getLeftChild().toBlackNode(), this.getRightChild().toBlackNode());
        else return (RedNode<T>) this;
    }

    @Override
    public BlackNode<T> toBlackNode() {
        if (!(this instanceof BlackNode))
            return new BlackNode<T>(this.getValue(), this.getLeftChild().toBlackNode(), this.getRightChild().toBlackNode());
        else return (BlackNode<T>) this;
    }
}
