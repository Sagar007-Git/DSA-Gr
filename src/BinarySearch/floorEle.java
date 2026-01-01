package BinarySearch;

public class floorEle {
    public static void main(String[] args) {
        System.out.println(solve(new int[]{2,3,4,6,8,9,11,13,14},1));
    }

    static int solve(int[] arr,int tar){
        int start = 0;
        int end =arr.length-1;
        while(start<=end){
            int mid  = start + (end-start)/2;
            if(tar==arr[mid]){
                return mid;
            } else if (tar>arr[mid]) {
                start = mid+1;
            } else {
                end = mid-1;
            }
        }
        return start;
    }
}
