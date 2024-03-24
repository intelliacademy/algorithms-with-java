package az.rock.lesson.cp0.p3;

import java.util.Arrays;

public class BubbleSort_Paragraph_3 {
    public static void main(String[] args) {
        Integer[] unsorted = { 9, 5, 7, 3, 1, 2, 8, 6, 4 };
        IBubbleSort<Integer> bubbleSort = new IBubbleSort<>();
        Integer[] sorted = bubbleSort.executeArr(unsorted);
        System.out.println("Sorted array: " + Arrays.toString(sorted));
    }
}
