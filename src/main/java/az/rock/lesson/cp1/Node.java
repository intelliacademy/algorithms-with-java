package az.rock.lesson.cp1;

import java.util.function.Consumer;

public class Node <D>{
    private D data;
    private Node<D> next;
    private Node<D> previous;

    public static <D> Node<D> of(){
        return new Node<>(null);
    }

    public Node(D data) {
        this.data = data;
    }

    public D getData() {
        return data;
    }

    public void setData(D data) {
        this.data = data;
    }

    public Node<D> getNext() {
        return next;
    }

    public Node<D> getPrevious() {
        return previous;
    }

    public Boolean hasNext() {
        return next != null;
    }

    public Boolean hasPrevious() {
        return previous != null;
    }

    public Node<D> iterate(Consumer<D> consumer){
        if (this.hasNext()) {
            var node = this.getNext().iterate(consumer);
            consumer.accept(node.getData());
            return node;
        }
        else return this;
    }

    public void addNext(Node<D> next) {
        if (this.next == null) {
            this.next = next;
            next.previous = this;
        } else this.next.addNext(next);
    }

    public void addNext(D data) {
        var next = new Node<>(data);
        if (this.next == null) {
            this.next = next;
            next.previous = this;
        } else this.next.addNext(next);
    }

    public void displayNode() {
        System.out.println("{ " + data + " } ");
    }
}
