package Week1.Recursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class SortArray {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        ArrayList<Integer> arr = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            arr.add(scan.nextInt());
        }
        System.out.println(arr);
        sort(arr);
        System.out.println(arr);

    }
    static void sort(ArrayList<Integer> arr){
        if(arr.size()==0) return;
        int temp = arr.remove(arr.size()-1);
        sort(arr);
        insert(temp, arr);

    }

    static void insert(int val, ArrayList<Integer> arr){
        if(arr.size()==0 || arr.get(arr.size()-1)<val){
            arr.add(val);
            return;
        }
        int temp = arr.remove(arr.size()-1);
        insert(val,arr);
        arr.add(temp);
    }
}
