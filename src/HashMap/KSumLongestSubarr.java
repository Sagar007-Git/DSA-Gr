package HashMap;

import java.util.ArrayList;
import java.util.HashMap;

public class KSumLongestSubarr {
    public static void main(String[] args) {
        int[] arr = {1,2,3,0,4,5,6};
        System.out.println(fun(arr,10));
    }
    static ArrayList<Integer> fun(int[] arr, int k){
        HashMap<Integer, Integer> map = new HashMap<>();
        ArrayList<Integer> res = new ArrayList<>();
        map.put(0,0);
        int sum=0;
        for (int i = 0; i < arr.length; i++) {
            sum+=arr[i];
            if(map.containsKey(sum-k)){
                int index = (map.get(sum-k)==-1) ? map.get(sum-k)+1 : map.get(sum-k);
                for (int j = index; j <= i; j++) {
                    res.add(arr[j]);
                }
            }
            map.put(sum,i);
        }
        return res;
    }
}
