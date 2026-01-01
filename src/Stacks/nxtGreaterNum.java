package Stacks;

import java.util.Arrays;
import java.util.Stack;

public class nxtGreaterNum {
    public static void main(String[] args) {
        int[] arr = {1,3,2,4};
        System.out.println(Arrays.toString(solve(arr)));
    }

    static int[] solve(int[] arr){
        int[] res = new int[arr.length];
        Stack<Integer> stack = new Stack<>();
        for (int i = arr.length-1; i >= 0; i--) {
            while (!stack.isEmpty() && arr[i]<stack.peek()){
                stack.pop();
            }
            if(stack.isEmpty()){
                stack.push(arr[i]);
                res[i] = -1;
            } else{
                res[i] = stack.peek();
                stack.push(arr[i]);
            }
        }
        return res;
    }
}
