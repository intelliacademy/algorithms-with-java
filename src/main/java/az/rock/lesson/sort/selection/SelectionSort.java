package az.rock.lesson.sort.selection;

import az.rock.lesson.util.AbstractTimeMetric;

import java.util.List;
import java.util.stream.IntStream;

public class SelectionSort<T extends  Cloneable & Comparable<T> > extends AbstractTimeMetric<T> {


    private T template;
    private T min;

    @Override
    public List<T> sort(List<T> list) {
        IntStream.range(0,list.size())
                .forEach(index->{
                    this.min = list.get(index);
                    IntStream.range(index,list.size()).forEach(jIndex->{
                        if (list.get(jIndex).compareTo(this.min) < 0){
                            this.min = list.get(jIndex);
                        }
                    });
                    this.template = list.get(index);
                    var minIndex = list.indexOf(this.min);
                    list.add(index,this.min);
                    list.add(minIndex,this.template);
                });
        return list;
    }


}
