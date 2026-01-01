package Practic;

import java.util.Arrays;
import java.util.Scanner;

public class InputArray {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int len = scan.nextInt();
        int[] arr = new int[len];

        for (int i = 0; i < len; i++) {
            arr[i] = scan.nextInt();
        }

        System.out.println(Arrays.toString(arr));

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
