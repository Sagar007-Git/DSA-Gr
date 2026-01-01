package LL;
public class NodeJump {
    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5,6,7,8,9};
        fun(arr,4);
    }
    static void fun(int arr[], int tar){
        int mid = arr.length/2;
        helper(arr, 0, arr.length-1, tar);
    }

    private static void helper(int[] arr, int start, int end, int tar){
        int mid = start +(end -start)/2;
        if(arr[mid]==tar){
            System.out.println(mid);
            return;
        }
        if(arr[mid]>tar){
            helper(arr, start, mid-1, tar); //<----
        } else if (arr[mid]<tar) {
            helper(arr, mid+1,end, tar); ///<----
        }
    }
}
