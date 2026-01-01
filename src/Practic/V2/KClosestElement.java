package Practic.V2;
//
//import java.util.Arrays;
//import java.util.Comparator;
//import java.util.PrimitiveIterator;
//import java.util.PriorityQueue;
//
//public class KClosestElement {
//    int a;
//    int b;
//
//    KClosestElement(int a,int b){
//        this.a = a;
//        this.b = b;
//    }
//    public static void main(String[] args) {
//        System.out.println(Arrays.toString(fun(new int[]{12, 16, 22, 30, 35, 39, 42, 45, 48, 50, 53, 55, 56},4,35)));
//    }
//    static int[] fun(int[] arr, int k,int x){
//        PriorityQueue<KClosestElement> stack = new PriorityQueue<>(Comparator.comparingInt(p -> p.a));
//        int i=0;
//        while(i< arr.length){
//            stack.add(new KClosestElement(Math.abs(x - arr[i]),arr[i]));
//            if(stack.size()>k){
//             stack.poll();
//            }
//            i++;
//        }
//
//        int[] res = new int[k];
//        int j=0;
//        while (!stack.isEmpty()){
//            res[j] = stack.poll().b;
//            j++;
//        }
//        return res;
//    }
//}

import java.util.Arrays;
import java.util.PriorityQueue;

public class KClosestElement {


    static class Pair implements Comparable<Pair> {
        int absDiff;
        int ind;

        Pair(int f, int s) {
            absDiff = f;
            ind = s;
        }

        @Override
        public int compareTo(KClosestElement.Pair o)
        {
            // If there are two elements with the same
            // difference with X, the greater element is
            // given priority.
            if (absDiff == o.absDiff)
                return ind - o.ind;
            else
                return o.absDiff - absDiff;
        }
    }

    public static void main(String[] args) {
        int[] arr = new int[]{12, 16, 22, 30, 35, 39, 42, 45, 48, 50, 53, 55, 56};
        System.out.println(Arrays.toString(printKClosest(arr, arr.length, 4,35)));
    }

    static int[] printKClosest(int[] nums, int n, int k,
                               int x) {
        PriorityQueue<Pair> maxHeap = new PriorityQueue<>();
        for (int i = 0; i < nums.length; i++) {
            int diff = Math.abs(nums[i] - x);
            //if nums[i] == x then no need to consider that element
            if (diff != 0)
                maxHeap.add(new Pair(diff, i));

            if (maxHeap.size() > k)
                maxHeap.poll();
        }
        int ans[] = new int[k];
        int j = 0;
        while (!maxHeap.isEmpty()) {
            //Add the remaining elements to the answer
            ans[j] = nums[maxHeap.poll().ind];
            j++;
        }
        return ans;
    }
}
