package az.rock.lesson.cp9;

import az.rock.lesson.cp9.concretes.BNode;
import az.rock.lesson.cp9.concretes.Record;
import lombok.Getter;
import lombok.Setter;

import java.util.Arrays;

import static az.rock.lesson.cp9.AbstractBNode.NilNode.NIL;

@Getter
@Setter
//2-3 BTree
public abstract class AbstractBNode<T extends Comparable<T>>  {

    protected AbstractBNode<T> parent;
    protected int degree;
    protected  Record<T>[] records;
    protected  AbstractBNode<T>[] pointers;

    public AbstractBNode(T value) {
        this.degree = 2;
        this.records = new Record[degree - 1];
        this.pointers = new AbstractBNode[degree];
        this.records[0] = Record.of(value);
        Arrays.fill(this.pointers, NIL);
    }

    public AbstractBNode<T> insert(T value){
        if (isLeaf()) {
            if (isFull()) {
                return split(value);
            }else {
                return insertNonFull(value);
            }
        }else {
            int i = 0;
            while (i < degree - 1 && records[i] != null && value.compareTo(records[i].getValue()) > 0) {
                i++;
            }
            if (pointers[i] != null) {
                return pointers[i].insert(value);
            }
        }
        return null;
    }

    private AbstractBNode<T> insertNonFull(T value) {
        int i = degree - 2;
        if (isLeaf()) {
            while (i >= 0 && records[i] != null && value.compareTo(records[i].getValue()) < 0) {
                records[i + 1] = records[i];
                i--;
            }
            records[i + 1] = Record.of(value);
        }else {
            while (i >= 0 && records[i] != null && value.compareTo(records[i].getValue()) < 0) {
                i--;
            }
            if (pointers[i + 1].isFull()) {
                AbstractBNode<T> split = pointers[i + 1].split(value);
                if (value.compareTo(records[i + 1].getValue()) > 0) {
                    i++;
                }
                split.insertNonFull(value);
            }else {
                pointers[i + 1].insertNonFull(value);
            }
        }
        return null;
    }

    private AbstractBNode<T> split(T value) {
        AbstractBNode<T> left = new BNode<>(records[0].getValue());
        AbstractBNode<T> right = new BNode<>(records[1].getValue());
        left.setPointers(new AbstractBNode[]{pointers[0], pointers[1]});
        right.setPointers(new AbstractBNode[]{pointers[2], pointers[3]});
        if (parent == null) {
            parent = new BNode<>(records[1].getValue());
        }
        parent.setRecords(new Record[]{Record.of(records[1].getValue())});
        parent.setPointers(new AbstractBNode[]{left, right});
        return parent;
    }

    public Boolean isFull() {
        return records[degree - 2] != null;
    }

    public Boolean isLeaf() {
        return pointers[0] instanceof NilNode;
    }

    public Boolean isNil() {
        return this instanceof NilNode;
    }






    public static class NilNode<T extends Comparable<T>> extends AbstractBNode<T> {
        public static final NilNode NIL = new NilNode();
        public NilNode() {
            super(null);
        }

        @Override
        public AbstractBNode<T> insert(T value) {
            return null;
        }
    }

}
