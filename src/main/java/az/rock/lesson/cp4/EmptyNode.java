package az.rock.lesson.cp4;

public class EmptyNode extends BinaryNode{


    private EmptyNode(Comparable<?> element) {
        super(element);
    }

    @Override
    public Comparable remove(Comparable element) {
        return null;
    }

    private static EmptyNode INSTANCE = new EmptyNode(null);
    private static EmptyNode ROOT_INSTANCE = new EmptyNode(null);

    public static <T,S extends Comparable<T>> EmptyNode getInstance(BinaryNode parent){
        INSTANCE.setParent(parent);
        return INSTANCE;
    }

    public static <T,S extends Comparable<T>> EmptyNode getInstance(){
        return ROOT_INSTANCE;
    }

    @Override
    public void add(Comparable element) {

    }

    @Override
    public Boolean isEmpty() {
        return Boolean.TRUE;
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
