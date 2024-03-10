package az.rock.lesson.cp9;

public abstract class AbstractBNode<T extends Comparable<T>> implements Comparable<AbstractBNode<T>> {

    @Override
    public int compareTo(AbstractBNode<T> o) {
        return 0;
    }
}
