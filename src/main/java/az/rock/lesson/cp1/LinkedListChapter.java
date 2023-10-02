package az.rock.lesson.cp1;

import az.rock.lesson.model.Person;
import az.rock.lesson.util.PersonDataProvider;

import java.util.List;

public class LinkedListChapter {
    public static void main(String[] args) {
        Node<Person> node1 = Node.of();

        PersonDataProvider.provide().forEach(item->{
            node1.addNext(item);
        });
        System.out.println();
    }
}
