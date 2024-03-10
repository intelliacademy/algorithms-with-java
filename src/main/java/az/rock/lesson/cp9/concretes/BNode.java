package az.rock.lesson.cp9.concretes;

import az.rock.lesson.cp9.AbstractBNode;

public class BNode <T extends Comparable<T>> extends AbstractBNode<T> {
    
    public BNode(T value) {
        super(value);
    }


}
