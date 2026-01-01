package HashMap;

import java.util.HashMap;

public class LongSubarr0s1s {
    public static void main(String[] args) {
        int arr[] = {};
        System.out.println(fun(arr));
    }
    static int fun(int[] arr){
        HashMap <Integer,Integer> map = new HashMap<>();
        for(int num : arr){
            map.put(num, map.getOrDefault(num,0)+1);
        }
        if (!map.containsKey(0) || !map.containsKey(1)) return 0;
        return 2*Math.min(map.get(0),map.get(1));
    }
}
