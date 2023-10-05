package az.rock.lesson.cp1;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.Consumer;
import java.util.function.Predicate;

public class NodeList <D> {

    private final AtomicInteger size = new AtomicInteger(0);
    private Node<D> node;

    public void add(D data){
        if (this.node != null)
            this.node.addNext(data);
        else this.node = new Node<>(data);
        this.size.incrementAndGet();
    }

    public Integer size(){
        return this.size.get();
    }

    public void removeFirst(){
        var nextNode = this.node.getNext();
        if (nextNode != null)
            this.node = this.node.getNext();
        else this.node = null;
        this.size.decrementAndGet();
    }

    public void  remove(D data){
        this.forEachOnNodes(item-> {
            if (item.getData().equals(data)) item.remove();
        });
        this.size.decrementAndGet();
    }

    public void forEach(Consumer<D> consumer){
        this.node.iterate(consumer);
    }

    public void forEachOnNodes(Consumer<Node<D>> consumer){
        this.node.iterateOnNodes(consumer);
    }


}
