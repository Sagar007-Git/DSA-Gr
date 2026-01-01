package A_PracticeLCS;

import java.util.Arrays;

public class LargestRepeatingSubSeq {
    static int[][] memo;
    public static void main(String[] args) {
        System.out.println(fun("aab"));
    }
    static int fun(String s){
        int m = s.length();
        memo = new int[m+1][m+1];
        for(int[] row : memo) Arrays.fill(row,  -1);
        return helper(s,s,m,m);
    }

    private static int helper(String s1, String s2, int m, int n) {
        if(m==0 || n==0) return 0;
        if(memo[m][n]!=-1) return memo[m][n];

        if(s1.charAt(m-1)==s2.charAt(n-1) && m-1!=n-1){
            return memo[m][n] = 1 + helper(s1,s2,m-1,n-1);
        }
        return memo[m][n] = Math.max(helper(s1,s2,m-1,n),helper(s1,s2,m,n-1));
    }
}
