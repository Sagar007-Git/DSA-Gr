package A_Random;

import java.util.Arrays;

public class RemoveElement {
    public static void main(String[] args) {
        System.out.println(removeElement(new int[]{3,3}, 5));
    }

    public static int removeElement(int[] arr, int val) {
        int i=0;
        if(arr.length==1){
            if(arr[0]==val) return i;
            else return 1;
        }
        int j=1;
        while(i<arr.length &&  j<arr.length){
            if(arr[i]!=val) {
                i++;
                while(i>=j) j++;
            }
            else if(arr[j]!=val){
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
                j++;
            }else j++;
        }
        System.out.println(Arrays.toString(arr));
        return i+1;
    }
}
