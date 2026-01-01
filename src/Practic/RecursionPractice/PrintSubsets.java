package Practic.RecursionPractice;

import java.util.Arrays;

public class PrintSubsets {
    public static void main(String[] args) {
        printSubsets("aabc");
    }

    static void printSubsets(String str){
        helper(str, "");
    }

    private static String helper(String str, String op){
        if(str.isEmpty()){
            System.out.print("["+op +"]" + " ");
            return "";
        }
        String op1 = helper(str.substring(1),op);
        String op2 = helper(str.substring(1), op + str.charAt(0));
        return "";
    }
}
