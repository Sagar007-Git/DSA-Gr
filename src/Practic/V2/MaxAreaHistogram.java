package Practic.V2;

import java.util.Stack;

public class MaxAreaHistogram {
    public static void main(String[] args) {
        System.out.println(fun(new int[]{2,1,3,2,2,7}));
    }

    static int fun(int... arr) {
        int[] res1 = new int[arr.length];
        Stack<Integer> stack = new Stack<>();
        for (int i = arr.length - 1; i >= 0; i--) {
            while (!stack.isEmpty() && arr[stack.peek()] >= arr[i]) {
                stack.pop();
            }
            if (stack.isEmpty()) {
                stack.push(i);
                res1[i] = arr.length;
            } else {
                res1[i] = stack.peek();
                stack.push(i);
            }
        }
        stack.clear();
        int[] res2 = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            while (!stack.isEmpty() &&  arr[stack.peek()]>= arr[i]) {
                stack.pop();
            }
            if (stack.isEmpty()) {
                stack.push(i);
                res2[i] = -1;
            } else {
                res2[i] = stack.peek();
                stack.push(i);
            }
        }
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < res1.length; i++) {
            int net = res1[i] - res2[i] - 1;
            int area = net*arr[i];
            if(max<area){
                max=area;
            }

        }
        return max;
    }
}
