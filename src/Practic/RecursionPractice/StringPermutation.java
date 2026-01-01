package Practic.RecursionPractice;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class StringPermutation {
    public static void main(String[] args) {
        System.out.println(fun("ABC"));
    }
    static ArrayList<String> fun(String str){
        ArrayList<String> list = new ArrayList<>();
        return helper(str,"", list);
    }
    private static ArrayList<String> helper(String ip, String op, ArrayList<String> list ){
        if(ip.length()==0){
            list.add(op);
            return list;
        }

        for (int i = 0; i < ip.length(); i++) {
            String newOp = op + ip.charAt(i);
            String newIp = ip.substring(0,i) + ip.substring(i+1,ip.length());
            helper(newIp,newOp,list);
        }
        return list;
    }
}
