package Practic;

import java.lang.reflect.Array;
import java.util.Arrays;

public class longestPrefix {
    public static void main(String[] args) {
        int[] arr = {4, 2, 4, 0, 0, 3, 0, 5, 1, 0};
        moveZeroes(arr);
        System.out.println(Arrays.toString(arr));

    }

    static public void moveZeroes(int[] nums) {
        int left = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                int temp = nums[left];
                nums[left] = nums[i];
                nums[i] = temp;
                left++;
                
            }
        }
    }
}
