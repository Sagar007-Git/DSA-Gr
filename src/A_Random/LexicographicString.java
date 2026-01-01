package A_Random;

public class LexicographicString {
    public static void main(String[] args) {
        System.out.println(fun("abcda"));
    }
    static String fun(String str){
        if(str.length()==2) return str.substring(0,1);
        int len = str.length();
        StringBuilder res = new StringBuilder();
        int next = 1;
        for (int i = 0; i < len; i++) {
            if(i==len-1) return res.toString();
            if(str.charAt(i)-'a'>str.charAt(next)-'a'){
                res.append(str.substring(next,len));
                return res.toString();
            }
            res.append(str.charAt(i));
            next++;
        }
        return res.toString();
    }
}
