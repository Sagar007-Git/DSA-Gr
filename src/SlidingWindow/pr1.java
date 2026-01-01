package SlidingWindow;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class pr1 {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(fun(new int[]{-10, 20, -30, -40, 50, 60, -70, 80, 90}, 3)));
    }

    static int[] fun(int[] arr, int k){

        int[] res = new int[arr.length-k+1];
        Queue<Integer> list = new LinkedList<>();
        int j=0;

        for (int i = 0; i < k-1; i++) {
            if(arr[i]<0){
                list.add(i);
            }
        }

        for (int i = k-1; i < arr.length; i++) {

//            {-10, 20, -30, -40, 50, 60, -70, 80, 90}

                if(arr[i]<0){
                    list.add(i);
                }

                if (!list.isEmpty()){
                    res[j++] = list.peek()>=i-k+1 ? arr[list.peek()] : 0;
                }else {
                    res[j++] = 0;
                }

                if(!list.isEmpty() && list.peek()<=i-k+1){
                    list.poll();
                }

        }
        return  res;
    }
}
