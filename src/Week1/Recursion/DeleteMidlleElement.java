package Week1.Recursion;

import java.util.Scanner;
import java.util.Stack;

public class DeleteMidlleElement {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < n; i++) {
            stack.push(scan.nextInt());
        }
        recur(stack, (n+1)/2);
        while (!stack.isEmpty()){
            System.out.print(stack.pop()+" ");
        }

    }
    static void recur(Stack<Integer> stack, int n){
        if(n==1) {
            stack.pop();
            return;
        };
        int temp = stack.pop();
        recur(stack,n-1);
        stack.add(temp);
    }
}
