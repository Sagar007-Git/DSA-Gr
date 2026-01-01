package A_Random;

import java.util.Scanner;

public class CheckLenght {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        System.out.println(countGoodNumbers(n));

    }
    public static int countGoodNumbers(long n) {
        int res =1;
        for(int i=0; i<n; i++){
            res=res*((i%2==0)?5:4);
        }
        return res;
    }
}
