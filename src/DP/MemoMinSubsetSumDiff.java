package DP;

import java.util.Arrays;

public class MemoMinSubsetSumDiff {
    static int[][] memo;
    static int totalSum;
    public static void main(String[] args) {
        System.out.println(fun(new int[]{3, 34, 4, 12, 5, 2}));
    }
    static int fun(int[] arr){
        totalSum = Arrays.stream(arr).sum();
        memo = new int[arr.length+1][totalSum+1];
        for(int[] row: memo) Arrays.fill(row,-1);
        return helper(arr,totalSum,0,arr.length, arr.length/2);
    }

    private static int helper(int[] arr, int totalSum, int sum, int n, int size) {
        if(size==0 ) return Math.abs((totalSum-sum)-sum);
        if(n==0) return totalSum;
        if (memo[n][sum]!=-1) return memo[n][sum];

        return memo[n][sum] = Math.min(helper(arr,totalSum,sum+arr[n-1],n-1,size-1),helper(arr,totalSum,sum,n-1,size));
    }
}
