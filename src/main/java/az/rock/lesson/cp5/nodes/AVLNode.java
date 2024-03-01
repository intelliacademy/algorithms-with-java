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

        return null;
    }


    public Boolean isEmpty(){
        return Boolean.FALSE;
    }

    @Override
    public int compareTo(AVLNode<T> o) {
        return this.data.compareTo(o.data);
    }


    public static class Nil<T extends Comparable<T>> extends AVLNode<T>{

        private Nil() {
            super(null);
        }

        public static <T extends Comparable<T>> AVLNode<T> getInstance(){
            return new Nil<>();
        }

        @Override
        public Boolean isEmpty() {
            return Boolean.TRUE;
        }
    }
}
