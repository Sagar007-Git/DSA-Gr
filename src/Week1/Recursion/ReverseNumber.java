package Week1.Recursion;

import java.util.Scanner;

public class ReverseNumber {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int num = scan.nextInt();
        System.out.println(recur(num));

    }
    static  int recur(int num){
        if(num%10==num)return num;
        return (num%10)*(int)Math.pow(10,(int)Math.log10(num)) + recur(num/10);
    }

}
