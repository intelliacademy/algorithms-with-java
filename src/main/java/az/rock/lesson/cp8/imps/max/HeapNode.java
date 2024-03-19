package az.rock.lesson.cp8.imps.max;

public final class HeapNode <T extends Comparable<T>> implements Comparable<HeapNode<T>> {
    private final T value;
    private final int index;

    public HeapNode(T value, int index) {
        this.value = value;
        this.index = index;
    }

    public static <T extends Comparable<T>> HeapNode<T> of(HeapNode<T> node, int index) {
        return new HeapNode<>(node.getValue(), index);
    }

    public Boolean isGreaterThan(HeapNode<T> node) {
        return this.compareTo(node) > 0;
    }

    public Boolean isLessThan(HeapNode<T> node) {
        return this.compareTo(node) < 0;
    }

    public Boolean isEqualTo(HeapNode<T> node) {
        return this.compareTo(node) == 0;
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
