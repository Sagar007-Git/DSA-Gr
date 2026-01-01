package BackTracking;

import java.sql.Statement;
import java.util.Scanner;

public class LargestnumberinKswaps {
    static String max = "0";
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        char[] arr = (scan.nextLine()).toCharArray();
        int k = scan.nextInt();
        max = new String(arr);
        fun(0,arr,arr.length,k);
        System.out.println(max);
    }
    static void fun(int index, char[] arr, int n, int k){
        if(k==0 || index==n){
           return;
        }
        char digit = maxDigit(index, arr);
        for (int i = index+1; i <n ; i++) {
            if(arr[i]==digit){
                swap(index, i, arr);
                String string = new String(arr);
                if((string).compareTo(max)>0){
                    max = string;
                    fun(index+1,arr,n,k-1);
                }
                swap(index,i,arr);
            }
        }
        fun(index+1,arr,n,k);
    }

    private static char maxDigit(int index, char[] arr) {
        char max = '0';
        while (index<arr.length){
            if(arr[index]>max) max = arr[index];
            index++;
        }
        return max;
    }

    private static boolean isLarger(int index, int i, char [] arr) {
        return arr[index]<arr[i];
    }

    private static void swap(int index, int i, char[] arr) {
        char temp = arr[i];
        arr[i] = arr[index];
        arr[index] = temp;
    }
}
