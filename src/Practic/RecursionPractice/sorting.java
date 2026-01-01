package Practic.RecursionPractice;

import java.util.ArrayList;

public class sorting {

    public static void main(String[] args) {
        ArrayList<Integer> arr = new ArrayList<>();
        arr.add(3);
        arr.add(1);
        arr.add(4);
        arr.add(2);

        System.out.println("Original Array: " + arr);

        sort(arr);

        System.out.println("Sorted Array: " + arr);
    }
    static void sort(ArrayList<Integer> arr){
        if(arr.size()==1){
            return;
        }
        int temp = arr.remove(arr.size()-1);
        sort(arr);
        insert(arr, temp);
    }

    private static void insert(ArrayList<Integer> arr, int temp){
        if(arr.size()==0 || arr.get(arr.size()-1)<=temp){
            arr.add(temp);
            return;
        }

        int val = arr.remove(arr.size()-1);
        insert(arr, temp);
        arr.add(val);
    }
}
