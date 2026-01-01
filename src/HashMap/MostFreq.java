package HashMap;

import java.util.HashMap;

public class MostFreq {
    public static void main(String[] args) {
        int[] arr  = {2, 3, 4, 2, 5, 6, 3, 8, 5, 2, 4, 2, 2, 2, 2};
        System.out.println(fun(arr));
    }
    static  int fun(int arr[]){
        HashMap<Integer,Integer> hash = new HashMap<>();
        int maxFreq = 0;
        int ans = -1;
        for (int i = 0; i < arr.length; i++) {
            hash.put(arr[i], hash.getOrDefault(arr[i],0)+1 );
            if(hash.get(arr[i])>maxFreq){
                maxFreq = hash.get(arr[i]);
                ans = arr[i];
            }
        }
        System.out.println("freq : " + maxFreq );
        return ans;
    }
}
