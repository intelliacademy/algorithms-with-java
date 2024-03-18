package az.rock.lesson.cp4;

public sealed class BinaryNode <T extends Comparable<? super T>> implements Comparable<BinaryNode<T>> permits EmptyNode{
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

    public Boolean compare(BinaryNode<T> other){
        if (this.isEmpty() && other.isEmpty()){
            return Boolean.TRUE;
        }else if (this.isEmpty() || other.isEmpty()){
            return Boolean.FALSE;
        }else {
            return this.element.compareTo(other.element) == 0 && this.left.compare(other.left) && this.right.compare(other.right);
        }
    }

    public void setParent(BinaryNode<T> parent) {
        this.parent = parent;
    }

    public Boolean isEmpty(){
        return Boolean.FALSE;
    }

    public void add(T element,BinaryNode<T> parent){
        if (left.isEmpty() && element.compareTo(this.element) <= 0){
            left = new BinaryNode<>(this,element);
        }else if (right.isEmpty() && element.compareTo(this.element) > 0){
            right = new BinaryNode<>(this,element);
        }else {
            if (element.compareTo(this.element) <= 0) left.add(element,this);
            else right.add(element,parent);
        }
    }

    public void traverseInOrder(){
        if (isEmpty()){
            return;
        }
        left.traverseInOrder();
        System.out.println(element);
        right.traverseInOrder();
    }

    public void traversePreOrder(){
        if (isEmpty()){
            return;
        }
        System.out.println(element);
        left.traversePreOrder();
        right.traversePreOrder();
    }

    public void traversePostOrder(){
        if (isEmpty()){
            return;
        }
        left.traversePostOrder();
        right.traversePostOrder();
        System.out.println(element);
    }

    public T remove(T element,BinaryNode<T> node){
        if (node == null) return null;
        if (element.compareTo(node.getElement()) < 0) {
            return remove(element, node.left);
        }else if (element.compareTo(node.getElement()) > 0) {
            return remove(element, node.right);
        }else {
            if (node.isLeaf()){
                if (node.parent.left == node){
                    node.parent.left = EmptyNode.getInstance();
                }else {
                    node.parent.right = EmptyNode.getInstance();
                }
                return node.getElement();
            }else {
                if (node.hasOnlyLeft()){
                    if (node.parent.left == node){
                        node.parent.left = node.left;
                    }else {
                        node.parent.right = node.left;
                    }
                    return node.getElement();
                }else if (node.hasOnlyRight()){
                    if (node.parent.left == node){
                        node.parent.left = node.right;
                    }else {
                        node.parent.right = node.right;
                    }
                    return node.getElement();
                }else {
                    BinaryNode<T> min = node.right.findMin();
                    T temp = node.getElement();
                    node.element = min.getElement();
                    min.element = temp;
                    return remove(element, node.right);
                }
            }
        }
    }

    public BinaryNode<T> findMin(){
        if (isEmpty()){
            return null;
        }else {
            if (left.isEmpty()){
                return this;
            }else {
                return left.findMin();
            }
        }
    }

    public BinaryNode<T> findMax(){
        if (isEmpty()){
            return null;
        }else {
            if (right.isEmpty()){
                return this;
            }else {
                return right.findMax();
            }
        }
    }

    private Boolean hasOnlyLeft(){
        return hasLeft() && !hasRight();
    }

    private Boolean hasOnlyRight(){
        return !hasLeft() && hasRight();
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

    //kth smallest element
    public T kthSmallest(int k){
        if (isEmpty()){
            return null;
        }
        int leftSize = left.size();
        if (leftSize == k - 1){
            return element;
        }else if (leftSize > k - 1){
            return left.kthSmallest(k);
        }else {
            return right.kthSmallest(k - leftSize - 1);
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
