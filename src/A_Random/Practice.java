package A_Random;

import java.util.Arrays;
import java.util.Scanner;

public class Practice {
    public static void main(String[] args) {
        int[] arr = {2, 3, 4, 5, 6, 9};
        int i=0;
        int j=arr.length-1;
        while (i<j){
            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
            i++;
            j--;
        }

        System.out.println(Arrays.toString(arr));
    }
}
