package Practic.RecursionPractice;

import java.util.ArrayList;

public class printNBinaryNum {
    public static void main(String[] args) {
        System.out.println(solve(5));;
    }
    static ArrayList<String> solve(int N){
        ArrayList<String> list  = new ArrayList<>();
        return helper(list,N,0,0,"");
    }

    private static ArrayList<String> helper(ArrayList<String> list, int num, int zero, int one, String str){
        if(num==0){
            list.add(str);
            return list;
        }
        if(zero==one){
            helper(list,num-1,zero,one+1,str+"1");
        }else {
            helper(list,num-1,zero,one+1,str+"1");
            helper(list,num-1,zero+1,one,str+"0");
        }
        return list;
    }
}
