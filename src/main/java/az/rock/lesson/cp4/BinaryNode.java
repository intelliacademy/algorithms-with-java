package az.rock.lesson.cp4;

public class BinaryNode <T extends Comparable<? super T>> implements Comparable<BinaryNode<T>>{
    private T element;
    private BinaryNode<T> left;
    private BinaryNode<T> right;

    public BinaryNode(T element){
        this(element, EmptyNode.getInstance(), EmptyNode.getInstance());
    }

    public BinaryNode(T element,BinaryNode<T> left,BinaryNode<T> right){
        this.element = element;
        this.left = left;
        this.right = right;
    }

    public Boolean isEmpty(){
        return this instanceof EmptyNode;
    }

    public void add(T element){
        if (left.isEmpty() && element.compareTo(this.element) <= 0){
            left = new BinaryNode<>(element);
        }else if (right.isEmpty() && element.compareTo(this.element) > 0){
            right = new BinaryNode<>(element);
        }else {
            if (element.compareTo(this.element) <= 0) left.add(element);
            else right.add(element);
        }
    }

    public T getElement() {
        return element;
    }

    public boolean isLeaf(){
        return left.isEmpty() && right.isEmpty();
    }

    public boolean hasLeft(){
        return !(left.isEmpty());
    }

    public boolean hasRight(){
        return !(right.isEmpty());
    }

    public BinaryNode<T> getLeft() {
        return left;
    }

    public BinaryNode<T> getRight() {
        return right;
    }

    public Boolean isFull(){
        return hasLeft() && hasRight();
    }

    public int height(){
        if (isLeaf()){
            return 0;
        }else {
            return 1 + Math.max(left.height(),right.height());
        }
    }

    public int size(){
        if (isLeaf()){
            return 1;
        }else {
            return 1 + left.size() + right.size();
        }
    }

    public int numberOfLeaves(){
        if (isLeaf()){
            return 1;
        }else {
            return left.numberOfLeaves() + right.numberOfLeaves();
        }
    }

    public int numberOfNonLeaves(){
        if (isLeaf()){
            return 0;
        }else {
            return 1 + left.numberOfNonLeaves() + right.numberOfNonLeaves();
        }
    }

    public int numberOfFullNodes(){
        if (isLeaf()){
            return 0;
        }else {
            if (isFull()){
                return 1 + left.numberOfFullNodes() + right.numberOfFullNodes();
            }else {
                return left.numberOfFullNodes() + right.numberOfFullNodes();
            }
        }
    }

    public int numberOfHalfNodes(){
        if (isLeaf()){
            return 0;
        }else {
            if (hasLeft() && !hasRight()){
                return 1 + left.numberOfHalfNodes() + right.numberOfHalfNodes();
            }else if (!hasLeft() && hasRight()){
                return 1 + left.numberOfHalfNodes() + right.numberOfHalfNodes();
            }else {
                return left.numberOfHalfNodes() + right.numberOfHalfNodes();
            }
        }
    }

    public int numberOfNodesWithOneChild(){
        if (isLeaf()){
            return 0;
        }else {
            if (hasLeft() && !hasRight()){
                return 1 + left.numberOfNodesWithOneChild() + right.numberOfNodesWithOneChild();
            }else if (!hasLeft() && hasRight()){
                return 1 + left.numberOfNodesWithOneChild() + right.numberOfNodesWithOneChild();
            }else {
                return left.numberOfNodesWithOneChild() + right.numberOfNodesWithOneChild();
            }
        }
    }

    public int numberOfNodesWithTwoChildren(){
        if (isLeaf()){
            return 0;
        }else {
            if (isFull()){
                return 1 + left.numberOfNodesWithTwoChildren() + right.numberOfNodesWithTwoChildren();
            }else {
                return left.numberOfNodesWithTwoChildren() + right.numberOfNodesWithTwoChildren();
            }
        }
    }

    public Boolean contains(T element){
        if (this.element.equals(element)){
            return true;
        }else {
            if (hasLeft() && hasRight()){
                return left.contains(element) || right.contains(element);
            }else if (hasLeft() && !hasRight()){
                return left.contains(element);
            }else if (!hasLeft() && hasRight()){
                return right.contains(element);
            }else {
                return false;
            }
        }
    }

    public String toString(){
        if (isLeaf()){
            return element.toString();
        }else {
            return element.toString() + " LEFT : " + left.toString() + " RIGHT : " + right.toString();
        }
    }

    @Override
    public int compareTo(BinaryNode<T> o) {
        return this.element.compareTo(o.element);
    }


}
