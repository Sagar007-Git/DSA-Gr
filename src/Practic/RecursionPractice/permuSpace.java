package Practic.RecursionPractice;

public class permuSpace {
    public static void main(String[] args) {
        solve("ABCDE");
    }

    static void solve(String str){
        helper("",str);
    }

    private static void helper(String op, String str){
        if(str.length()==1){
            System.out.print("["+op+str+"]");
            return;
        }

        char ch = str.charAt(0);
        helper(op+ch, str.substring(1));
        helper(op+ch+" ", str.substring(1));
        return;
    }

}
