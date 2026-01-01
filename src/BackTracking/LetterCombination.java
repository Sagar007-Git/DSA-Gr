package BackTracking;

import java.util.ArrayList;

public class LetterCombination {
    public static void main(String[] args) {
        String[] padMap = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        fun("2389",padMap);
    }

    static void fun(String str, String[] lib){
        ArrayList<String> list = new ArrayList<>();
        helper(str, lib, "",list);
        System.out.println(list);
    }

    private static void helper(String str, String[] lib, String op, ArrayList<String> list) {
        if(str.length()==0){
            list.add(op);
            return;
        }

        for (int i = 0; i < lib[str.charAt(0) - '0'].length(); i++) {
            helper(str.substring(1,str.length()),lib,op+lib[str.charAt(0) - '0'].charAt(i),list);
        }

    }

}
