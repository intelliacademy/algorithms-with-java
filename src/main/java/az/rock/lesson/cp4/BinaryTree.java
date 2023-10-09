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

    public T contains(T element){
        return root.contains(element).getElement();
    }

    @Override
    public String toString() {
        return this.root.toString();
    }
}
