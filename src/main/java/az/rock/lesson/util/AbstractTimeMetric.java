package az.rock.lesson.util;

import java.time.Duration;
import java.time.Instant;
import java.util.List;

public abstract class AbstractTimeMetric<T extends Comparable<T>> implements Sort<T>{

    public List<T> sort(List<T> list){
        var startInstant = Instant.now();
        var result =  this.execute(list);
        var endInstant = Instant.now();
        long duration = Duration.between(startInstant,endInstant).getNano();
        System.err.println("-------------Execute time : " + duration + " ns------------");
        return result;
    }
}
