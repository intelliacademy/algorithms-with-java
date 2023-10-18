package az.rock.lesson.cp5;

public interface Node <T extends Comparable<T>>{
    void insert(T data);
    void remove(T data);
    void traversal();
    T getMaxValue();
    T getMinValue();
    Boolean isLeaf();
    Boolean hasLeftChild();
    Boolean hasRightChild();
    Boolean hasAnyChild();
    Boolean hasBothChildren();
    void balance();
    void setBalance(int balance);
    int getBalance();
    void rotateRight();
    void rotateLeft();
}
