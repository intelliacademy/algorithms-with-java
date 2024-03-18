package az.rock.lesson.cp8.imps.max;

import java.util.Arrays;
import java.util.function.Consumer;

@SuppressWarnings("unchecked")
public class MaxHeap<T extends Comparable<T>> {
    private static final int INITIAL_CAPACITY = 10;
    private HeapNode<T>[] heap;
    private int size;


    public MaxHeap() {
        heap = new HeapNode[INITIAL_CAPACITY];
        this.size = 0;
    }

    public MaxHeap(int capacity) {
        heap = new HeapNode[capacity];
        this.size = 0;
    }

    public void add(T value) {
        ensureCapacity();
        heap[size] = new HeapNode<>(value, size);
        size++;
        heapifyUp();
    }

    public void ensureCapacity() {
        if(size == heap.length) {
            HeapNode<T>[] old = heap;
            heap = new HeapNode[(int) (heap.length * 1.75)];
            System.arraycopy(old, 0, heap, 0, size);
        }
    }

    public void heapifyUp() {
        int index = size - 1;
        while(hasParent(index) && heap[index].compareTo(heap[(index - 1) / 2]) > 0) {
            swap(index, (index - 1) / 2);
            index = (index - 1) / 2;
        }
    }

    public void swap(int index1, int index2) {
        HeapNode<T> temp = heap[index1];
        heap[index1] = heap[index2];
        heap[index2] = temp;
    }

    public void foreach(Consumer<T> consumer) {
        for (HeapNode<T> t : heap) {
            consumer.accept(t.getValue());
        }
    }

    public HeapNode<T> peek() {
        if(size == 0) throw new IllegalStateException();
        return heap[0];
    }

    public HeapNode<T> poll() {
        if(size == 0) throw new IllegalStateException();
        HeapNode<T> temp = heap[0];
        heap[0] = heap[size - 1];
        heap[size - 1] = null;
        size--;
        heapifyDown();
        return temp;
    }

    public void heapifyDown() {
        int index = 0;
        while(hasLeftChild(index)) {
            int largerChildIndex = (hasRightChild(index) && heap[(index * 2) + 2].compareTo(heap[(index * 2) + 1]) > 0) ? (index * 2) + 2 : (index * 2) + 1;
            if(heap[index].compareTo(heap[largerChildIndex]) > 0) break;
            swap(index, largerChildIndex);
            index = largerChildIndex;
        }
    }

    private void remove(int index) {
        if(index < 0 || index >= size) throw new IllegalArgumentException();
        heap[index] = heap[size - 1];
        heap[size - 1] = null;
        size--;
        heapifyDown();
    }

    public void remove(T value) {
        for (int i = 0; i < size; i++) {
            if(heap[i].getValue().equals(value)) {
                remove(i);
                return;
            }
        }
    }

    @Override
    public String toString() {
        return "MaxHeap{" +
                "heap=" + Arrays.toString(heap) +
                '}';
    }

    public Boolean hasParent(int index){
        return this.heap[(index - 1) / 2] != null;
    }

    public Boolean hasLeftChild(int index){
        return this.heap[(index * 2) + 1] != null;
    }

    public Boolean hasRightChild(int index){
        return this.heap[(index * 2) + 2] != null;
    }
}
