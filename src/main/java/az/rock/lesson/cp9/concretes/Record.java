package az.rock.lesson.cp9.concretes;

import java.util.Objects;

public class Record<T> {
    private final int index;
    private final T value;

    private Record(T value) {
        this(value != null ? value.hashCode() : 0, value);
    }

    private Record(int index,T value) {
        this.index = index;
        this.value = value;
    }

    public static <T> Record<T> of(T value) {
        return new Record<>(value);
    }

    public static <T> Record<T> of(int index, T value) {
        return new Record<>(index, value);
    }

    public static <T> Record<T> of(Record<T> record) {
        return new Record<>(record.index, record.value);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Record<?> record)) return false;
        return getIndex() == record.getIndex();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getIndex(), getValue());
    }

    public T getValue() {
        return value;
    }

    public int getIndex() {
        return index;
    }

    public static <T> Record<T> nil() {
        return (Record<T>) NilRecord.NIL;
    }

    @Override
    public String toString() {
        return "Record[" +value +"]";
    }

    public boolean isNotNull() {
        return this != NilRecord.NIL;
    }

    public boolean isNil() {
        return this == NilRecord.NIL;
    }

    public static class NilRecord<T> extends Record<T> {
        public static final NilRecord<?> NIL = new NilRecord<>();

        private NilRecord() {
            super(-1, null);
        }

        @Override
        public String toString() {
            return "NilRecord";
        }
    }
}
