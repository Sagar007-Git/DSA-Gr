package Practic.RecursionPractice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Sumtriangle {
    public static void main(String[] args) {
        int[] numbers = {1, 2, 3, 4, 5};
        ArrayList<Integer> numbersList = new ArrayList<>();
        for (int number : numbers) {
            numbersList.add(number);
        }
        System.out.println(sum1(numbersList));
    }
    static void sum(int arr[]){
        if(arr.length==1){
            return;
        }
        int[] res = new int[arr.length-1];
        for (int i = 0; i < arr.length-1; i++) {
            res[i] = arr[i] +arr[i+1];
        }
        System.out.println(Arrays.toString(res));
        sum(res);
    }

    static List<List<Integer>> sum1(ArrayList<Integer> arr) {
        List<List<Integer>> outer = new ArrayList<>();
        if (arr.isEmpty()){
            outer.add(arr);
            return outer;
        }
        ArrayList<Integer> internal = new ArrayList<>();
        for (int i = 0; i < arr.size() - 1; i++) {
            internal.add((arr.get(i) + arr.get(i + 1)));
        }
        List<List<Integer>> res = sum1(internal);
        return sum1(internal);



    }
}
