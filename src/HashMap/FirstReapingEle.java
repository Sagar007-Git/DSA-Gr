package HashMap;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class FirstReapingEle {
    public static void main(String[] args) {
        System.out.println(fun(new int[]{2, 13}));
    }
    static int fun(int[] arr){
        Map<Integer,Integer> map = new LinkedHashMap<>();
        for (int i = 0; i < arr.length; i++) {
                map.put(arr[i],map.getOrDefault(arr[i],0)+1);

        }
        for (Map.Entry<Integer,Integer> entry : map.entrySet()){
            if(entry.getValue()> (arr.length/2)){
                return entry.getKey();
            }
        }
        return -1;

    }
}
