package DP;

import java.util.Arrays;

public class MemoEqualSumPartition {
    static Boolean dp[][];
    public static void main(String[] args) {
        int[] arr = {0};
        System.out.println(fun(arr));
    }

    static boolean fun(int[] arr){
        if (arr.length==0) return false;

        int totalSum = Arrays.stream(arr).sum();
        if(totalSum%2!=0) return false;
        dp= new Boolean[arr.length+1][(totalSum/2)+1];
        return helper(arr,totalSum/2,arr.length);
    }

    private static boolean helper(int[] arr, int sum, int n) {
        if(sum==0) return true;
        if(n==0 || sum<0) return false;
        if(dp[n][sum]!=null) return dp[n][sum];

        if(arr[n-1]<=sum){
            return dp[n][sum]=helper(arr,sum-arr[n-1],n-1) || helper(arr, sum,n-1);
        }
        return dp[n][sum]=helper(arr, sum,n-1);
    }
}
