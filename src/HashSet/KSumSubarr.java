package HashSet;
import java.util.HashSet;

//check whether the k sum subarray is present or no-
public class KSumSubarr {
    public static void main(String[] args) {
            int[] arr = {2, 8, 6, -6,3,2};
        System.out.println(fun(arr,5));
    }
    static boolean fun(int[] arr, int k){
        HashSet<Integer> set = new HashSet<>();
        int sum = 0;
        for (int num : arr){
            sum+=num;
            if (set.contains(sum-k)){
                return true;
            }
            set.add(sum);
        }
        return false;
    }
}
