package az.rock.lesson.cp4;

public class EmptyNode extends BinaryNode{


    private EmptyNode(Comparable<?> element) {
        super(element);
    }

    private static EmptyNode INSTANCE = new EmptyNode(null);

    public static <T,S extends Comparable<T>> EmptyNode getInstance(){
        return INSTANCE;
    }

    @Override
    public void add(Comparable element) {

    }

    @Override
    public int compareTo(BinaryNode o) {
        return -1;
    }

    @Override
    public String toString() {
        return "";
    }
}
