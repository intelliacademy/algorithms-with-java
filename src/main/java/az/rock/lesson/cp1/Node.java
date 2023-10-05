package az.rock.lesson.cp1;

import java.util.function.Consumer;
import java.util.function.Predicate;

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

    public void changeNextNode(Node<D> next){
        this.next = next;
    }

    public void changePrevious(Node<D> previous){
        this.previous = previous;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Node<?> node)
            return node.data.equals(this);
        return false;
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

    public Node<D> iterateOnNodes(Consumer<Node<D>> consumer){
        if (this.hasNext()) {
            var node = this.getNext().iterateOnNodes(consumer);
            consumer.accept(node);
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
        this.addNext(next);
    }

    public void remove(){
        var prevNode = this.getPrevious();
        var nextNode = this.getNext();
        if (prevNode != null) prevNode.changeNextNode(nextNode);
        if (nextNode != null) nextNode.changePrevious(prevNode);
    }

    public void displayNode() {
        System.out.println("{ " + data + " } ");
    }
}
