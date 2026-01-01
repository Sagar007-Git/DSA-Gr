package LL;

import java.util.Arrays;

public class main {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(twoSum(new int[] {3,2,4},6)));
    }
    public static int[] twoSum(int[] nums, int target) {
        for(int i=0; i<nums.length;i++){
            int j=i+1;
            while(j<nums.length) {
                if(target==nums[i]+nums[j]){
                    return new int[] {i,j};
                }
                j++;
            }
        }
        return null;
    }
}
