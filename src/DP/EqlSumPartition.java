package DP;

public class EqlSumPartition {
    public static void main(String[] args) {
        System.out.println(fun(new int[]{1,5,5}));
    }

    static boolean fun(int[] arr){
        int sum=0;
        if(arr.length==0) return false;
        for(int a : arr){
            sum+=a;
        }
        return helper(arr,sum,0,0);
    }

    private static boolean helper(int[] arr, int sum, int curSum, int iterator) {
        if(curSum==sum-curSum) return true;
        if(iterator==arr.length || curSum>sum-curSum) return false;
        return helper(arr,sum,curSum+arr[iterator],iterator+1) || helper(arr,sum,curSum,iterator+1);

    }
}
