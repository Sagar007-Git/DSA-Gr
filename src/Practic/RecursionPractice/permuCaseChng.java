package Practic.RecursionPractice;

public class permuCaseChng {
    public static void main(String[] args) {
        solve("A1b2");
    }

    static void solve(String str){
        helper(str,"");
    }

    private static void helper(String str, String op ){
        if(str.isEmpty()){
            System.out.print("["+op+"]");
            return;
        }

        char ch = str.charAt(0);
        if(Character.isDigit(ch)){
            helper(str.substring(1), op + ch);
        }
        else{
            helper(str.substring(1), op + checkChar(ch));
            helper(str.substring(1), op + ch);
        }

    }

    private static char checkChar(char ch){
        if(Character.isDigit(ch)){
            return ch;
        } else if(Character.isUpperCase(ch)){
            return Character.toLowerCase(ch);
        } else {
            return Character.toUpperCase(ch);
        }
    }

}
