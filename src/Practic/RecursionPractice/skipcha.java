package Practic.RecursionPractice;

public class skipcha {
    public static void main(String[] args) {
        System.out.println(Skippp('s',"","sagar"));
    }
    static String Skippp(char c ,String p,String up){
        if(up.length()==0){
            return p;
        }
        char a = up.charAt(0);
        if(a==c){
            return Skippp(c,p,up.substring(1));
        } else {
            return Skippp(c,p+a,up.substring(1));
        }

    }
}
