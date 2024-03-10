package az.rock.lesson.cp9.concretes;

import az.rock.lesson.cp9.AbstractBNode;
import az.rock.lesson.cp9.AbstractBTree;

public class BTree<T extends Comparable<T>> implements AbstractBTree<T> {
    private AbstractBNode<T> root;

    @Override
    public void insert(T value) {
        AbstractBNode<T> node  = new BNode<>(value);
        if (root == null) {
            root = node;
        }else {
            AbstractBNode<T> current = root;
            while (!current.isLeaf()) {
                current = current.insert(value);
            }
        }
    }
}
