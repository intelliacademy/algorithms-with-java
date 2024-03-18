package az.rock.lesson.cp8;

import az.rock.lesson.cp8.imps.max.MaxHeap;

/**
 * The next element for binary selection 2n+1 (if 3 3n+1)
 * In this case for 2 next element that 2n+1 and 2n+2 and for 3 next elements 3n+1, 3n+2, 3n+3
 * When u want to find parent node then (n-1)/2 ( (n-1)/3 for 3 sub elements)
 *
 * For Max Heap Parent must be greater or equals than children
 * For Min Heap Parent must be less than children
 */
public class Chapter8_BinaryHeaps {
    public static void main(String[] args) {
        //Example of Max Heap
        int[] unsorded = {1, 8, 5, 7, 9, 2, 4, 6, 3, 10};
        MaxHeap<Integer> maxHeap1 = new MaxHeap<>();

        for (int i : unsorded) {
            maxHeap1.add(i);
        }

        System.out.print("Max Heap: " + maxHeap1);

        maxHeap1.remove(10);
        System.out.println("-------------------\n");
        System.out.print("Max Heap: " + maxHeap1);
    }
}
