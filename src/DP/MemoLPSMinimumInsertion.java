package DP;

import java.util.Arrays;

public class MemoLPSMinimumInsertion {
    static int[][] memo;

    public static void main(String[] args) {
        System.out.println(fun("geeks"));
    }
    static int fun(String x){
        int m = x.length();
        memo = new int[m+1][m+1];
        for(int[] row : memo) Arrays.fill(row,-1);
        int LCS = helper(x,0,m);
        return m-LCS;
    }

    private static int helper(String x, int m, int n) {
        if(m>n-1) return 0;
        if(memo[m][n]!=-1) return memo[m][n];
        if(x.charAt(m)!=x.charAt(n-1)){
            return memo[m][n] = 1 + Math.max(helper(x,m+1,n),helper(x,m,n-1));
        }
        return memo[m][n] = helper(x,m+1,n-1);
    }
}
