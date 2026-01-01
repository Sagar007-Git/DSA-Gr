package HashSet;

import java.util.*;

public class DistiinctPairSum {
    public static void main(String[] args) {
        System.out.println(fun(new int[] {1, 5, 7, -1, 5,1},6));
    }
//    static ArrayList<ArrayList<Integer>> fun(int[] arr,int tar){
//        Hash  Set<Integer> set  = new HashSet<>();
//        ArrayList<ArrayList<Integer>> list = new ArrayList<>();
//        for (int i = 0; i < arr.length; i++) {
//            if(set.contains(tar-arr[i])){
//                ArrayList<Integer> temp = new ArrayList<>();
//                temp.add(arr[i] );
//                temp.add(tar-arr[i]);
//                list.add(temp);
//            }
//            set.add(arr[i]);
//
//        }
//        HashSet <ArrayList<Integer>> res = new HashSet<>();
//        for (ArrayList<Integer> nums : list){
//            res.add(nums);
//        }
//        list.clear();
//        list.addAll(res);
//        return list;
//
//    }
        static Set<List<Integer>> fun(int[] arr,int tar){
            Set<Integer> seen = new HashSet<>();
            Set<List<Integer>> result = new HashSet<>();
            for (int i = 0; i < arr.length; i++) {
                int complement = tar-arr[i];
                if(seen.contains(tar-arr[i])){
                    List<Integer> list  = Arrays.asList(arr[i],complement);
                    Collections.sort(list);
                    result.add(list);
                }
                seen.add(arr[i]);
            }
            return result;

        }


}
