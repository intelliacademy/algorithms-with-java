package az.rock.lesson.cp4;

public class BinarySearchTree<T extends Comparable<? super T>> {
    private BinaryNode<T> root;

    public BinarySearchTree(){
        root = null;
    }

    public boolean isEmpty(){
        return root == null;
    }

    public void insert(T element){
        if (isEmpty()){
            root = new BinaryNode<>(element);
        }else {
            root.add(element);
        }
    }

    public Boolean contains(T element){
        return root.contains(element);
    }

    @Override
    public String toString() {
        return this.root.toString();
    }
}
