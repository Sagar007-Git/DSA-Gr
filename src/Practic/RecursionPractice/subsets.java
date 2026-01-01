package Practic.RecursionPractice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class subsets {
    public static void main(String[] args) {
    ArrayList<Integer> res = new ArrayList<>();
//        System.out.println(Subsetss(res,new int[] {1,2,3}));
        Subsets(res,new int[] {1,2,3});
    }
    static List<List<Integer>> Subsetss(ArrayList<Integer> res,int[] arr){

        if(arr.length<=0){
            List<List<Integer>> outer = new ArrayList<>();
            outer.add(res);
            return outer;
        }
        int a = arr[0];
        List<List<Integer>> left = new ArrayList<>();
        List<List<Integer>> right = Subsetss(res, Arrays.copyOfRange(arr, 1, arr.length));
        for (List<Integer> list : right) {
            List<Integer> newList = new ArrayList<>(list);
            newList.add(a);
            left.add(newList);
        }
        right.addAll(left);
        return right;
    }
    static void Subsets(ArrayList<Integer> res,int[] arr){

        if(arr.length==0){
//            List<List<Integer>> outer = new ArrayList<>();
//            outer.add(res);
//            System.out.println(res);
            return ;
        }
        int a = arr[0];
        List<List<Integer>> left = new ArrayList<>();
        List<List<Integer>> right = Subsetss(res, Arrays.copyOfRange(arr, 1, arr.length));
        for (List<Integer> list : right) {
            List<Integer> newList = new ArrayList<>(list);
            newList.add(a);
            left.add(newList);
        }
        right.addAll(left);
        System.out.println(right);

    }
}
