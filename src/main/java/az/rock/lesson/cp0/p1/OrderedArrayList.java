package az.rock.lesson.cp0.p1;

import az.rock.lesson.cp0.OrderedList;
import lombok.NonNull;

import java.util.Comparator;
import java.util.function.Consumer;

public class OrderedArrayList <T extends Comparable<T>> implements OrderedList<T> {

    private static final int DEFAULT_CAPACITY = 10;
    private Knot<T>[] head;

    private Integer currentCapacity = DEFAULT_CAPACITY;
    private Integer nextEligibleIndex = 0;

    private Integer cursor = 0;



    public OrderedArrayList(){
        head = new Knot[DEFAULT_CAPACITY];
    }

    private Boolean isFull(){
        return nextEligibleIndex == currentCapacity;
    }

    private void ensureCapacity(){
        if(this.isFull()){
            currentCapacity = currentCapacity * 2;
            Knot<T>[] newHead = new Knot[currentCapacity];
            for(int i = 0; i < head.length; i++){
                newHead[i] = head[i];
            }
            head = newHead;
        }
    }

    public Boolean isEmpty(){
        return nextEligibleIndex == 0;
    }


    @Override
    public void add(T element) {
        this.ensureCapacity();
        this.addOrdered(element);
        nextEligibleIndex++;
    }

    private Knot<T> fetch(Integer index){
        if (index < 0 || index >= nextEligibleIndex){
            return null;
        }
        return head[index];
    }

    private void addOrdered(T element){
        var knot = Knot.<T>of(element);
        if (isEmpty()){
            head[0] = knot;
        }else {
            for(int i = 0; i < nextEligibleIndex; i++){
                if (this.fetch(i).isGreaterThan(knot)){
                    for(int j = nextEligibleIndex; j > i; j--){
                        head[j] = head[j - 1];
                    }
                    head[i] = new Knot<>(element);
                    return;
                }
            }
            head[nextEligibleIndex] = new Knot<>(element);
        }
    }

    @Override
    public void remove(T element) {

    }

    @Override
    public void forEach(Consumer<T> consumer) {

    }

    @Override
    public void get(T element) {

    }

    @Override
    public void clear() {

    }


    public static class Knot <T extends Comparable<T>> implements Comparable<Knot<T>>{
        private T value;

        private Knot(T value){
            this.value = value;
        }

        public T value(){
            return value;
        }

        public static <T extends Comparable<T>> Knot<T> of(T value){
            if (value == null) return new NilKnot<>();
            return new Knot<>(value);
        }

        public Boolean isNil(){
            return value == null;
        }

        @Override
        public int compareTo(@NonNull Knot<T> o) {
            if (this.value == null && o.value == null)
                return 0;
            if (this.value == null) return -1;
            if (o.value == null) return 1;
            return this.value.compareTo(o.value);
        }

        public Boolean isGreaterThan(Knot<T> o){
            return this.compareTo(o) > 0;
        }

        public Boolean isLessThan(Knot<T> o){
            return this.compareTo(o) < 0;
        }

        public Boolean isEqualTo(Knot<T> o){
            return this.compareTo(o) == 0;
        }

        public Boolean isGreaterThanOrEqualTo(Knot<T> o){
            return this.compareTo(o) >= 0;
        }

        public static class NilKnot<T extends Comparable<T>> extends Knot<T>{
            public NilKnot(){
                super(null);
            }

            @Override
            @SuppressWarnings("all")
            public int compareTo(@NonNull Knot<T> o) {
                if (o.isNil()) return 0;
                else return -1;
            }

            @Override
            public Boolean isGreaterThanOrEqualTo(Knot<T> o) {
                return o.isNil();
            }

            @Override
            public Boolean isGreaterThan(Knot<T> o) {
                return Boolean.FALSE;
            }

            @Override
            public Boolean isLessThan(Knot<T> o) {
                if (!o.isNil()) return Boolean.TRUE;
                return Boolean.FALSE;
            }

            @Override
            public Boolean isEqualTo(Knot<T> o) {
                return o.isNil();
            }

            @Override
            public Boolean isNil() {
                return Boolean.TRUE;
            }
        }
    }
}
