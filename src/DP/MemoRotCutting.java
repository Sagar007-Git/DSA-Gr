package DP;

import java.util.Arrays;

public class MemoRotCutting {
    static int[][] memo;
    public static void main(String[] args) {
        System.out.println(fun(new int[]{3}));
    }

    static int fun(int[] arr){
//        int sum = Arrays.stream(arr).sum();
        memo = new int[arr.length+1][arr.length+1];
        for(int[] row : memo) Arrays.fill(row,-1);
        return helper(arr,arr.length,arr.length);
    }

    private static int helper(int[] arr, int n,int iteration) {
        if(n==0 || iteration==0) return 0;
        if(memo[n][iteration]!=-1) return memo[n][iteration];

        if(n-iteration>=0){
            return memo[n][iteration] = Math.max(arr[iteration-1] + helper(arr,n-iteration,iteration),helper(arr,n,iteration-1) );
        }
        return memo[n][iteration] = helper(arr,n,iteration-1);
    }


}
