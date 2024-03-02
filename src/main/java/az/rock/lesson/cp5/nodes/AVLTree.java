package az.rock.lesson.cp5.nodes;

import az.rock.lesson.cp6.nodes.Tree;

import java.util.function.BiFunction;
import java.util.function.Consumer;

public class AVLTree <T extends Comparable<T>> implements Tree<T> {

    private AVLNode<T> root = AVLNode.Nil.<T>getInstance();

    @Override
    public void insert(T data) {
        if (this.root.isEmpty()){
            this.root = new AVLNode<>(data);
            this.root.updateHeight();
        }else {
            var node = this.root.insert(data);
//            while (node != null){
//                node.updateHeight();
//                this.rebalance(node);
//                node = node.getParent();
//            }
        }
    }


    @Override
    public void remove(T data) {

    }

    @Override
    public void traversal(Consumer<T> consumer) {

    }

    @Override
    public T reduce(BiFunction<T, T, T> function) {
        return null;
    }

    @Override
    public T getMaxValue() {
        return null;
    }

    @Override
    public T getMinValue() {
        return null;
    }

    @Override
    public String toString() {
        return root.toString();
    }
}
