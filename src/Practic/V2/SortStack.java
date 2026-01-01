package Practic.V2;

import java.util.Stack;

public class SortStack {
    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        stack.push(2);
        stack.push(7);
        stack.push(5);
        stack.push(3);
        stack.push(8);
        stack.push(9);
        System.out.println(fun(stack));

    }

    static Stack<Integer> fun(Stack<Integer> stack){
        if(stack.isEmpty()){
            return stack;
        }
        int temp = stack.pop();
        fun(stack);
        Insert(stack,temp);
        return stack;

    }

    private static void Insert(Stack<Integer> stack, int temp) {
        if(stack.isEmpty() || stack.peek()<=temp){
            stack.push(temp);
            return;
        }

        int data = stack.pop();
        Insert(stack,temp);
        stack.push(data);

    }
}
