package Practic.RecursionPractice;

public class dhan {
    public static void main(String...Shushant) {
        fun(6);
    }

    static void fun(int n){
        if(n==0){
//            System.out.println(n);
            return;
        }
        fun(n-1);
        System.out.println(n);
    }
}
