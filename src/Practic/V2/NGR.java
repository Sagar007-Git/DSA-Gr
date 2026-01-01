package Practic.V2;

import java.util.Arrays;
import java.util.Stack;

public class NGR {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(fun(new int[]{1,3,2,4})));
    }

    static int[] fun(int... arr){
      int[] res = new int[arr.length];
        Stack<Integer> stack = new Stack<>();
        for (int i = arr.length-1; i >0; i--) {
            while(!stack.isEmpty() && stack.peek()<arr[i]){
                stack.pop();
            }
            if (stack.isEmpty()) {
                stack.push(arr[i]);
                res[i] = -1;
            } else {
                res[i] = stack.peek();
                stack.push(arr[i]);
            }
        }
        return res;
    }
}
