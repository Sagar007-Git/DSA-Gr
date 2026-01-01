package HashSet;

import java.util.HashSet;

public class IsSubset {
    public static void main(String[] args) {
        int[] a = {10, 5, 2, 23, 19};
        int[] b = {19, 5, 3};
        System.out.println(fun(a,b));
    }
    static boolean fun(int[] a, int[]b){
        HashSet<Integer> set = new HashSet<>();
        for(int num : a){
            set.add(num);
        }
        for (int num : b){
            if(!set.contains(num)){
                return false;
            }
        }
        return true;
    }
}
