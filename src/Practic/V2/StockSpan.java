package Practic.V2;

import java.util.Arrays;
import java.util.Stack;

public class StockSpan {
    public static void main(String[] args) {
        int[] arr = {100,80,60,70,60,75,85};
        System.out.println(Arrays.toString(fun(arr)));
    }

    static int[] fun(int[] arr){
        int[] res = new int[arr.length];
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < arr.length; i++) {
            while(!stack.isEmpty() && arr[stack.peek()]<=arr[i]){
                stack.pop();
            }
            if(stack.isEmpty()){
                res[i]= 1;
                stack.push(i);
            }else {
                res[i] = i-stack.peek();
                stack.push(i);
            }
        }
        return res;
    }
}
