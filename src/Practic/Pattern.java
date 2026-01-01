package Practic;

public class Pattern {
    public static void main(String[] args) {
        fun(5);
    }
    static void fun(int num){
        int temp = num;
        while(temp!=-1){
            if(temp==0 || temp==num){
                for (int i = 0; i <=num; i++) {
                    if (i==num){
                        System.out.print("* ");
                    }else{
                        System.out.print("*");
                    }
                }
                System.out.println();
            }
            if(temp!=0 && temp!=num){
                for (int i = 0; i <=num; i++) {
                    if(i==0 || i==num){
                        System.out.print("* ");
                    }else {
                        System.out.print("  ");
                    }
                }
                System.out.println();
            }
            temp--;
        }
    }
}
