package az.rock.lesson.cp0.p1;

import az.rock.lesson.cp0.OrderedList;
import lombok.NonNull;

import java.util.function.Consumer;

public class OrderedArrayList <T extends Comparable<T>> implements OrderedList<T> {

    private static final int DEFAULT_CAPACITY = 10;
    private Knot<T>[] head;
    private Integer currentCapacity = DEFAULT_CAPACITY;
    private Integer tailIndex = 0;

    private Integer cursor;

    public OrderedArrayList(){
        head = new Knot[DEFAULT_CAPACITY];
    }

    private Boolean isFull(){
        return tailIndex == currentCapacity;
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
        return tailIndex == 0;
    }


    @Override
    public void add(T element) {
        this.ensureCapacity();
        this.addDirect(element);
        tailIndex++;
    }

    private Knot<T> fetch(Integer index){
        if (index < 0 || index >= tailIndex) return Knot.ofNull();
        return head[index];
    }

    private void addOrdered(T element){
        var knot = Knot.<T>ofNullable(element);
        for(int i = 0; i < tailIndex; i++){
            if (this.fetch(i).isGreaterThan(knot)){
                for(int j = tailIndex; j > i; j--){
                    head[j] = head[j - 1];
                }
                head[i] = new Knot<>(element);
                return;
            }
        }
        head[tailIndex] = new Knot<>(element);
    }

    private void addDirect(T element){
        this.cursor = tailIndex;
        this.addRecursive(element, cursor);
    }

    private void addRecursive(T elemtent, Integer index){
        if (index == 0){
            head[index] = new Knot<>(elemtent);
            return;
        }
        if (this.fetch(index - 1).isLessThan(Knot.ofNullable(elemtent))){
            head[index] = new Knot<>(elemtent);
        } else {
            head[index] = head[index - 1];
            addRecursive(elemtent, index - 1);
        }
    }

    @Override
    public void remove(T element) {
        for(int i = 0; i < tailIndex; i++){
            if (head[i].isEqualTo(Knot.ofNullable(element))){
                for(int j = i; j < tailIndex - 1; j++){
                    head[j] = head[j + 1];
                }
                head[tailIndex - 1] = Knot.ofNull();
                tailIndex--;
                return;
            }
        }
    }

    @Override
    public void forEach(Consumer<T> visitorConsumer) {
        for(int i = 0; i < tailIndex; i++){
            head[i].consume(visitorConsumer);
        }
    }

    @Override
    public T get(T element) {
        for (int i = 0; i < tailIndex; i++){
            if (head[i].isEqualTo(Knot.ofNullable(element))){
                return head[i].value();
            }
        }
        return null;
    }

    @Override
    public void clear() {
        head = new Knot[currentCapacity];
        tailIndex = 0;
    }


    public static class Knot <T extends Comparable<T>> implements Comparable<Knot<T>>{
        private T value;

        private Knot(T value){
            this.value = value;
        }

        public T value(){
            return value;
        }

        public static <T extends Comparable<T>> Knot<T> ofNullable(T value){
            if (value == null) return new NilKnot<>();
            return new Knot<>(value);
        }

        public static <T extends Comparable<T>> Knot<T> ofNull(){
            return new NilKnot<>();
        }

        public Boolean isNil(){
            return value == null;
        }

        public void consume(Consumer<T> consumer){
            consumer.accept(value);
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
            public void consume(Consumer<T> consumer) {}

            @Override
            public T value() {
                throw new UnsupportedOperationException("Nil Knot has no value");
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
