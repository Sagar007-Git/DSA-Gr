package SlidingWindow;

import java.util.ArrayList;
import java.util.Arrays;

public class MaxOfAllSubarrays {
    public static void main(String[] args) {
        int[] arr = {1, 3, 2, 1, 7, 3};
        int k = 3;
        System.out.println(Arrays.toString(fun(arr,k)));
    }

    static int[] fun(int[] arr, int k){
        int[] res = new int[arr.length-k+1];
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < arr.length; i++) {
            int max = Integer.MIN_VALUE;
            list.add(arr[i]);
            if(i>=k-1){
                int j = 0;
                while (j<list.size()){
                    if (max< list.get(j)){
                        max = list.get(j);
                    }
                    j++;
                }
                res[i-k+1] = max;
                list.removeFirst();
            }
        }

        return res;
    }
}
