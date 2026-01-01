package Week1.Recursion;

import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

public class SortStack {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < n; i++) {
            stack.push(scan.nextInt());
        }
        sort(stack);
        while (!stack.isEmpty()) System.out.print(stack.pop()+" ");


    }

    static void sort(Stack<Integer> stack){
        if(stack.isEmpty()) return;
        int temp = stack.pop();
        sort(stack);
        insert(temp, stack);
    }

    static void insert(int val, Stack<Integer> stack){
        if(stack.isEmpty() || stack.peek()>val){
            stack.add(val);
            return;
        }
        int temp = stack.pop();
        insert(val, stack);
        stack.add(temp);
    }
}
