package Stacks;

import javax.swing.text.SimpleAttributeSet;
import java.util.Arrays;
import java.util.Stack;

public class StockSpan {
    public static void main(String[] args) {
        int[] arr = {100,80,60,70,60,75,85};
        System.out.println(Arrays.toString(solve(arr)));
    }
    static int[] solve(int[] arr) {

        int[] res = new int[arr.length];
        Stack<Integer> stack = new Stack<>();

        for(int i=0; i<arr.length; i++){
            while(!stack.isEmpty() && arr[i]>arr[stack.peek()]){
                stack.pop();
            }
            if(!stack.isEmpty()){
                res[i] = i - stack.peek();
                stack.push(i);
            } else {
                stack.push(i);
                res[i] = 1;
            }
        }
        return res;
    }
}
