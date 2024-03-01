package az.rock.lesson.cp5.nodes;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AVLNode <T extends Comparable<T>> implements Comparable<AVLNode<T>>{
    private final T data;
    private AVLNode<T> parent;
    private AVLNode<T> left;
    private AVLNode<T> right;

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
                return node;
            }else {
                return this.left.insert(data);
            }
        }else {
            if (this.right.isEmpty()){
                node.setParent(this);
                this.right = node;
                return node;
            }else {
                return this.right.insert(data);
            }
        }
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
        return "AVLNode{" +
                "data=" + data +
                ", left=" + left.data +
                ", right=" + right.data +
                "\n}";
    }

    public static class Nil<T extends Comparable<T>> extends AVLNode<T>{

        public static final Nil NIL = new Nil();

        private Nil() {
            super(null);
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
