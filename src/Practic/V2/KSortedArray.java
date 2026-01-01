package Practic.V2;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Stack;

public class KSortedArray {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(sort(new int[]{1, 4, 5, 2, 3, 6, 7, 8, 9, 10},2)));
    }

    static int[] sort(int[] arr,int k){
        PriorityQueue<Integer> stack = new PriorityQueue<>();
        int i=0;
        int j=0;
        while(i< arr.length ){
            while (stack.size()<=k){
                stack.add(arr[i++]);
            }
            arr[j++] = stack.poll();
        }
        while(stack.isEmpty()){
            arr[j++] = stack.poll();
        }
        return arr;
    }
}
