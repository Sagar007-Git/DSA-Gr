package Stacks;

import java.security.spec.RSAOtherPrimeInfo;
import java.util.Arrays;
import java.util.Stack;

public class histogramMaxArea {
    public static void main(String[] args) {
        System.out.println(solve(new int[]{2,1,3,2,2,7}));
    }
    static int solve(int[] arr){
        int len = arr.length;
        Stack<Integer> stack = new Stack<>();
        int[] right = new int[len];
        for (int i = 0; i < len; i++) {
            while(!stack.isEmpty() && arr[stack.peek()]>=arr[i]){
                stack.pop();
            }

            if (stack.isEmpty()){
                right[i] = -1;
                stack.push(i);
            } else {
                right[i] = stack.peek();
                stack.push(i);
            }
        }
            stack.clear();

        int[] left = new int[len];
        for (int i = len-1; i >=0; i--) {
            while(!stack.isEmpty() && arr[stack.peek()]>=arr[i]){
                stack.pop();
            }

            if (stack.isEmpty()){
                left[i] = len;
                stack.push(i);
            } else {
                left[i] = stack.peek();
                stack.push(i);
            }
        }
        int res =-1;
        for (int i = 0; i < right.length; i++) {
            int net  = left[i] - right[i] -1;
            int  Area = net*arr[i];
            if(res<Area){
                res = Area;
            }
        }
        return res;
    }
}
