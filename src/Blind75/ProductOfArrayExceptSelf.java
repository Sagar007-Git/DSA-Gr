package Blind75;

import java.util.Arrays;
import java.util.Stack;

public class ProductOfArrayExceptSelf {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(stackFun(new int[]{1,2,3,4})));
    }

    static int[] normalFun(int[] arr){
        int[] res = new int[arr.length];
        int prd = 1;
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length; j++) {
                if(i!=j){
                    prd*=arr[j];
                }
            }
            res[i] = prd;
            prd = 1;
        }
        return res;
    }

    static int[] stackFun(int[] arr){
        Stack<Integer> stack1 = new Stack<>();
        Stack<Integer> stack2 = new Stack<>();
        for (int i = 0; i < arr.length; i++) {
            stack1.push(i);
        }
        for (int i = 0; i < arr.length; i++) {
            int prd = 1;

            if(stack2.isEmpty()){
                int j= arr.length-1;

                while (j>=0){
                    if(i!=j){
                        int temp = stack2.push(stack1.pop());
                        prd*=arr[temp];
                    }
                    j--;
                }
                arr[i] = prd;

            } else {

                int j=0;

                while (j< arr.length){
                    if(i!=j){
                        int temp = stack1.push(stack2.pop());
                        prd*=arr[temp];
                    }
                    j++;
                }

                arr[i] = prd;
            }
        }
        return arr;
    }


}
