package az.rock.lesson.cp6;

import az.rock.lesson.cp5.nodes.Tree;
import az.rock.lesson.cp6.nodes.RedBlackTree;

public class Chapter6_RedBlackTree {
    public static void main(String[] args) {
        System.out.println("Chapter 6");

        Integer[] unSortedNumbersArray = { 32, 10, 1, 19, 16, 12, 55, 41 };
        var sortedNumbersArray = new Integer[] { 1, 10, 12, 16, 19, 32, 41, 55 };
        Tree<Integer> tree = new RedBlackTree<>();
        for (Integer number : sortedNumbersArray) {
            tree.insert(number);
        }
    }
}
