package Week1.Recursion;

import java.util.Scanner;

public class SumOfDigits {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int num = scan.nextInt();
        System.out.println(recur(num));

    }
    static int recur(int num){
        if(num==0) return 0;
        return num%10 + recur(num/10);
    }
}
