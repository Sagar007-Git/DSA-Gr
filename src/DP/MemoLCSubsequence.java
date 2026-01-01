package DP;

import java.util.Arrays;

public class MemoLCSubsequence {
    static int[][] memo;
    public static void main(String[] args) {
        System.out.println(fun("ABC","CBA"));
    }
    static int fun(String x, String y){
        memo = new int[x.length()+1][y.length()+1];
        for(int[] row  : memo) Arrays.fill(row,-1);
        return helper(x,y,x.length(),y.length());
    }

    private static int helper(String x, String y, int m, int n) {
        if(m==0 || n==0) return 0;
        if(memo[m][n]!=-1) return memo[m][n];
        if(x.charAt(m-1)==y.charAt(n-1)) return memo[m][n] = 1 + helper(x.substring(0,x.length()-1),y.substring(0,y.length()),m-1,n-1);
        return memo[m][n] = Math.max(helper(x.substring(0,x.length()-1),y,m-1,n), helper(x,y.substring(0,y.length()-1),m,n-1));

    }
}
