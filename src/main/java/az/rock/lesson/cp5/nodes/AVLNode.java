package az.rock.lesson.cp5.nodes;

import az.rock.lesson.cp6.nodes.AbstractNode;
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


    public static class NilNode<T extends Comparable<T>> extends AVLNode<T>{

        private NilNode() {
            super(null);
        }

        public static <T extends Comparable<T>> AVLNode<T> getInstance(){
            return new NilNode<>();
        }

        @Override
        public Boolean isEmpty() {
            return Boolean.TRUE;
        }
    }
}
