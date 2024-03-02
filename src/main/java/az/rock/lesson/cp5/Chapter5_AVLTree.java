package az.rock.lesson.cp5;

import az.rock.lesson.cp5.nodes.AVLTree;
import az.rock.lesson.cp6.nodes.Tree;

public class Chapter5_AVLTree {
    public static void main(String[] args) {
        Integer[] unSortedNumbersArray = { 32, 10, 1, 19, 16, 12, 55, 41 };
        var sortedNumbersArray = new Integer[] { 1, 10, 12, 16, 19, 32, 41, 55 };
        Tree<Integer> tree = new AVLTree<>();
        for (Integer number : sortedNumbersArray) {
            tree.insert(number);
        }
        System.out.println(tree);

    }
}
