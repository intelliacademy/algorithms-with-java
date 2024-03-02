package az.rock.lesson.cp5.nodes;

import lombok.Getter;
import lombok.Setter;

@Setter
public class AVLNode <T extends Comparable<T>> implements Comparable<AVLNode<T>>{
    private final T data;
    private AVLNode<T> parent;
    private AVLNode<T> left;
    private AVLNode<T> right;
    private Integer height;

    public AVLNode(T data) {
        this.data = data;
        this.parent = null;
        this.left = AVLNode.Nil.getInstance();
        this.right = AVLNode.Nil.getInstance();
    }



    public AVLNode<T> insert(T data){
        var node = new AVLNode<>(data);
        if (node.isLessOrEqualsThan(this)){
            if (this.left.isEmpty()){
                node.setParent(this);
                this.left = node;
                return this.rebalance(node);
            }else {
                return this.left.insert(data);
            }
        }else {
            if (this.right.isEmpty()){
                node.setParent(this);
                this.right = node;
                return this.rebalance(node);
            }else {
                return this.right.insert(data);
            }
        }
    }

    public AVLNode<T> rebalance(AVLNode<T> node){
        if (node.isLeftHeavy()){
            if (node.getLeft().isRightHeavy()) {
                node.setLeft(this.leftRotation(node));
            }
            return this.rightRotation(node);
        }
        if (node.isRightHeavy()){
            if (node.getRight().isLeftHeavy()) node.setRight(this.rightRotation(node));
            return this.leftRotation(node);
        }
        return node;
    }

    public AVLNode<T>  rightRotation(AVLNode<T> node){
        return node;
    }

    public AVLNode<T>  leftRotation(AVLNode<T> node){
        return node;
    }



    public AVLNode<T> getParent() {
        return parent;
    }

    public Integer getHeight() {
        return height;
    }

    public AVLNode<T> getLeft() {
        if (this.left == null){
            this.left = AVLNode.Nil.getInstance();
        }
        return left;
    }

    public AVLNode<T> getRight() {
        if (this.right == null){
            this.right = AVLNode.Nil.getInstance();
        }
        return right;
    }

    public Boolean isGreaterThan(AVLNode<T> other){
        return this.compareTo(other) > 0;
    }

    public Boolean isEquals(AVLNode<T> other){
        return this.compareTo(other) == 0;
    }

    public Boolean isLessThan(AVLNode<T> other){
        return this.compareTo(other) < 0;
    }

    public Boolean isLessOrEqualsThan(AVLNode<T> other){
        return this.isLessThan(other) || this.isEquals(other);
    }

    public Boolean isEmpty(){
        return Boolean.FALSE;
    }

    @Override
    public int compareTo(AVLNode<T> o) {
        return this.data.compareTo(o.data);
    }

    @Override
    public String toString() {
        return " Node[" +
                " data= " + data +
                ", left= " + left.data +
                ", right= " + right.data +
                "\n]";
    }

    public boolean isLeftHeavy() {
        return this.getBalanceFactor() > 1;
    }

    public boolean isRightHeavy() {
        return this.getBalanceFactor() < -1;
    }

    public int getBalanceFactor() {
        return this.right.getHeight() - this.left.getHeight();
    }

    public AVLNode<T> nilSafety(){
        if (this.left == null){
            this.left = AVLNode.Nil.getInstance();
        }

        if (this.right == null){
            this.right = AVLNode.Nil.getInstance();
        }
        return this;
    }

    public void updateHeight() {
        this.height = Math.max(this.left.height, this.right.height) + 1;
    }

    public static class Nil<T extends Comparable<T>> extends AVLNode<T>{

        public static final Nil NIL = new Nil();

        private Nil() {
            super(null);
            this.setHeight(-1);
        }

        @Override
        public AVLNode<T> nilSafety() {
            return this;
        }

        @Override
        public void updateHeight() {
            // do nothing
        }

        @Override
        public boolean isLeftHeavy() {
            return false;
        }

        @Override
        public boolean isRightHeavy() {
            return false;
        }

        @Override
        public Integer getHeight() {
            return -1;
        }

        @Override
        public int getBalanceFactor() {
            return 0;
        }

        public static <T extends Comparable<T>> AVLNode<T> getInstance(){
            return NIL;
        }

        @Override
        public Boolean isEmpty() {
            return Boolean.TRUE;
        }

        @Override
        public String toString() {
            return "NIL";
        }
    }
}
