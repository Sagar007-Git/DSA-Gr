package Practic;

import java.util.Arrays;

public class swapArray {
    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5,6,9};
        int start = 0;
        int last = arr.length-1;

        while(start<last){
            int temp = arr[start];
            arr[start] = arr[last];
            arr[last] = temp;
            start++;
            last--;
        }

        System.out.println(Arrays.toString(arr));
    }
}
