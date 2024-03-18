package az.rock.lesson.cp8.imps.max;

public class HeapNode <T extends Comparable<T>> implements Comparable<HeapNode<T>> {
    private T value;
    private int index;

    public HeapNode(T value, int index) {
        this.value = value;
        this.index = index;
    }


    public T getValue() {
        return value;
    }

    public int getIndex() {
        return index;
    }

    @Override
    public int compareTo(HeapNode<T> o) {
        return this.value.compareTo(o.value);
    }

    @Override
    public String toString() {
        return "HeapNode{" +
                "value=" + value +
                ", index=" + index +
                '}';
    }
}
