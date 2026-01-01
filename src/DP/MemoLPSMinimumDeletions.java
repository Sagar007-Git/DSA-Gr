package DP;

import java.util.Arrays;

public class MemoLPSMinimumDeletions {
    static int[][] memo;

    public static void main(String[] args) {
        System.out.println(fun("aba"));
    }
    static int fun(String x){
        int m = 0;
        int n = x.length();
        memo = new int[n+1][n+1];
        for(int[] row : memo) Arrays.fill(row, -1);;
        return n - helper(x,m,n);
    }

    private static int helper(String x, int m, int n) {
        if(m==n-1) return 0;
        if(memo[m][n]!=-1) return memo[m][n];

        if(x.charAt(m)==x.charAt(n-1)) {
            int count = 2;
            if(m==n-1) count=1;
            return memo[m][n] = count + helper(x,m+1,n-1);

        }
        return memo[m][n] = Math.max(helper(x,m+1,n),helper(x,m,n-1));
    }
}
