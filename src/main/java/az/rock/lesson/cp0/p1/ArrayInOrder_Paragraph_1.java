package az.rock.lesson.cp0.p1;

public class ArrayInOrder_Paragraph_1 {
    public static void main(String[] args) {
        Integer[] reverseArray = {12,2,34,22,98,0,0,1,67};
        var orderedArrayList = new OrderedArrayList<Integer>();
        for (Integer integer : reverseArray) {
            orderedArrayList.add(integer);
        }
        orderedArrayList.forEach(System.out::println);
    }
}
