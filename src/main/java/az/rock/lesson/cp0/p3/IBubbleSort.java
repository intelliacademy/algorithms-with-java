package az.rock.lesson.cp0.p3;

import az.rock.lesson.util.AbstractTimeMetric;
import az.rock.lesson.util.Cloneable;

public class IBubbleSort  <T extends Comparable<T>> extends AbstractTimeMetric<T> {

    @Override
    public T[] executeArr(T[] arr) {
        int n = arr.length;
        for (int cursor = 0;cursor < n - 1;cursor++){
            var current = arr[cursor];
            for (int next = cursor + 1;next < n;next++){
                if (arr[next].compareTo(current) < 0){
                    arr[cursor] = arr[next];
                    arr[next] = current;
                    current = arr[cursor];
                }
            }
        }
        return arr;
    }
}
