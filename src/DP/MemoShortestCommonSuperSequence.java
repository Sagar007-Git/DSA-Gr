package DP;

import java.util.Arrays;

public class MemoShortestCommonSuperSequence {
    static int[][] memo;
    static int len1;
    static int len2;
    public static void main(String[] args) {
        System.out.println(fun("AGGTAB","GXTXAYB"));
    }
    static int fun(String x, String y){
         len1 = x.length();
         len2= y.length();
        memo = new int[len1+1][len2+1];
        for(int[] row : memo) Arrays.fill(row,-1);
        return len2 + len1 - helper(x,y,x.length(),y.length());
    }

    private static int helper(String x, String y, int m, int n) {
        if(m==0 || n==0) return 0;
        if(memo[m][n]!=-1) return memo[m][n];

        if(x.charAt(m-1)==y.charAt(n-1)){
            return memo[m][n] =( 1 + helper(x,y,m-1,n-1));
        }
        return memo[m][n] = Math.max(helper(x,y,m-1,n),helper(x,y,m,n-1));
    }
}
