package DP;

public class minSumOfDiffSubset {
    static int temp;
    public static void main(String[] args) {
        System.out.println(fun(new int[]{1, 6, 11, 5}));
    }

    static int fun(int[] arr){
        int sum=0;
        for(int a : arr){
            sum+=a;
        }
        temp = arr[0];
        return helper(arr,sum,0, 0);
    }

    private static int helper(int[] arr, int sum, int curSum, int itertor) {
        if(itertor==arr.length) {
            if(temp>sum-curSum){
                temp=sum-curSum;
            }
            return temp;
        }
        return Math.min(helper(arr,sum,curSum+arr[itertor],itertor+1),helper(arr,sum,curSum,itertor+1));
    }
}
