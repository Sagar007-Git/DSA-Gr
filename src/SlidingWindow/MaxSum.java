package SlidingWindow;

public class MaxSum {
    public static void main(String[] args) {
        int arr[] = {-1, 1, -1, -1, -1, -1};
        System.out.println(maxSumSubArray(arr, 3));
    }

    static int maxSumSubArray(int[] arr, int subArray){
        int sum = 0;
        int maxSum = Integer.MIN_VALUE;

        for (int i = 0; i < subArray; i++) {
            sum+=arr[i];
        }

        for(int i=subArray; i<arr.length; i++){
            sum+= arr[i] - arr[i-subArray];
            if(sum>maxSum){
                maxSum = sum;
            }
        }

        return maxSum;
    }
}
