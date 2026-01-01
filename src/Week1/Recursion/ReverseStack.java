package Week1.Recursion;

import javax.swing.text.SimpleAttributeSet;
import java.util.Scanner;
import java.util.Stack;

public class ReverseStack {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int  n = scan.nextInt();
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < n; i++) {
            stack.add(scan.nextInt());
        }

        reverse(stack);
        while (!stack.isEmpty()) System.out.print(stack.pop()+" ");

    }

    static void reverse(Stack<Integer> stack){
        if(stack.isEmpty()) return;
        int temp = stack.pop();
        reverse(stack);
        insert(temp, stack);
    }

    static void insert(int temp, Stack<Integer> stack){
        while (stack.isEmpty()){
            stack.add(temp);
            return;
        }
        int val = stack.pop();
        insert(temp, stack);
        stack.add(val);
    }
}
