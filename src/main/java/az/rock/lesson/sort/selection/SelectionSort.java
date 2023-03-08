package az.rock.lesson.sort.selection;

import az.rock.lesson.util.AbstractTimeMetric;

import java.util.List;
import java.util.stream.IntStream;

public class SelectionSort<T extends  Cloneable & Comparable<T> > extends AbstractTimeMetric<T> {

    private T min;

    @Override
    public List<T> sort(List<T> list) {
        IntStream.range(0,list.size() - 1).forEach(iIndex->{
                    this.min = list.get(iIndex);
                    IntStream.range(iIndex,list.size()).forEach(jIndex->{
                        if (list.get(jIndex).compareTo(this.min) < 0)
                            this.min = list.get(jIndex);
                    });
                    list.set(list.indexOf(this.min),list.get(iIndex));
                    list.set(iIndex,this.min);
            }
        );
        return list;
    }


}
