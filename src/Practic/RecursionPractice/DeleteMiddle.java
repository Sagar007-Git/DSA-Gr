package Practic.RecursionPractice;

import java.util.Stack;

public class DeleteMiddle {
    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        stack.add(1);
        stack.add(4);
        stack.add(7);
        stack.add(3);
        stack.add(2);
        stack.add(8);
        System.out.println(stack);
        deleteMiddle(stack);
        System.out.println(stack);
    }

    static void deleteMiddle(Stack<Integer> stack){
        int index = (stack.size()-1)/2;
        helper(stack, index);
    }

    private static void  helper(Stack<Integer> stack, int count){
        if(count==0){
            stack.pop();
            return;
        }

        int temp = stack.pop();
        helper(stack,count-1);
        stack.push(temp);
    }
}
