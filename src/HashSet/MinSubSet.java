package HashSet;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;

public class MinSubSet {
    public static void main(String[] args) {
        int arr[] = { 1 , 2 , 1 , 2 , 3 , 3 , 2 , 2};
        System.out.println(fun(arr));
    }
    static int fun(int arr[]){
        HashMap<Integer, Integer> map = new HashMap<>();
        int maxFreq = -1;
        for (int i = 0; i < arr.length; i++) {
            map.put(arr[i],map.getOrDefault(arr[i],0)+1);
            if(map.get(arr[i])>maxFreq){
                maxFreq = map.get(arr[i]);
            }
        }
        return maxFreq;

    }
}
