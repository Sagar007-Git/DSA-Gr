package DP;

public class TargetSum {
    static int count;
    public static void main(String[] args) {
        count=0;
        System.out.println(fun(new int[]{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1},1));
    }

    static int fun(int[] arr, int tar){
        return helper(arr,tar,0);
    }

    private static int helper(int[] arr, int tar, int iterator) {
        if(iterator==arr.length){
            if(tar==0){
                count+=1;
                return count;
            }
           return count;
        }

        helper(arr,tar-arr[iterator],iterator+1);
        helper(arr,tar+arr[iterator],iterator+1);
        return count;
    }
}
