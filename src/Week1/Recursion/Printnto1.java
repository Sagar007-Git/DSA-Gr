package Week1.Recursion;

import java.util.Scanner;

public class Printnto1 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
//        Nto1(n);
        oneToN(n);
    }
    static void Nto1(int n){
        if(n==0) return;
        System.out.print(n+" ");
        Nto1(n-1);
    }

    static void oneToN(int n){
        if(n==0) return;
        oneToN(n-1);
        System.out.print(n+" ");
    }
}
