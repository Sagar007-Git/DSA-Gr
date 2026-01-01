package Practic.V2;

import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Stack;

public class KSmallestElement {
    public static void main(String[] args) {
        System.out.println(fun(new int[]{7, 10, 4, 3, 20, 15},4));

    }
    static int fun(int[] arr, int k){
        int i=0;
        PriorityQueue<Integer> minHeap = new PriorityQueue<>(Collections.reverseOrder());
        while (i< arr.length){
            minHeap.add(arr[i]);
            if(minHeap.size()>k){
                minHeap.poll();
            }
            i++;
        }
        return minHeap.peek();
    }
}
