package DP;

public class MemoSubset {
    static Boolean[][] dp;
    public static void main(String[] args) {
        int[] arr = {3, 34, 4, 12, 5, 2};
        int tar = 9;
        dp = new Boolean[arr.length+1][tar+1];
        System.out.println(fun(arr,tar));;
    }

    static Boolean fun(int[] arr, int tar){
        return helper(arr,tar,arr.length);
    }

    private static Boolean helper(int[] arr, int tar, int iterator) {
        if(tar==0) return true;
        if(iterator==0 && tar!=0) return false;

        if(dp[iterator][tar]!=null) return dp[iterator][tar];

        if(arr[iterator-1]<=tar){
            return dp[iterator][tar] = helper(arr,tar-arr[iterator-1],iterator-1) || helper(arr,tar,iterator-1);
        }
        return dp[iterator][tar] = helper(arr,tar,iterator-1);
    }
}
