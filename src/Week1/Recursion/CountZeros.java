package Week1.Recursion;

import java.util.Scanner;

public class CountZeros {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int num = scanner.nextInt();
        System.out.println(count(num));

    }
    static int count(int num){
        if(num%10==num){
            if (num==0) return 1;
            else return 0;
        }
        return ((num%10==0) ? 1:0) + count(num/10);
    }
}
