package A_Practice_String;

import java.util.HashSet;
import java.util.Set;

public class NumberofDistinctSubsequences {
    public static void main(String[] args) {
        System.out.println(fun(""));
    }
    static int fun(String str){
            int n = str.length();
        HashSet<String> set = new HashSet<>();
        set = helper("",str,n,set);
        return set.size();
    }
    private static HashSet<String> helper(String ip, String op, int n, HashSet<String> set){
        if(n==0){
            set.add(ip);
            return set;
        }
        helper(ip+op.charAt(0),op.substring(1),n-1,set);
        helper(ip,op.substring(1),n-1,set);
        return set;
    }
}
