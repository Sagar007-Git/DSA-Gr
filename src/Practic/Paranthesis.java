package Practic;

public class Paranthesis {
    public static void main(String[] args) {
        fun("",3,3);
    }
    static void fun(String str, int open, int close){
        if(open==0){
            for (int i = 0; i <close; i++) {
                str+=")";
            }
            System.out.println("[ "+str+" ]");
            return;
        }
        if(open==close){
            fun(str+"(",open-1,close);
        } else {
            fun(str+"(",open-1,close);
            fun(str+")",open,close-1);
        }

    }
}
