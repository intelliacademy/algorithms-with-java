package az.rock.lesson.sort;

import az.rock.lesson.util.AbstractTimeMetric;
import az.rock.lesson.util.Cloneable;

import java.util.List;
import java.util.stream.IntStream;

public class InsertionSort <T extends Comparable<T> & Cloneable<T>> extends AbstractTimeMetric<T> {

    @Override
    public List<T> execute(List<T> list) {
        int n = list.size();
        IntStream.range(1,n).forEach(iIndex->{
            T key = list.get(iIndex);
            var jIndex = iIndex - 1;
            while ((jIndex > 0) && list.get(jIndex).compareTo(key) > 0){
                list.set(jIndex + 1, list.get(jIndex));
                --jIndex;
            }
            list.set(jIndex+1,key);
        });
        return list;
    }
}
