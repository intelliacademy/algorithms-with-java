package az.rock.lesson.cp1;

import az.rock.lesson.model.Person;
import az.rock.lesson.util.PersonDataProvider;

import java.util.List;
import java.util.function.Consumer;

public class LinkedListChapter {
    public static void main(String[] args) {
        NodeList<Person> personNodeList = new NodeList<>();
        var list = PersonDataProvider.provide();
        list.forEach(item->{
            personNodeList.add(item);
        });

        list.forEach(item->personNodeList.remove(item));

        System.out.println(personNodeList.size());
//
//        Consumer<Person> personConsumer = System.out::print;
//        personNodeList.forEach(personConsumer);

    }
}
