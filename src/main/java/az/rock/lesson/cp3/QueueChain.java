package az.rock.lesson.cp3;

public class QueueChain <D extends Comparable<D>>{
    private QueueChain<D> next;
    private QueueChain<D> previous;
}
