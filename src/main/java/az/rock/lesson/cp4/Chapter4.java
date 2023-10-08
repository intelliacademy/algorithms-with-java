package az.rock.lesson.cp4;

import az.rock.lesson.model.Person;
import az.rock.lesson.util.PersonDataProvider;

import java.util.stream.IntStream;

public class Chapter4 {
    public static void main(String[] args) {
        BinarySearchTree<Person> tree = new BinarySearchTree<>();
        var list = PersonDataProvider.provide();
        IntStream.rangeClosed(0,10).forEach(i->{
            tree.insert(list.get(i));
        });
        System.out.println(tree);
    }
}
