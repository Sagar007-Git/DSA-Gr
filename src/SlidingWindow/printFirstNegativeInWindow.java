package SlidingWindow;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class printFirstNegativeInWindow {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(fun(new int[]{-10, 20, -30, -40, 50, 60, -70, 80, 90}, 3)));
    }

    static int[] fun(int[] arr, int k){
        int[] res  = new int[arr.length -k +1];
        Queue<Integer> list  =  new LinkedList<>();

        for (int i = 0; i < arr.length; i++) {

            while (!list.isEmpty() && list.peek()<=i-k){
                list.remove();
            }

            if(arr[i]<0){
                list.add(i);
            }

            if(i>= k-1){
                res[i-k+1] = list.isEmpty() ? 0 : arr[list.peek()];
            }
        }
        return res;
    }
}
