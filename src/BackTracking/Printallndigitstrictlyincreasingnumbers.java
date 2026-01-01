package BackTracking;

import A_PracticeLCS.MinNoDeletionPalindrom;

import java.util.Arrays;

public class Printallndigitstrictlyincreasingnumbers {
    public static void main(String[] args) {
        int n = 3;
        fun(new int[n], -1, 0,n);

    }

    static void fun(int[] arr, int parentEle, int index, int n){
        if(index==n || parentEle==9-n){
            System.out.println(new String(Arrays.toString(arr)));
            return;
        }

        for (int i = parentEle+1; i <=9; i++) {
                arr[index] = i;
                fun(arr, i, index+1, n);

        }
//        fun(arr, ++parentEle,index, n);
    }

    private static void swap(int temp, int[] arr, int index) {
        arr[index] = temp;
    }
}
