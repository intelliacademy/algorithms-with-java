package az.rock.lesson.cp5;

import az.rock.lesson.cp5.nodes.AVLTree;
import az.rock.lesson.cp5.nodes.Tree;

public class Chapter5_AVLTree {
    public static void main(String[] args) {
        Integer[] numbers = { 32, 10, 1, 19, 16, 12, 55, 41 };
        Tree<Integer> tree = new AVLTree<>();
        for (Integer number : numbers) {
            tree.insert(number);
        }

        System.out.println(tree);
    }
}
