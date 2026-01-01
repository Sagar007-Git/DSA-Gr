package Practic.RecursionPractice;

import java.util.Stack;

public class SortingStack {
    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        stack.add(1);
        stack.add(4);
        stack.add(7);
        stack.add(3);
        stack.add(2);
        System.out.println(stack);
        sort(stack);
        System.out.println(stack);


    }

    static void sort(Stack<Integer> stack){
        if(stack.size()==1){
            return;
        }
        int temp = stack.pop();
        sort(stack);
        insert(stack, temp);

    }

    private static void insert(Stack<Integer> stack, int temp){
        if(stack.size()==0 || stack.peek()<=temp){
            stack.add(temp);
            return;
        }

        int val = stack.pop();
        insert(stack, temp);
        stack.add(val);
    }
}
