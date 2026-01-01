package Practic.V2;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.PriorityQueue;

public class SortingArray {
    public static void main(String[] args) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>(Collections.reverseOrder());
        minHeap.add(12);
        minHeap.add(2);
        minHeap.add(125);
        minHeap.add(162);
        minHeap.add(8);
        minHeap.add(78);
        System.out.println(minHeap.peek());
    }
}
