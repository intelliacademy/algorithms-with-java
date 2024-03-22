package az.rock.lesson.cp0.p1;

public class ArrayInOrder_Paragraph_1 {
    public static void main(String[] args) {
        Integer[] reverseArray = {5, 4, 3, 2, 1};
        var orderedArrayList = new OrderedArrayList<Integer>();
        for (Integer integer : reverseArray) {
            orderedArrayList.add(integer);
        }
        orderedArrayList.forEach(System.out::println);
    }
}
