package Practic.RecursionPractice;

import jdk.jfr.FlightRecorderListener;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();
        list.add(2);
        list.add(4);
        list.add(6);
        list.add(7);
        list.add(9);
        list.add(0);
        list.add(1);
        list.add(5);
        System.out.println(Sort(list));


    }
    public static List<Integer> Sort(ArrayList<Integer> list){
        if(list.size()==1){
            return list;
        }
        int temp = list.remove(list.size()-1);
        Sort(list);
        Insert(list,temp);
        return list;
    }

    private static List<Integer> Insert(ArrayList<Integer> list, int temp){
        if(list.size()==0 || list.get(list.size()-1)<=temp){
            list.add(temp);
            return list;
        }
        int data = list.remove(list.size()-1);
        Insert(list,temp);
        list.add(data);
        return list;
    }
}
