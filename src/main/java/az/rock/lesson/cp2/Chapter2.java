package az.rock.lesson.cp2;

import az.rock.lesson.cp1.NodeList;
import az.rock.lesson.model.Person;
import az.rock.lesson.util.PersonDataProvider;

public class Chapter2 {
    public static void main(String[] args) {
        Stack<Person> personStack = new Stack<>();
        var list = PersonDataProvider.provide();
        list.forEach(item->{
            personStack.push(item);
        });

        personStack.forEach(System.out::println);
        System.out.println(personStack.size());
    }
}
