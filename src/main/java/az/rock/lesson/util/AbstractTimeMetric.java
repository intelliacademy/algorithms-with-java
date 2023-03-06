package az.rock.lesson;

import java.awt.*;
import java.time.Duration;
import java.time.Instant;
import java.util.List;

public abstract class AbstractTimeMetric<T> implements Sort<T>{

    public List<T> sortAsMetric(List<T> list){
        var startInstant = Instant.now();
        var result =  this.sort(list);
        var endInstant = Instant.now();
        int duration = Duration.between(startInstant,endInstant).getNano();
        System.err.println("-------------Execute time : " + duration + "------------");
        return result;
    }
}
