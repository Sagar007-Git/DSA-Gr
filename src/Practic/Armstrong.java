package Practic;

public class Armstrong {
    public static void main(String[] args) {
        System.out.println(checkArmstrong(1634));
    }
    public static boolean checkArmstrong(int num){
        int temp = num;
        int digits = 0;
        int res = 0;
        while(temp!=0){
            temp/=10;
            digits++;
        }
        temp=num;
        while(temp!=0){
            int rem = temp%10;
            res+=(int)(Math.pow(rem,digits));
            temp/=10;
        }
        return res==num;
    }
}
