package DP;

import java.util.Arrays;

public class MemoCoinChangeMinNumberOfCoins {
    static int[][] memo;
    public static void main(String[] args) {
        System.out.println(fun(new int[]{9, 6, 5, 1},19));
    }

    static int fun(int[] arr, int sum){
        memo = new int[arr.length+1][sum+1];
        for(int[] row : memo) Arrays.fill(row,-1);
        return helper(arr,sum,arr.length);
    }

    private static int helper(int[] arr, int sum, int n) {
        if(sum==0) return 0;
        if(n==0) return Integer.MAX_VALUE;
        if(memo[n][sum]!=-1) return memo[n][sum];
        if(arr[n-1]<=sum){
            int check = helper(arr,sum-arr[n-1],n);
            if(check!=Integer.MAX_VALUE) check+=1;
            return memo[n][sum] = Math.min(check,helper(arr,sum,n-1));
        }
        return memo[n][sum] = helper(arr,sum,n-1);
    }
}
