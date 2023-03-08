package az.rock.lesson.sort;

import az.rock.lesson.sort.insertion.InsertionSort;
import az.rock.lesson.util.PersonDataProvider;
import az.rock.lesson.model.Person;
import az.rock.lesson.sort.selection.SelectionSort;

import java.util.List;

public class SortAlgorithmTestMain {

    static List<Person> personList = PersonDataProvider.provide();

    public static void main(String[] args) {
        //SelectionSort<Person> algorithm = new SelectionSort<>();
        InsertionSort<Person> algorithm = new InsertionSort<>();

        List<Person> sortedList = algorithm.sortAsMetric(personList);
        sortedList.forEach(e->System.out.println(e.getFirstName() + " " + e.getSalary()));
    }
}
