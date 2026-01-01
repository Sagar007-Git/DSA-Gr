package Week1.Recursion;

import java.util.Scanner;

public class NbitNumbers {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        recursion(new StringBuilder(""),n, n, n);

    }

    static void recursion(StringBuilder op, int ones, int zeros, int n){
        if(n==0){
            if (ones<=zeros) {
                System.out.print(op + " ");
            }
            return;
        }

            op.append(1);
            recursion(op, ones-1, zeros, n-1);
            op.deleteCharAt(op.length()-1);
        if(ones<zeros){
            op.append(0);
            recursion(op, ones,zeros-1, n-1);
            op.deleteCharAt(op.length()-1);
        }

    }
}
