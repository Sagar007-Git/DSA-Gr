package HashMap;

import javax.naming.PartialResultException;
import java.util.HashMap;

public class IsSubset {
    public static void main(String[] args) {
        int a[] = {11, 1, 13, 1,21, 3, 7,7};
        int b[] = {11, 3, 7, 1,7,7};
        System.out.println(fun(a,b));
    }
    static boolean fun(int[] a, int[] b){
        HashMap<Integer, Integer> hash = new HashMap<>();
        for (int i = 0; i < a.length; i++) {
            hash.put(a[i], hash.getOrDefault(a[i],0)+1);
        }
        for (int i = 0; i < b.length; i++) {
            if (hash.get(b[i])<=0){
                return false;
            }
            int val = hash.get(b[i]);
            val-=1;
            hash.put(b[i],val);
        }
        return true;
    }
}
