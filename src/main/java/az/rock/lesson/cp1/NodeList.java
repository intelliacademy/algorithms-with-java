package az.rock.lesson.cp1;

import java.util.List;
import java.util.function.Consumer;

public class NodeList <D> {
    private Node<D> node;

    public void add(D data){
        if (this.node != null)
            this.node.addNext(data);
        else this.node = new Node<>(data);
    }

    public void forEach(Consumer<D> consumer){
        this.node.iterate(consumer);
    }


}
