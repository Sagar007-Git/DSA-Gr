package BackTracking;

public class Permutation {
    public static void main(String[] args) {
        fun("ABCD","");
    }
    static void fun(String ip, String op){
        if(ip.isEmpty()) {
            System.out.print(op + " ");
            return;
        }
        for (int i = 0; i <=op.length(); i++) {
            fun(ip.substring(1), op.substring(0,i)+ip.charAt(0)+op.substring(i));
        }

    }
}
