package DP;

import java.util.Arrays;

public class MemoUnboundedKnapSack {
    static int[][] memo;
    public static void main(String[] args) {
        int[] val = {1, 30};
        int[] wt = {1, 50};
        int W = 100;
        System.out.println(fun(wt,val,W));;
    }
    static int fun(int[] wt, int[] val, int W){
        memo = new int[wt.length+2][W+2];
        for(int[] row : memo) Arrays.fill(row,-1);
        return helper(wt,val,W,wt.length);
    }
    private static int helper(int[] wt, int[] val, int W, int n ){
        if(n==0 || W==0) return 0;
        if(memo[n][W]!=-1) return memo[n][W];

        if(wt[n-1]<=W){
            return memo[n][W] = Math.max ( val[n-1]+helper(wt,val,W-wt[n-1],n), helper(wt,val,W,n-1) );
        }

        return memo[n][W] = helper(wt,val,W,n-1);
    }
}
