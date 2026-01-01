package Practic.RecursionPractice;

public class BalanceParenthesis {
    public static void main(String[] args) {
        solve(2);
    }

    static void solve (int val){
        helper("",val,val);
    }

    private static void helper(String str, int open, int close){
        if(open==0){
            for (int i=0; i<close; i++){
                str+=")";
            }
            System.out.print(" [-"+str+"-] ");
            return;
        }
        if(open==close){
            helper(str+"(",open-1,close);
        } else {
            helper(str+"(",open-1,close);
            helper(str+")", open,close-1);
        }
    }
}
