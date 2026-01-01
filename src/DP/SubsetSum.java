package DP;

public class SubsetSum {
    static Boolean[][] t;
    public static void main(String[] args) {
        int arr[] = {3, 34, 4, 12, 5, 2};
        int sum = 0;
        t = new Boolean[arr.length+1][sum+1];
        System.out.println(fun(arr,sum));
    }

    static boolean fun(int[] arr, int sum){
        return helper(arr,sum,0);
    }

    private static boolean helper(int[] arr, int sum, int iterator) {
        if(iterator== arr.length || sum<=0){
            if(sum<0 || (iterator== arr.length && sum!=0)){
                return false;
            }
            return true;
        }

        boolean left = helper(arr,sum-arr[iterator],iterator+1);
        boolean right = helper(arr, sum,iterator+1);
        return left || right;
    }

    private static boolean memoization(int[] arr, int sum, int iterator){
        if(sum==0) return true;
        if(sum<0 || iterator== arr.length) return false;
        if(t[iterator][sum]!=null) return t[iterator][sum];

        t[iterator][sum] = memoization(arr,sum-arr[iterator],iterator+1)|| memoization(arr,sum,iterator+1);
        return t[iterator][sum];

    }
}
