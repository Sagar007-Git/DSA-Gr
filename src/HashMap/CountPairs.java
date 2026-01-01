package HashMap;

import java.util.HashMap;

public class CountPairs {
    public static void main(String[] args) {
        int arr[] = {1, 5, 7, -1, 5};
        int target = 6;
        System.out.println(fun(arr,target));
    }
    static int fun(int[] arr, int tar){
        HashMap<Integer, Integer> hash = new HashMap<>();
        int count = 0;
        for (int i = 0; i < arr.length; i++) {
            hash.put(arr[i], hash.getOrDefault(arr[i],0)+1);
        }
        for (int i = 0; i < arr.length; i++) {
            if( hash.get(arr[i])>0 && hash.get(tar-arr[i])>0){
                int val =hash.get(tar-arr[i]);
                count+=val;
                hash.put(tar-arr[i],0);
                hash.put(arr[i],0);
            }
        }

        return count;
    }
}
