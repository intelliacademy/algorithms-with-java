package az.rock.lesson.cp9;

import az.rock.lesson.cp9.concretes.BTree;

public class Chapter9_BTrees {
    public static void main(String[] args) {
        var unsortedArray = new int[]{3, 1, 4, 1, 5, 9, 2, 6, 5, 3, 5};
        var bTree = new BTree<Integer>();
        for (int i : unsortedArray) {
            bTree.insert(i);
        }
        System.out.println("BTree: " + bTree);
    }
}


