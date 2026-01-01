package BackTracking;

import java.util.ArrayList;

public class PossiblePallindrom {
    public static void main(String[] args) {
        fun("aasgaa");
    }

    static void fun(String str){
        ArrayList<ArrayList<String>> list = new ArrayList<>();
        ArrayList<String> res = new ArrayList<>();
        helper(str,res,list);
        System.out.println(list);
    }

    private static void helper(String str, ArrayList<String> res, ArrayList<ArrayList<String>> list) {
        if(str.length()==0){
            list.add(new ArrayList<>(res));
            return;
        }

        for (int i = 0; i < str.length(); i++) {
            if(isPalindrome(i,str)){
                res.add(str.substring(0,i+1));
                helper(str.substring(i+1,str.length()),res,list);
                res.removeLast();
            }
        }
        return;

    }

    private static boolean isPalindrome(int i, String str) {
        int start = 0;
        while(start<=i){
            if(str.charAt(i)!=str.charAt(start)){
                return false;
            }
            start++;
            i--;
        }
        return true;
    }
}
