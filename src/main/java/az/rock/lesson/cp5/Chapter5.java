package az.rock.lesson.cp5;

public class Chapter5 {
    public static void main(String[] args) {
        Integer[] numbers = { 32, 10, 1, 19, 16, 12, 55, 41 };
        Tree<Integer> tree = new AVLTree<>();
        for (Integer number : numbers) {
            tree.insert(number);
        }

        System.out.println(tree);
    }
}
