package Blind75;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSum {
    public static void main(String[] args) {
        System.out.println(fun(new int[]{-1,0,1,2,-1,-4}));
    }

    static List<List<Integer>> fun(int[] arr){
            return helper(arr,0,new ArrayList<>(),new ArrayList<>());
    }

    private static List<List<Integer>> helper(int[] arr, int sum,  List<Integer> sublist, List<List<Integer>> list){

        if( arr.length==0 || sublist.size()==3){
            if(sum==0 && sublist.size()==3 ){
                list.add(sublist);
                return list;
            }
            return list;
        }
        int temp = arr[0];
        List<Integer> includeSublist = new ArrayList<>(sublist);
        List<List<Integer>> left = helper(Arrays.copyOfRange(arr,1, arr.length),sum,includeSublist,list);
        sublist.add(temp);

        List<Integer> excludeSublist = new ArrayList<>(sublist);
        List<List<Integer>> right = helper(Arrays.copyOfRange(arr,1, arr.length),sum+temp,excludeSublist,list);

        return list;

    }
}
