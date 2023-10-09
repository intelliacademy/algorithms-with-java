package az.rock.lesson.cp4;

public class BinaryNode <T extends Comparable<? super T>> implements Comparable<BinaryNode<T>>{
    private T element;

    private BinaryNode<T> parent;
    private BinaryNode<T> left;
    private BinaryNode<T> right;

    public T getElement() {
        return element;
    }

    public BinaryNode(BinaryNode<T> parent,T element){
        this(element, EmptyNode.getInstance(parent), EmptyNode.getInstance(parent));
        this.parent = parent;
    }

    public BinaryNode(T element){
        this(element, EmptyNode.getInstance(), EmptyNode.getInstance());
    }

    public BinaryNode(T element,BinaryNode<T> left,BinaryNode<T> right){
        this.element = element;
        this.left = left;
        this.right = right;
    }

    public void setParent(BinaryNode<T> parent) {
        this.parent = parent;
    }

    public Boolean isEmpty(){
        return Boolean.FALSE;
    }

    public void add(T element){
        if (left.isEmpty() && element.compareTo(this.element) <= 0){
            left = new BinaryNode<>(this,element);
        }else if (right.isEmpty() && element.compareTo(this.element) > 0){
            right = new BinaryNode<>(this,element);
        }else {
            if (element.compareTo(this.element) <= 0) left.add(element);
            else right.add(element);
        }
    }

    public T remove(T element){
        var target =  this.contains(element).remove(element);


        return target;
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

    public Boolean isFull(){
        return hasLeft() && hasRight();
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

    public BinaryNode<T> contains(T element){
        if (isEmpty()){
            return this;
        }
        if (this.element.equals(element)){
            return this;
        }else {
            if (element.compareTo(this.element) <= 0){
                return left.contains(element);
            }else {
                return right.contains(element);
            }
        }
    }

    public String toString(){
        if (isLeaf()){
            return "ROOT : " + element.toString();
        }else {
            return element.toString() +"\n \t "+ " <= LEFT : " + left.toString()+ "\n \t " + " => RIGHT : " + right.toString();
        }
    }

    @Override
    public int compareTo(BinaryNode<T> o) {
        return this.element.compareTo(o.element);
    }


}
