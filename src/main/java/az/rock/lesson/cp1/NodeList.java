package az.rock.lesson.cp1;

import java.util.function.Consumer;
import java.util.function.Predicate;

public class NodeList <D> {
    private Node<D> node;

    public void add(D data){
        if (this.node != null)
            this.node.addNext(data);
        else this.node = new Node<>(data);
    }

    public void removeFirst(){
        var nextNode = this.node.getNext();
        if (nextNode != null)
            this.node = this.node.getNext();
        else this.node = null;
    }

    public void  remove(D data){
        this.forEachOnNodes(item-> {
            if (item.getData().equals(data)) item.remove();
        });
    }

    public void forEach(Consumer<D> consumer){
        this.node.iterate(consumer);
    }

    public void forEachOnNodes(Consumer<Node<D>> consumer){
        this.node.iterateOnNodes(consumer);
    }




}
