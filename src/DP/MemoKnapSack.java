package DP;

import java.util.Arrays;

public class MemoKnapSack {
    static int[][] dp;
    public static void main(String[] args) {
        int[] val = {40, -50, -100};
        int[] wt = {3, 2, 5};
        int W = 0;
        int col = val.length;
        dp= new int[col+1][W+1];
        for(int[] arr : dp){
            Arrays.fill(arr,-1);
        }
        System.out.println(fun(wt,val,W));
    }

    static int fun(int[] wt, int[] val, int W){
        return helper(wt,val,W,wt.length);
    }

    private static int helper(int[] wt, int[] val, int w, int n) {
        if(n==0 || w==0) return 0;
        if(dp[n][w]!=-1) return dp[n][w];

        if(wt[n-1]<=w){
            return dp[n][w] = Math.max(val[n-1]+helper(wt,val,w-wt[n-1],n-1), helper(wt,val,w,n-1) );
        }
        return dp[n][w] = helper(wt,val,w,n-1);
    }
}
