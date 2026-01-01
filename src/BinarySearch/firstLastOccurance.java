package BinarySearch;

public class firstLastOccurance {
    public static void main(String[] args) {
        System.out.println(firstOcc(new int[]{0,1,1,2,2,2,2,2,2,3,4},2));
    }
    static int firstOcc(int[] arr, int tar){
        int start = 0;
        int end = arr.length;
        int res = -1;
        while(start<=end){
            int mid = start + (end -start)/2;
            if(arr[mid]==tar){
                res = mid;
                start = mid+1; // { end  = mid -1 }  -----for last occurance
            }else if(arr[mid]>tar){
                end = mid-1;
            }else {
                start = mid+1;
            }
        }
        return res;
    }
}
