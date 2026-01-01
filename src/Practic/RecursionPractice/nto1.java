package Practic.RecursionPractice;

import java.util.ArrayList;

public class nto1 {
    public static void main(String[] args) {
        System.out.println(helper(5,new ArrayList<>()));

    }
    static  ArrayList helper(int n, ArrayList<Integer> list){
        if(n==1){
            list.add(1);
            return list;
        }
        list.add(n);
        return helper(n-1, list);
    }
}
