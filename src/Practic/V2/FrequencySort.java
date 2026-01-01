package Practic.V2;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class FrequencySort {
    static class Pair {
        int a;
        int b;

        Pair(int a, int b){
            this.a = a;
            this.b = b;
        }

    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(fun(new int[]{2,5, 2, 8, 5, 6, 8, 8})));
    }

    static  int[] fun(int[] arr){

        PriorityQueue<Pair> minHeap = new PriorityQueue<>(Comparator.comparingInt(p->p.a));

        Arrays.sort(arr);
        int i=0;
        int count =0;
        int a = arr[i];
        while(i< arr.length){
            if(a==arr[i]){
                count++;
            } else {
                int temp = count;
                minHeap.add(new Pair(temp,a));
                a = arr[i];
                count=1;
            }
            i++;
        }

        while (!minHeap.isEmpty()){
            int num = minHeap.peek().b;
            int freq = minHeap.poll().a;
            for (int j = 0; j < freq; j++) {
                arr[j] = num;
            }
        }
        return  arr;

    }
}
