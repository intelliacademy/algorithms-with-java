package az.rock.lesson.cp4;

public class BinaryTree<T extends Comparable<? super T>> {
    private BinaryNode<T> root;

    public BinaryTree(){
        root = null;
    }

    public boolean isEmpty(){
        return root == null;
    }

    public void insert(T element){
        if (isEmpty()){
            root = new BinaryNode<>(element);
        }else {
            root.add(element,this.root);
        }
    }

    public boolean compare(BinaryTree<T> other){
        return root.compare(other.root);
    }

    public T contains(T element){
        return root.contains(element).getElement();
    }

    public T remove(T element){
        if (this.isEmpty()) return null;
        return root.remove(element,this.root);
    }

    @Override
    public String toString() {
        return this.root.toString();
    }
}
