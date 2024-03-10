package az.rock.lesson.cp9.concretes;

import az.rock.lesson.cp9.abstracts.AbstractBTree;
import lombok.Getter;
import lombok.Setter;

import java.util.Arrays;



public class BMinusTree<T extends Comparable<T>> implements AbstractBTree<T> {
    private AbstractBNode<T> root;

    @Override
    public void insert(T value) {
        AbstractBNode<T> node  = new AbstractBNode.BNode(value);
        if (root == null) {
            root = node;
        }else {
            AbstractBNode<T> current = root;
            while (!current.isLeaf()) {
                current = current.insert(value);
            }
        }
    }

    @Getter
    @Setter
    //2-3 BTree
    public abstract static class AbstractBNode<T extends Comparable<T>>  {

        protected AbstractBNode<T> parent;
        protected int degree;
        protected  Record<T>[] records;
        protected  AbstractBNode<T>[] pointers;

        public AbstractBNode(T value) {
            this.degree = 2;
            this.records = new Record[degree - 1];
            this.pointers = new AbstractBNode[degree];
            this.records[0] = Record.of(value);
            Arrays.fill(this.pointers, new NilNode<>());
        }

        public Record<T> appendRecord(T value) {
            for (int i = 0; i < degree - 1; i++) {
                if (records[i] == null) {
                    records[i] = Record.of(value);
                    return records[i];
                }
            }
            return Record.nil();
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
            return null;
        }

        private AbstractBNode<T> split(T value) {
            return null;
        }

        public Boolean isFull() {
            return records[degree - 2] != null;
        }

        public Boolean isLeaf() {
            return pointers[0] instanceof AbstractBNode.NilNode;
        }

        public Boolean isNil() {
            return this instanceof AbstractBNode.NilNode;
        }


        @Override
        public String toString() {
            return "AbstractBNode{" +
                    "records=" + Arrays.toString(records) +
                    ", pointers=" + Arrays.toString(pointers) +
                    '}';
        }

        public static class BNode <T extends Comparable<T>> extends AbstractBNode<T> {

            public BNode(T value) {
                super(value);
            }


        }

        public class NilNode<T extends Comparable<T>> extends AbstractBNode<T> {
            public NilNode() {
                super(null);
            }

            @Override
            public AbstractBNode<T> insert(T value) {
                return null;
            }

            @Override
            public String toString() {
                return "NIL";
            }
        }

    }

}
