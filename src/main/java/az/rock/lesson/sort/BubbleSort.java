package az.rock.lesson.sort;

import az.rock.lesson.util.AbstractTimeMetric;

import java.util.List;
import java.util.stream.IntStream;

public class BubbleSort  <T extends Comparable<T> & Cloneable> extends AbstractTimeMetric<T> {

    @Override
    public List<T> sort(List<T> list) {
        int n = list.size();
        IntStream.range(0,n).forEach(iIndex->{
            IntStream.range(1,n-iIndex).forEach(jIndex->{
                if (list.get(jIndex-1).compareTo(list.get(jIndex)) > 0){
                    var temp = list.get(jIndex);
                    list.set(jIndex,list.get(jIndex-1));
                    list.set(jIndex-1,temp);
                }
            });
        });
        return list;
    }

}
