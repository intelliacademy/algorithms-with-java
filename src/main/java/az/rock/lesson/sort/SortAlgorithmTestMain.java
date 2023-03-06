package az.rock.lesson.sort.selection;

import az.rock.csv4j.exception.CSVHeaderNotFoundException;
import az.rock.csv4j.exception.ElementManyAnnotatedException;
import az.rock.csv4j.manager.CSVManager;
import az.rock.lesson.model.Person;

import java.util.List;

public class SelectionSortTestMain {

    public static void main(String[] args) {
        SelectionSort<Person> selectionSort = new SelectionSort<>();
        CSVManager<Person> csvManager;
        List<Person> personList;
        try {
            csvManager = new CSVManager<>(Person.class,"MOCK_DATA.csv");
            personList = csvManager.load();
        } catch (CSVHeaderNotFoundException | ElementManyAnnotatedException e) {
            throw new RuntimeException(e);
        }

        List<Person> sortedList = selectionSort.sortAsMetric(personList);
        sortedList.forEach(System.out::println);


    }
}
