package az.rock.lesson.sort.selection;

import az.rock.lesson.util.AbstractTimeMetric;

import java.util.List;

public class SelectionSort<T extends  Cloneable & Comparable<T> > extends AbstractTimeMetric<T> {


    private T template;
    private T min;

    @Override
    public List<T> sort(List<T> list) {
        for (var i = 0;i < list.size() - 1; i++){
            this.min = list.get(i);
            for (var j = i; j < list.size(); j++){
                if (list.get(j).compareTo((this.min)) < 0)
                    this.min = list.get(j);
            }
            this.template = list.get(i);
            list.set(list.indexOf(this.min),list.get(i));
            list.set(i,this.min);
        }
        return list;
    }


}
