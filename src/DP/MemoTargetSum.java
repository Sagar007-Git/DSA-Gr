package DP;

import CHechCheck.HeroTreeSingleFunction;

import java.util.Arrays;

public class MemoTargetSum {
    static int[][] memo;
    public static void main(String[] args) {
        System.out.println(fun(new int[]{1, 1, 1, 1, 1},3));
    }

    static int fun(int[] arr, int sum){
        int totalSum = Arrays.stream(arr).sum();
        memo = new int[arr.length+1][(totalSum*2)+1];
        for (int[] row : memo) Arrays.fill(row,-1);
        return helper(arr,sum,arr.length,totalSum);
    }

    private static int helper(int[] arr, int sum, int n,int totalSum) {
        if(n==0) return sum == 0 ? 1 : 0;
        if (sum>totalSum || sum<-totalSum) return 0;
        if(memo[n][sum+totalSum]!=-1) return memo[n][sum+totalSum];
        return memo[n][sum+totalSum] = helper(arr,sum-arr[n-1],n-1,totalSum) + helper(arr,sum+arr[n-1],n-1,totalSum);
    }
}
