package Practic.RecursionPractice;

import java.util.Stack;

public class ReverseStack {
    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        stack.add(1);
        stack.add(4);
        stack.add(7);
        stack.add(3);
        stack.add(2);
        System.out.println(stack);
        reverse(stack);
        System.out.println(stack);
    }

    static void reverse(Stack<Integer> stack){
        if(stack.size()==0){
            return;
        }
        int num = stack.pop();
        reverse(stack);
        helper(stack,  num);
    }

    private static void helper(Stack<Integer> stack, int num){
        if(stack.size()==0){
            stack.push(num);
            return;
        }
        int val = stack.pop();
        helper(stack,num);
        stack.add(val);
    }
}
