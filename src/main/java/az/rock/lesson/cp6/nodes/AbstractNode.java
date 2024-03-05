package az.rock.lesson.cp6.nodes;

import java.util.function.BiFunction;
import java.util.function.Consumer;

public abstract class AbstractNode<T extends Comparable<T>>  implements Comparable<AbstractNode<T>> {
    private int height = 0;
    private final T value;
    private AbstractNode<T> parent;
    private AbstractNode<T> left;
    private AbstractNode<T> right;

    protected AbstractNode(T value,  AbstractNode<T> left, AbstractNode<T> right) {
        this.value = value;
        this.left = left;
        this.right = right;
    }

    protected AbstractNode(T value) {
        this.value = value;
        this.left = BlackNode.NilNode.getInstance(this);
        this.right = BlackNode.NilNode.getInstance(this);
    }

    @Override
    public String toString() {
        return this.getClass().getSimpleName() + " {" +
                "value=" + value.toString() +
                ", left=" + left.toString() +
                ", right=" + right.toString() +
                '}';
    }

    @Override
    public int compareTo(AbstractNode<T> o) {
        return this.value.compareTo(o.value);
    }


    public int getHeight() {
        return height;
    }

    public void updateHeight() {
        this.height = 1 + Math.max(this.left.getHeight(), this.right.getHeight());
    }

    public Boolean isLeftHeavy() {
        return this.getBalanceFactor() < -1;
    }

    public Boolean isRightHeavy() {
        return this.getBalanceFactor() > 1;
    }

    public Integer getBalanceFactor(){
        return this.left.getHeight() - this.right.getHeight();
    }

    public T reduce(BiFunction<T, T, T> function){
        T leftValue = null;
        T rightValue = null;
        if (!this.isLeaf()) {
            if (this.hasLeft()) {
                leftValue = this.getLeftChild().reduce(function);
            }
            if (this.hasRight()) {
                rightValue = this.getRightChild().reduce(function);
            }
            if (leftValue == null || rightValue == null) {
                return function.apply(leftValue == null ? rightValue : leftValue, this.getValue());
            }
            return function.apply(leftValue, rightValue);
        }else return this.getValue();
    }

    public void traverseInOrder(Consumer<T> consumer) {
        if (this.hasLeft()) {
            this.getLeftChild().traverseInOrder(consumer);
        }
        consumer.accept(this.getValue());
        if (this.hasRight()) {
            this.getRightChild().traverseInOrder(consumer);
        }
    }

    public void traversePreOrder(Consumer<T> consumer) {
        consumer.accept(this.getValue());
        if (this.hasLeft()) {
            this.getLeftChild().traversePreOrder(consumer);
        }
        if (this.hasRight()) {
            this.getRightChild().traversePreOrder(consumer);
        }
    }

    public void traversePostOrder(Consumer<T> consumer) {
        if (this.hasLeft()) {
            this.getLeftChild().traversePostOrder(consumer);
        }
        if (this.hasRight()) {
            this.getRightChild().traversePostOrder(consumer);
        }
        consumer.accept(this.getValue());
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

    public abstract AbstractNode<T> insert(T data);

    public abstract AbstractNode<T> remove(T data);


    public abstract RedNode<T> toRedNode();

    public abstract BlackNode<T> toBlackNode();

    public abstract AbstractNode<T> reColor();


    public AbstractNode<T> getLeftChild() {
        return left;
    }

    public AbstractNode<T> getRightChild() {
        return right;
    }

    public void setLeftChild(AbstractNode<T> left) {
        this.left = left;
    }

    public void setRightChild(AbstractNode<T> right){
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
        return this.left instanceof BlackNode.NilNode<T> && this.right instanceof BlackNode.NilNode<T>;
    }

    public Boolean hasLeft() {
        return this.left != null && !(this.left instanceof BlackNode.NilNode<T>);
    }

    public Boolean hasRight() {
        return this.left != null && !(this.right instanceof BlackNode.NilNode<T>);
    }

    public Boolean isEmpty() {
        return this instanceof BlackNode.NilNode;
    }


    public static class Node<T extends Comparable<T>> extends AbstractNode<T> {
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
}
