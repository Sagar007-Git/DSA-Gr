package A_Random;

import java.util.Arrays;

public class MemoCoinChangeMin {
    static int[][] memo;
    public static void main(String[] args) {
        System.out.println(fun(new int[]{4, 6, 2},6));
    }

    static int fun(int[] arr, int sum){
        memo = new int[arr.length+1][sum+1];
        for(int[] row : memo) Arrays.fill(row,-1);
        return helper(arr,sum,arr.length);
    }

    private static int helper(int[] arr, int sum, int n) {
        if(sum==0) return 0;
        if(n==0) return 2-Integer.MAX_VALUE;
        if(memo[n][sum]!=-1) return memo[n][sum];
        if(arr[n-1]<=sum){
            int left = helper(arr,sum-arr[n-1],n);
            int right  = helper(arr,sum,n-1);
            return memo[n][sum] = Math.min(left+1,right);
        }

        return memo[n][sum] = helper(arr,sum,n-1);
    }
}
