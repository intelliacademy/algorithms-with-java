package az.rock.lesson.sort;

import az.rock.lesson.util.AbstractTimeMetric;
import az.rock.lesson.util.PersonDataProvider;
import az.rock.lesson.model.Person;

import java.util.List;

public class SortAlgorithmTestMain {

    static List<Person> unsortedPersonList = PersonDataProvider.provide();
    static AbstractTimeMetric<Person> algorithm = new RadixSort<>();

    public static void main(String[] args) {
        List<Person> sortedList = algorithm.sortAsMetric(unsortedPersonList);
        sortedList.forEach(e->System.out.println(e.getFirstName() + " " + e.getSalary()));
    }
}
