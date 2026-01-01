package Practic.V2;

import java.util.PriorityQueue;

public class ConnectRopes {
    static class Pair {
        int a;
        int b;

        Pair(int a, int b){
            this.a = a;
            this.b = b;
        }

    }
    public static void main(String[] args) {
        System.out.println(fun(new int[]{10}));
    }
    static int fun(int[] arr){
        PriorityQueue<Pair> minHeap = new PriorityQueue<>((p1, p2) -> Integer.compare(p1.a, p2.a));
        int i=0;
        while (i< arr.length){
            minHeap.add(new Pair(arr[i], 0 ));
            i++;
        }
        while(minHeap.size()!=1){
            Pair first = minHeap.poll();
            Pair second = minHeap.poll();

            // Calculate the combined length and cost
            int combinedLength = first.a + second.a;
            int combinedCost = first.b + second.b + combinedLength;
            minHeap.add(new Pair(combinedLength,combinedCost));
        }
        return minHeap.poll().b;

    }
}
